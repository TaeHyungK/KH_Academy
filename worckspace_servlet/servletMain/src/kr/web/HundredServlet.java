package kr.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/hundred")
public class HundredServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		 * [�ǽ�]1���� 100������ �� ���
		 * ---��� ����---
		 * 1���� 100������ ���� = 5050
		 */
		
		resp.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = resp.getWriter();
		
		int sum = 0;
		
		out.println("<html>");
		out.println("<head><title>1���� 100������ �� ���</title></head>");
		out.println("<body>");
		
		for(int i=1;i<=100;i++) {
			sum += i;
		}
		out.println("1���� 100������ ���� = " + sum);
		
		out.println("</body>");
		out.println("</html>");
	}

}
