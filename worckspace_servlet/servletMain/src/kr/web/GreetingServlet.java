package kr.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/greeting")
public class GreetingServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		//���۵� �����ʹ� ��ȯ ����
		String name = req.getParameter("name");
		//����Ʈ Ÿ�� �� ĳ���ͼ� ����
		resp.setContentType("text/html;charset=UTF-8");
		//��� ��Ʈ�� ����
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head><title>Greeting</title></head>");
		out.println("<body>");
		out.println(name + "���� �湮�� ȯ���մϴ�<br>");
		out.println("</body>");
		out.println("</html>");
		//��Ʈ�� �ݱ�
		out.close();
	}
	
	
	
}
