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
		//컨텐트 타입 지정
		resp.setContentType("text/html;charset=UTF-8");
		
		//출력스트림 생성
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head><title>기본적인 서블릿</title></head>");
		out.println("<body>");
		out.println("<ul>");
		out.println("	<li>서울</li>");
		out.println("	<li>대구</li>");
		out.println("	<li>대전</li>");
		out.println("	<li>부산</li>");
		out.println("</ul>");
		out.println("</body>");
		out.println("</html>");
		
		//자원 정리
		out.close();
		
	}
	
}
