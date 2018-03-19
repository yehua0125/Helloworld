package huihui.servlet.study;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletContextDemo1 extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String data= "xdp_huiuih";
		/**
		 * ServletConfig对象中维护了ServletContext对象的引用，开发人员在编写servlet时，
		 * 可以通过SerletConfig.getServletContext方法来获取servletContext对象
		 */
		ServletContext context=this.getServletConfig().getServletContext();//获得ServletContext对象
		context.setAttribute("data", data);//将data存储到ServletContext对象中。
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		
	}

}
