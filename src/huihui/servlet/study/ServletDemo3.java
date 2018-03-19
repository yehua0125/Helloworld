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
		          * ������ܽ���(Accept)������������: 
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
		//ʹ��content-type��Ӧͷָ�����͸����������������"image/jpeg"
		//��ȡλ����Ŀ��Ŀ¼�µ�img�ļ��������WP_20131005_002.jpg����ͼƬ������һ��������
		InputStream in = this.getServletContext().getResourceAsStream("/image/4.jpg");
		byte buffer[] =new byte[1024];
		int len=0;
		
		ServletOutputStream out=response.getOutputStream();//�õ������
		
		while((len = in.read(buffer)) > 0){//��ȡ������in��������ݴ洢��������
			out.write(buffer,0,len);//������������������������
		}
			
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		this.doGet(request, response);
		
	}

}
