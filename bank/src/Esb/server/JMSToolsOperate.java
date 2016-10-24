package Esb.server;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.benchmark.Consumer;

public class JMSToolsOperate {
	// ���岢�������ӹ���
	private ConnectionFactory factory = new ActiveMQConnectionFactory(
			"tcp://localhost:61616");
	// ���嵽��Ϣ���е�����
	private Connection connection;
	// ���屾�����ӵĻỰ
	private Session session;

	public void sendMsg(String message, String queueName,String messageid) {
		try {
			// ��������
			connection = factory.createConnection();
			// ������
			connection.start();
			// �����������ӵĻỰ
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			// ����һ����Ϣ���У���������д�����ʹ��֮�����򴴽�֮
			Destination queue = session.createQueue(queueName);
			// ����һ����Ϣ
			Message msg = session.createTextMessage(message);
			msg.setStringProperty("MessageID", messageid);
			
			// ����һ��������,����Ϣ�ķ����ߣ���ָ����Ҫ������Ϣ��Ŀ�ĵأ�����Ϣ���У�
			MessageProducer producer = session.createProducer(queue);
			// ������Ϣ
			producer.send(msg);
			// �ͷ���Դ

		} catch (JMSException e) {
			e.printStackTrace();
		} finally {
			try {
				session.close();
				connection.close();
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
	}

	public String receiveMsg(String queueName,String messageid) {
		String messagetext = null;
		String code=null;
		try {
			connection = factory.createConnection();
			connection.start();
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			Destination queue = session.createQueue(queueName);
			// ����һ����Ϣ�������ߣ�����Ϣ�Ľ����ߣ���ָ�����Ľ���Ŀ�ĵأ������ĸ���Ϣ������ȡ��Ϣ��
			MessageConsumer consumer;
			if(messageid.equals("null"))
				consumer = session.createConsumer(queue);
			else
				consumer = session.createConsumer(queue,"MessageID="+"'"+messageid+"'");
			// ������Ϣ
			TextMessage msg =  (TextMessage) consumer.receive();
			messagetext = msg.getText();
			if(messageid.equals("null"))
				code=msg.getStringProperty("MessageID");		    
			// �ͷ���Դ
			session.close();
			connection.close();
		} catch (JMSException e) {
			e.printStackTrace();
		} finally {
			try {
				session.close();
				connection.close();
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
		if(messageid.equals("null"))
			return messagetext+"!"+code;
		System.out.println("ESB���յ�ENSEMBLE����Ϣ���е���Ϣ��"+messagetext);
		return messagetext;
	}
}
