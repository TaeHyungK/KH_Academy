package kr.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/now")
public class NowServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//컨텐트 타입 및 캐릭터셋
		response.setContentType("text/html;charset=UTF-8");
		
		//Date객체 생성
		Date now = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy년MM월dd일 a hh:mm:ss");
		
		//출력 스트림 생성
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>현재 날짜와 시간</title></head>");
		out.println("<body>");
		out.println("현재 날짜와 시간 :" + sf.format(now));
		out.println("</body>");
		out.println("</html>");
		//스트림 닫기
		out.close();
	}
	
}
