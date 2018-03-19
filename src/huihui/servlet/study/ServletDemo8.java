package huihui.servlet.study;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo8 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String data="adfasdfadsfdasf";
		 /**
         * 设置数据合理的缓存时间值，以避免浏览器频繁向服务器发送请求，
         * 提升服务器的性能
         * 这里是将数据的缓存时间设置为1天
         */
		
		response.setDateHeader("expires",
				System.currentTimeMillis() + 24 * 3600 * 1000);
		response.getOutputStream().write(data.getBytes());
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
