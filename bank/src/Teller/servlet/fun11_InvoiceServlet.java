package Teller.servlet;

import java.io.*;
import java.net.Socket;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;


public class fun11_InvoiceServlet extends HttpServlet {
	
public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
{
		//设置传递和接收参数的编码
    	resp.setCharacterEncoding("GBK");
		req.setCharacterEncoding("GBK");
		
		String path = this.getServletContext().getRealPath("/");
		System.out.println(path);
		
		try {
			//发送消息前组织报文
			SAXReader reader = new SAXReader();
			Document doc = reader.read(new File(path + "WEB-INF/classes/model.xml")); 
			Node node = doc.selectSingleNode("ROOT/HEAD/TRAN_CODE"); //设置叶子节点
		    node.setText("invoice");	
			
			Enumeration<?> paramNames = req.getParameterNames(); //获取所有的参数
			while (paramNames.hasMoreElements()) {
				String paramName = paramNames.nextElement().toString();
				String[] paramValues = req.getParameterValues(paramName);

				Element element = (Element) doc.selectSingleNode("ROOT/BODY/SVR_MESSAGE_IN");//设置父节点
		if(paramName.equals("loankey")||paramName.equals("ddno"))
		{
					Element el = element.addElement(paramName);
					el.setText(paramValues[0]);					 
		}		
				
			}
			
			Element root = doc.getRootElement();
			String teller2esb = root.asXML();

			
			//发送报文
			String url="127.0.0.1";
			int port=8888;			
	        resp.setContentType("text/html");     //设置文本类型       
	        Socket s=new Socket(url,port);   //建立socket通信,连接服务器
	        System.out.println("TELLER端已经成功的连接到ESB端！");	 
	        PrintWriter pw=new PrintWriter(s.getOutputStream(),true);     //封装输入输出流	        
	        pw.println(teller2esb);//向socket通道写入消息
	        System.out.println("TELLER端已经成功的向ESB端发送消息  "+teller2esb);
	        
	        
	        //接收结果
	        BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
	        
	      //从socket通道取出后端返回的结果
	        String str;
			String esb2teller="";
			while ((str = br.readLine())!= null) // 判断最后一行不存在，为空结束循环
			{
				esb2teller+=str;
				if(str.endsWith("</ROOT>"))					
					break;
			}			
			
			
			System.out.println("TELLER端已经成功的从ESB端接收到响应消息 " +esb2teller);
	        
	        //teller收到消息后解析报文
			Document doc1 = DocumentHelper.parseText(esb2teller);
			Node a1 = doc1.selectSingleNode("ROOT/BODY/SVR_MESSAGE_OUT/a1"); //获取叶子节点
			System.out.println(a1.getText());
			Node a2 = doc1.selectSingleNode("ROOT/BODY/SVR_MESSAGE_OUT/a2"); //获取叶子节点
			System.out.println(a2.getText());
			Node a3 = doc1.selectSingleNode("ROOT/BODY/SVR_MESSAGE_OUT/a3"); //获取叶子节点
			System.out.println(a3.getText());
			Node a4 = doc1.selectSingleNode("ROOT/BODY/SVR_MESSAGE_OUT/a4"); //获取叶子节点
			System.out.println(a4.getText());
			Node a5 = doc1.selectSingleNode("ROOT/BODY/SVR_MESSAGE_OUT/a5"); //获取叶子节点
			System.out.println(a5.getText());       

			
	        HttpSession ses = req.getSession();
			ses.setAttribute("a1", a1.getText());
			ses.setAttribute("a2", a2.getText());
			ses.setAttribute("a3", a3.getText());
			ses.setAttribute("a4", a4.getText());
			ses.setAttribute("a5", a5.getText());
			
			req.getRequestDispatcher("fun11_invoice.jsp").forward(req, resp);		
			
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		
	}
	

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}

}