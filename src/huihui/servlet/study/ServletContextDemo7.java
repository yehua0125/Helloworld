package huihui.servlet.study;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.MessageFormat;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ����װ������ȡ��Դ�ļ�
 * ͨ����װ������ȡ��Դ�ļ���ע������:���ʺ�װ�ش��ļ�������ᵼ��jvm�ڴ����
 */

public class ServletContextDemo7 extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 /**
         * response.setContentType("text/html;charset=UTF-8");Ŀ���ǿ����������UTF-8���н��룻
         * �����Ͳ����������������
         */
        response.setHeader("content-type","text/html;charset=UTF-8");
        test1(response);
        response.getWriter().println("<hr/>");
        test2(response);
        response.getWriter().println("<hr/>");
        //test3();
        test4();
	}
	 /**
     * ��ȡ��·���µ���Դ�ļ�
     * @param response
     * @throws IOException
     */
    private void test1(HttpServletResponse response) throws IOException {
        //��ȡ��װ�ص�ǰ�����װ����
        ClassLoader loader = ServletContextDemo7.class.getClassLoader();
        //����װ������ȡsrcĿ¼�µ�db1.properties�����ļ�
        InputStream in = loader.getResourceAsStream("db1.properties");
        Properties prop = new Properties();
        prop.load(in);
        String driver = prop.getProperty("driver");
        String url = prop.getProperty("url");
        String username = prop.getProperty("username");
        String password = prop.getProperty("password");
        response.getWriter().println("����װ������ȡsrcĿ¼�µ�db1.properties�����ļ���");
        response.getWriter().println(
                MessageFormat.format(
                        "driver={0},url={1},username={2},password={3}", 
                        driver,url, username, password));
    }

    /**
     * ��ȡ��·�����桢���������Դ�ļ�
     * @param response
     * @throws IOException
     */
    private void test2(HttpServletResponse response) throws IOException {
        //��ȡ��װ�ص�ǰ�����װ����
        ClassLoader loader = ServletContextDemo7.class.getClassLoader();
        //����װ������ȡsrcĿ¼�µ�gacl.servlet.study���е�db4.properties�����ļ�
        InputStream in = loader.getResourceAsStream("/huihui/servlet/study/db4.properties");
        Properties prop = new Properties();
        prop.load(in);
        String driver = prop.getProperty("driver");
        String url = prop.getProperty("url");
        String username = prop.getProperty("username");
        String password = prop.getProperty("password");
        response.getWriter().println("����װ������ȡsrcĿ¼�µ�gacl.servlet.study���е�db4.properties�����ļ���");
        response.getWriter().println(
                MessageFormat.format(
                        "driver={0},url={1},username={2},password={3}", 
                        driver,url, username, password));
    }
    
    /**
     * ͨ����װ������ȡ��Դ�ļ���ע������:���ʺ�װ�ش��ļ�������ᵼ��jvm�ڴ����
     */
    public void test3() {
        /**
         * 01.avi��һ��150��M���ļ���ʹ���������ȥ��ȡ������ļ�ʱ�ᵼ���ڴ������
         * java.lang.OutOfMemoryError: Java heap space
         */
        InputStream in = ServletContextDemo7.class.getClassLoader().getResourceAsStream("01.avi");
        System.out.println(in);
    }
    
    /**
     * ��ȡ01.avi,��������e:\��Ŀ¼��
     * 01.avi�ļ�̫��ֻ����servletContextȥ��ȡ
     * @throws IOException
     */
    public void test4() throws IOException {
        // path=G:\Javaѧϰ��Ƶ\JavaWebѧϰ��Ƶ\JavaWeb\day05��Ƶ\01.avi
        // path=01.avi
        String path = this.getServletContext().getRealPath("/WEB-INF/classes/1.mp4");
        /**
         * path.lastIndexOf("\\") + 1��һ���ǳ������д��
         */
        String filename = path.substring(path.lastIndexOf("\\") + 1);//��ȡ�ļ���
        InputStream in = this.getServletContext().getResourceAsStream("/WEB-INF/classes/1.mp4");
        byte buffer[] = new byte[1024];
        int len = 0;
        OutputStream out = new FileOutputStream("e:\\" + filename);
        while ((len = in.read(buffer)) > 0) {
            out.write(buffer, 0, len);
        }
        out.close();
        in.close();
    }
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
