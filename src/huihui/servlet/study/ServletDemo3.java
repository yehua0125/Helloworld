package huihui.servlet.study;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.ImageIcon;

import org.omg.CORBA_2_3.portable.OutputStream;

public class ServletDemo3 extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		          * 浏览器能接收(Accept)的数据类型有: 
		          * application/x-ms-application, 
		          * image/jpeg, 
		          * application/xaml+xml, 
		          * image/gif, 
		          * image/pjpeg, 
		          * application/x-ms-xbap, 
		          * application/vnd.ms-excel, 
		          * application/vnd.ms-powerpoint, 
		          * application/msword, 
		          */
		
		response.setHeader("content-type", "image/jpeg");
		//使用content-type响应头指定发送给浏览器的数据类型"image/jpeg"
		//读取位于项目根目录下的img文件夹里面的WP_20131005_002.jpg这张图片，返回一个输入流
		InputStream in = this.getServletContext().getResourceAsStream("/image/4.jpg");
		byte buffer[] =new byte[1024];
		int len=0;
		
		ServletOutputStream out=response.getOutputStream();//得到输出流
		
		while((len = in.read(buffer)) > 0){//读取输入流in里面的内容存储到缓冲区
			out.write(buffer,0,len);//将缓冲区的内容输出到浏览器
		}
			
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		this.doGet(request, response);
		
	}

}
