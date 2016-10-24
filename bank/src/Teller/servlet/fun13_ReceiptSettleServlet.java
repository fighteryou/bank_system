package Teller.servlet;

import java.io.*;
import java.net.Socket;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;



public class fun13_ReceiptSettleServlet extends HttpServlet {
	
public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
{
		//���ô��ݺͽ��ղ����ı���
    	resp.setCharacterEncoding("GBK");
		req.setCharacterEncoding("GBK");
		
		String path = this.getServletContext().getRealPath("/");
		System.out.println(path);

		try {
			//������Ϣǰ��֯����
			SAXReader reader = new SAXReader();
			Document doc = reader.read(new File(path + "WEB-INF/classes/model.xml")); 
			Node node = doc.selectSingleNode("ROOT/HEAD/TRAN_CODE"); //����Ҷ�ӽڵ�
		    node.setText("receiptsettle");	
		    

		  //  String id = ""+Calendar.getInstance().getTimeInMillis()+ Thread.currentThread().getId();
		  
		    HttpSession ses = req.getSession();
			
			
			Enumeration<?> paramNames = req.getParameterNames(); //��ȡ���еĲ���
			while (paramNames.hasMoreElements()) {
				String paramName = paramNames.nextElement().toString();
				String[] paramValues = req.getParameterValues(paramName);

				Element element = (Element) doc.selectSingleNode("ROOT/BODY/SVR_MESSAGE_IN");//���ø��ڵ�
				Element el = element.addElement(paramName);		
				el.setText(paramValues[0]);
			}
			Element root = doc.getRootElement();
			String teller2esb = root.asXML();
	
			
			//���ͱ���
			String url="127.0.0.1";
			int port=8888;			
	        resp.setContentType("text/html");     //�����ı�����       
	        Socket s=new Socket(url,port);   //����socketͨ��,���ӷ�����
	        System.out.println("TELLER���Ѿ��ɹ������ӵ�ESB�ˣ�");	 
	        PrintWriter pw=new PrintWriter(s.getOutputStream(),true);     //��װ���������	        
	        pw.println(teller2esb);//��socketͨ��д����Ϣ
	        System.out.println("TELLER���Ѿ��ɹ�����ESB�˷�����Ϣ  "+teller2esb);
	        
	        
	        //���ս��
	        BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
            //��socketͨ��ȡ����˷��صĽ��
            String result=br.readLine();
            System.out.println("TELLER���Ѿ��ɹ��Ĵ�ESB�˽��յ���Ӧ��Ϣ " +result);       
			ses.setAttribute("receiptsettle_info", result);
			
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		req.getRequestDispatcher("fun13_receiptsettle.jsp").forward(req, resp);
		
	}
	

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}

}