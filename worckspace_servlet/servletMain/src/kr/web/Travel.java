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
	 * [실습] 전송된 데이터 출력
	 * 이름 : 홍길동
	 * 여행비용 : 180,000원(10% 할인율 적용)
	 * 여행지 : 뉴욕
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
		out.println("<head><title>[실습]Travel</title></head>");
		out.println("<body>");
		out.println("이름 : " + name + "<br>");
		out.printf("여행 비용: %,d원<br>", rateCost);
		out.println("여행지 : " + location);
		out.println("</body>");
		out.println("</html>");
	}
	
}
