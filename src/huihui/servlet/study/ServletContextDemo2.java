package huihui.servlet.study;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletContextDemo2 extends HttpServlet {

	public void doGet(HttpServletRequest request,HttpServletResponse response) 
		throws ServletException,IOException{
		ServletContext context=this.getServletContext();
		String data=(String) context.getAttribute("data");
		response.getWriter().print("data ="+ data);
		
	}
		
	public void doPost(HttpServletRequest request,HttpServletResponse response)
		throws ServletException,IOException{
		this.doGet(request, response);
		
	}
	
}

