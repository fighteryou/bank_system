package ensemble.server;

import Esb.server.JMSToolsOperate;
import javax.jms.*;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;




public class CoreServer extends Thread implements
MessageListener, ExceptionListener {
// ConnectionFactory �����ӹ�����JMS ������������
ConnectionFactory connectionFactory;
// Connection ��JMS �ͻ��˵�JMS Provider ������
Connection connection = null;
// Session�� һ�����ͻ������Ϣ���߳�
Session session;
// Destination ����Ϣ��Ŀ�ĵ�
Destination destination;
//��Ϣ������
MessageConsumer consumer;

public CoreServer() {
String url = "tcp://localhost:61616";
// ��ActiveMq��console���õ�queue������
String queue ="E2C";
connectionFactory = new ActiveMQConnectionFactory(
		ActiveMQConnection.DEFAULT_USER,
		ActiveMQConnection.DEFAULT_PASSWORD, url);
// ����ӹ����õ����Ӷ���
try {
	connection = connectionFactory.createConnection();
	connection.setExceptionListener(this);// �쳣����
	connection.start();// ��������
	//���Ϊtrue��������������Ϣû�б�ȡ�ߣ���������
	session = connection.createSession(false,
			Session.AUTO_ACKNOWLEDGE);
	// ��ȡsession�� 
	destination = session.createQueue(queue);
	consumer = session.createConsumer(destination);
} catch (JMSException e) {
	System.err.println("Create fail!");
	e.printStackTrace();
}
}

public void run() {
try {
	consumer.setMessageListener(this);
} catch (JMSException e) {
	System.err
			.println(" MessageListener failed...");
	e.printStackTrace();
}
}

public void onMessage(Message message) {
try {
	if (message instanceof TextMessage) {
		TextMessage txtMsg = (TextMessage) message;
		String msg = txtMsg.getText();
		System.out.println("CoreServer!!!!");
		System.out.println("msg:"+msg);
		String messageid = txtMsg.getStringProperty("MessageID");
	System.out.println("messageid:"+messageid);
		 JMSToolsOperate tools=new JMSToolsOperate();
		 new Thread(new CoreListener(msg,tools,messageid)).start();

	}
} catch (JMSException e) {
	System.err
			.println("The process of getting a message failed...");
	e.printStackTrace();
}
}
// �첽��Ϣ�쳣����
public void onException(JMSException arg0) {
System.err.println("JMS�쳣��");
}
//���Գ���
public static void main(String[] args) {
CoreServer jrl = new CoreServer();
jrl.start();
System.out.println("Core��������");
}
}



//public class CoreServer {
//	
//	public static void main(String[] args){
//		  System.out.println("CORE���Ѿ�������");
//		  JMSToolsOperate tools=new JMSToolsOperate();
//		  while(true){
//			//����Ϣ������ȡ����Ϣ
//				 String message=tools.receiveMsg("E2C","null");
//				
//				 String a[] = message.split("!"); 
//				 new Thread(new CoreListener(a[0],tools,a[1])).start();
//		  }
			 
//	}
//
//}
