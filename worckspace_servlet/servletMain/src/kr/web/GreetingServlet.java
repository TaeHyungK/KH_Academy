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
		//전송된 데이터는 반환 받음
		String name = req.getParameter("name");
		//컨텐트 타입 및 캐릭터셋 지정
		resp.setContentType("text/html;charset=UTF-8");
		//출력 스트림 생성
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head><title>Greeting</title></head>");
		out.println("<body>");
		out.println(name + "님의 방문을 환영합니다<br>");
		out.println("</body>");
		out.println("</html>");
		//스트림 닫기
		out.close();
	}
	
	
	
}
