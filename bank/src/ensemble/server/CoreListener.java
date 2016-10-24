package ensemble.server;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Node;

import ensemble.dao.*;
import Esb.server.JMSToolsOperate;


public class CoreListener implements Runnable{
	
	private String esb2core;
	private JMSToolsOperate tools;
	private String messageid;
	
	public CoreListener(String s,JMSToolsOperate tools,String messageid)
	{
		this.esb2core=s;
		this.tools=tools;
		this.messageid=messageid;
		
	}
	
	public void run() {
		 System.out.println("CORE���Ѿ��ɹ��Ĵ���Ϣ����E2C��ȡ����Ϣ "+esb2core);				 
			
		 System.out.println("messageid:"+messageid);
		 //����Ϣ���д���
		 try{
		 //ensemble�յ���Ϣ���������
		 Document doc1 = DocumentHelper.parseText(esb2core);
		 Node node1 = doc1.selectSingleNode("ROOT/HEAD/TRAN_CODE"); //��ȡҶ�ӽڵ�
		 System.out.println("esb�˷����ķ�������Ϊ��"+node1.getText());

		 String core2esb="";
		 
		 //�ͻ�ע��
		 if(node1.getText().equals("clientregister"))
		 {
			 if(new fun6_ClientRegisterDao().clientregister(esb2core)==0)					 						 	
				core2esb="success";
			 else						 	
				core2esb="failure"; 
		 }
		 
		 //�����
		 else if(node1.getText().equals("loancreate"))
		 {
			 String ensemble2esb=null;
			 if((ensemble2esb=new fun7_LoanCreateDao().loancreate(esb2core))!=null)
				core2esb=ensemble2esb;
			 else						 	
				core2esb="failure"; 
		 }
		 
		 
		//��ѯ�˻�
		 else if(node1.getText().equals("checkaccount"))
		 {
			 String ensemble2esb=null;
			 if((ensemble2esb=new fun8_CheckAccountDao().checkaccount(esb2core))!=null)
				core2esb=ensemble2esb;
			 else						 	
				core2esb="failure"; 
		 }
		 
		 
		 //�����
		 else if(node1.getText().equals("drawdown"))
		 {
			 if(new fun9_DrawdownDao().drawdown(esb2core)==0)
				core2esb="success";
			 else						 	
				core2esb="failure"; 
		 }
		 
		 
		//����Ž���
		 else if(node1.getText().equals("settlepay"))
		 {
			 if(new fun10_SettlePayDao().settlepay(esb2core)==0)
				core2esb="success";
			 else						 	
				core2esb="failure"; 
		 }
		 
		 
		 //֪ͨ��
		 else if(node1.getText().equals("invoice"))
		 {
			 String ensemble2esb=null;
			 if((ensemble2esb=new fun11_InvoiceDao().invoice(esb2core))!=null)
				core2esb=ensemble2esb;
			 else						 	
				core2esb="failure"; 
		 }
		 
		 
		 //�������
		 else if(node1.getText().equals("loanreceipt"))
		 {
			 if(new fun12_LoanReceiptDao().loanreceipt(esb2core)==0)					 						 	
				core2esb="success";
			 else						 	
				core2esb="failure"; 
		 }
		 
		 	
		 
		 //������ս���
		 else if(node1.getText().equals("receiptsettle"))
		 {
			
			 if(new fun13_ReceiptSettleDao().receiptsettle(esb2core)==0)
				core2esb="success";
			 else						 	
				core2esb="failure"; 
		 }
				 
		 
		 //�˻�����
		 else if(node1.getText().equals("acctcreate"))
		 {

			 if((new fun14_AcctCreateDao().acctcreate(esb2core))==0)
				core2esb="success";
			 else						 	
				core2esb="failure"; 
		 }
		 
		 
		 
		tools.sendMsg(core2esb, "C2E",messageid);
		System.out.println("CORE���Ѿ��ɹ�������Ϣ����C2E�з��ʹ�������Ϣ "+core2esb);
		 
		
		}catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
