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
		//contentType(문서타입(=html))및 charset 지정
		response.setContentType("text/html;charset=UTF-8");
		
		//출력 스트림 생성
		PrintWriter out = response.getWriter();
		//HTML 태그를 문자열로 출력
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Hello Servlet</title>");
		out.println("<body>");
		out.println("처음 작성하는 Servlet 입니다.");
		out.println("</body>");
		out.println("</head>");
		out.println("</html>");
		//스트림 닫기(자원 정리)
		out.close();
		
	}
		
}
