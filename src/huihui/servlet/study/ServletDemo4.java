package huihui.servlet.study;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo4 extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/**
		 * ����refresh��Ӧͷ���������ÿ��3�붨ʱˢ��
		 */
		//response.setHeader("refresh", "3");
		/**
		 * ����refresh��Ӧͷ���������3�����ת��http://www.baidu.com
		 */
		response.setHeader("refresh", "3;url='http://www.baidu.com'");
		response.getWriter().write("hpgdsys");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
		
	
	}

}
