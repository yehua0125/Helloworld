package huihui.servlet.study;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletContextDemo4 extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response)
		throws ServletException,IOException{
		String data = "<h1><font color='red'>huihuizaixuexi</font></h1>";
		response.getOutputStream().write(data.getBytes());
		ServletContext context=this.getServletContext();//��ȡservletcontext����
		RequestDispatcher rd= context.getRequestDispatcher("/servlet/ServletContextDemo5");
		//��ȡ����ת������(requestDispatcher)
		rd.forward(request, response);
		//����forward����ʵʱ����ת��
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)
	throws ServletException,IOException{
		doGet(request, response);
		
	}
}