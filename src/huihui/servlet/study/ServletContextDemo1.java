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
		 * ServletConfig������ά����ServletContext��������ã�������Ա�ڱ�дservletʱ��
		 * ����ͨ��SerletConfig.getServletContext��������ȡservletContext����
		 */
		ServletContext context=this.getServletConfig().getServletContext();//���ServletContext����
		context.setAttribute("data", data);//��data�洢��ServletContext�����С�
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		
	}

}
