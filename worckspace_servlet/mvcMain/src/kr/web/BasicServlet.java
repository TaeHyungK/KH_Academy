package kr.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BasicServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//����Ʈ Ÿ�� ����
		resp.setContentType("text/html;charset=UTF-8");
		
		//��½�Ʈ�� ����
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head><title>�⺻���� ����</title></head>");
		out.println("<body>");
		out.println("<ul>");
		out.println("	<li>����</li>");
		out.println("	<li>�뱸</li>");
		out.println("	<li>����</li>");
		out.println("	<li>�λ�</li>");
		out.println("</ul>");
		out.println("</body>");
		out.println("</html>");
		
		//�ڿ� ����
		out.close();
		
	}
	
}
