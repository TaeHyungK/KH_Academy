package kr.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/todayMenu")
public class TodayMenu extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//전송된 데이터에 대한 인코딩 처리
		req.setCharacterEncoding("UTF-8");
		
		//전송된 데이터 반환
		String[] values = req.getParameterValues("lunch");
		
		//컨텐트 타입 및 캐릭터셋 지정
		resp.setContentType("text/html;charset=UTF-8");
		
		//출력 스트림 생성
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head><title>오늘의 메뉴</title></head>");
		out.println("<body>");
		out.println("<h3>오늘 점심은</h3>");
		
		if(values!=null) {
			for(int i =0;i<values.length;i++) {
				out.println(values[i] + "<br>");
			}
		}else {
			out.println("선택하지 않았습니다.");
		}
		out.println("</body>");
		out.println("</html>");
		
		out.close();
	}
	
}
