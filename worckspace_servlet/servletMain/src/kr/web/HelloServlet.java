package kr.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//contentType(����Ÿ��(=html))�� charset ����
		response.setContentType("text/html;charset=UTF-8");
		
		//��� ��Ʈ�� ����
		PrintWriter out = response.getWriter();
		//HTML �±׸� ���ڿ��� ���
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Hello Servlet</title>");
		out.println("<body>");
		out.println("ó�� �ۼ��ϴ� Servlet �Դϴ�.");
		out.println("</body>");
		out.println("</head>");
		out.println("</html>");
		//��Ʈ�� �ݱ�(�ڿ� ����)
		out.close();
		
	}
		
}
