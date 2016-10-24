package Esb.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Calendar;


import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Node;

import Esb.dao.ServerCheckDao;


public class ESBListener implements Runnable {

	private JMSToolsOperate tools=new JMSToolsOperate();
	private Socket s;
	
	public ESBListener(Socket s){
		this.s=s;
	}
	
	public void run() {
		try {
			BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
			PrintWriter pw=new PrintWriter(s.getOutputStream(),true);
			
			//���մ�TELLER�˷�������Ϣ
			String str;
			String teller2esb="";
			while ((str = br.readLine())!= null) // �ж����һ�в����ڣ�Ϊ�ս���ѭ��
			{
				teller2esb+=str;
				if(str.equals("</ROOT>"))
					break;
			}
		
			System.out.println("ESB���Ѿ��ɹ��Ľ��յ�TELLER�˵�������Ϣ "+teller2esb);
						
			//ESB�յ���Ϣ���������
			Document doc1 = DocumentHelper.parseText(teller2esb);
			Node node1 = doc1.selectSingleNode("ROOT/HEAD/TRAN_CODE"); //��ȡҶ�ӽڵ�
			System.out.println("teller�˷����ķ�������Ϊ��"+node1.getText());
			
			String messageid = ""+Calendar.getInstance().getTimeInMillis()+ Thread.currentThread().getId();
			System.out.println("messageid:"+messageid);
			if(new ServerCheckDao().getCheck(node1.getText())!=null){
				//����Ϣ������Ϣ����E2C��
				tools.sendMsg(teller2esb, "E2C",messageid);
				System.out.println("ESB���Ѿ��ɹ�������Ϣ����E2C������Ϣ "+teller2esb);	
			}			
			
			//����Ϣ����C2E��ȡ����Ϣ
			String result=tools.receiveMsg("C2E",messageid);
			System.out.println("ESB���Ѿ��ɹ��Ĵ���Ϣ����C2E��ȡ����Ӧ��Ϣ "+result);
								
			//��������Ϣ����TELLER��
			pw.println(result);
			System.out.println("ESB���Ѿ��ɹ�����TELLER�˷�����Ӧ��Ϣ "+result);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		catch (DocumentException e) {
			e.printStackTrace();
		}

	}

}




