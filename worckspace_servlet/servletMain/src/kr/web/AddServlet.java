package kr.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/add")
public class AddServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Ŭ���̾�Ʈ���� ���۵� �����ʹ� HttpServletRequest�� �Ķ���ͳ���=�� ���·�
		//����Ǿ� ����
		//���۵� �����ʹ� ������ Ÿ�Կ� ������� getParameter���� String���� ��ȯ��
		String str1 = req.getParameter("num1");
		String str2 = req.getParameter("num2");
		//String -> int
		int num1 = Integer.parseInt(str1);
		int num2 = Integer.parseInt(str2);
		//����
		int sum = num1+num2;
		
		//����Ʈ Ÿ�� �� ĳ���ͼ� ����
		resp.setContentType("text/html;charset=UTF-8");
		
		//��½�Ʈ�� ����
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head><title>���� ���α׷�</title></head>");
		out.println("<body>");
		out.printf("%d + %d = %d", num1,num2,sum);
		out.println("</body>");
		out.println("</html>");
		//��Ʈ�� �ݱ�
		out.close();
		
	}
	
}
