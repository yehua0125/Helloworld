package huihui.servlet.study;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.zip.GZIPOutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo2 extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String data="asdfasdfasfsafsafasdfsadfsadf";
		System.out.println("ԭʼ���ݴ�С�� "+ data.getBytes().length);
		
		ByteArrayOutputStream bout=new ByteArrayOutputStream();
		GZIPOutputStream gout=new GZIPOutputStream(bout);//buffer
		gout.write(data.getBytes());
		gout.close();
		//�õ�ѹ����
		byte g[]=bout.toByteArray();
		response.setHeader("Content-Encoding", "gzip");
		response.setHeader("Content-Length", g.length+"");
		response.getOutputStream().write(g);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
		
	}

}
