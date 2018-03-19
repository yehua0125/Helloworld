package huihui.servlet.study;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA_2_3.portable.OutputStream;

public class ServletDemo5 extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * ����content-disposition��Ӧͷ��������������ļ�
		 */
		response.setHeader("content-disposition", "attachment;filename=xxx.jpg");
		InputStream in =this.getServletContext().getResourceAsStream("/image/4.jpg");
		byte buffer[] = new byte[1024];
		int len=0;
		ServletOutputStream out =response.getOutputStream();
		while((len=in.read(buffer)) > 0){
			out.write(buffer,0,len);
		
		}
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
		
	}

}
