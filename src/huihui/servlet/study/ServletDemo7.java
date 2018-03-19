package huihui.servlet.study;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo7 extends HttpServlet {

	/**
	 * ����ServletConfig�������������õĳ�ʼ������
	 */
	private ServletConfig config;
	/**
	 * ��servlet�����˳�ʼ��������web�����ڴ���servletʵ������ʱ��
	 * ���Զ�����Щ��ʼ��������װ��servletConfig�����У����ڵ���servlet��init����ʱ��
	 * ��servletconfig���󴫵ݸ�servlet������������Աͨ��servletconfig����Ϳ��Եõ�
	 * ��ǰservlet�ĳ�ʼ������
	 */
	
	@Override
	public void init(ServletConfig config) throws ServletException{
		this.config=config;
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//��ȡ��web.xml�����õĳ�ʼ������
		String paramVal=this.config.getInitParameter("name");
		response.getWriter().print(paramVal);
		
		response.getWriter().print("<hr/>");
		//��ȡ���еĳ�ʼ������
		Enumeration<String> e = config.getInitParameterNames();
		while(e.hasMoreElements()){
			String name= e.nextElement();
			String value= config.getInitParameter(name);
			response.getWriter().print(name + "=" + value + "<br/>");
			
		}
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
		
	}

}
