package huihui.servlet.study;

import java.io.IOException;
import java.io.PrintWriter;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletContextDemo3 extends HttpServlet {
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)
		throws ServletException, IOException{
		ServletContext context=this.getServletContext();
		//��ȡ����webվ��ĳ�ʼ������
		String contextInitParam= context.getInitParameter("url");
		response.getWriter().print(contextInitParam);
		
	}

	public void doPost(HttpServletRequest request,HttpServletResponse response)	
		throws ServletException,IOException{
		doGet(request, response);
		
	}
	
}
