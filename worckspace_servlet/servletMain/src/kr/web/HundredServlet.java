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
		 * [실습]1부터 100까지의 합 출력
		 * ---출력 예시---
		 * 1부터 100까지의 합은 = 5050
		 */
		
		resp.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = resp.getWriter();
		
		int sum = 0;
		
		out.println("<html>");
		out.println("<head><title>1부터 100까지의 합 출력</title></head>");
		out.println("<body>");
		
		for(int i=1;i<=100;i++) {
			sum += i;
		}
		out.println("1부터 100까지의 합은 = " + sum);
		
		out.println("</body>");
		out.println("</html>");
	}

}
