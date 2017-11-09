package kr.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/travel")
public class Travel extends HttpServlet{

	/*
	 * [�ǽ�] ���۵� ������ ���
	 * �̸� : ȫ�浿
	 * ������ : 180,000��(10% ������ ����)
	 * ������ : ����
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String name = req.getParameter("name");
		int cost = Integer.parseInt(req.getParameter("cost"));
		String location = req.getParameter("location");
		
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		int rateCost = (int)(cost*0.9);
		
		out.println("<html>");
		out.println("<head><title>[�ǽ�]Travel</title></head>");
		out.println("<body>");
		out.println("�̸� : " + name + "<br>");
		out.printf("���� ���: %,d��<br>", rateCost);
		out.println("������ : " + location);
		out.println("</body>");
		out.println("</html>");
	}
	
}
