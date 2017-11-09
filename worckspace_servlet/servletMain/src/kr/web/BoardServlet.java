package kr.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/board")
public class BoardServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//전송된 데이터에 대한 인코딩 처리
		req.setCharacterEncoding("UTF-8");
		String name = req.getParameter("name");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		//컨텐트 타입 및 캐릭터셋 지정
		resp.setContentType("text/html;charset=UTF-8");
		
		//출력 스트림 생성
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head><title>글쓰기</title></head>");
		out.println("<body>");
		out.println("이름 : " + name + "<br>");
		out.println("제목 : " + title + "<br>");
		out.println("내용 : <br>");
		out.println("<pre>" +content + "</pre>");
		out.println("-------------------<br>");
		out.println("저장이 완료되었습니다.");
		out.println("</body>");
		out.println("</html>");
		
		//스트림 닫기
		out.close();
	}

}
