package kr.mvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DefaultServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		requestPro(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		requestPro(req, resp);
	}
	
	//작업용 메소드
	private void requestPro(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String message = req.getParameter("message");
		
		String result = null;
		if(message == null || message.equals("")) {
			result = "안녕하세요!";
		}else if(message.equals("name")) {
			result = "이름은 홍길동입니다.";
		}else if(message.equals("age")) {
			result = "나이는 20살 입니다.";
		}else {
			result = "엉뚱한 내용!";
		}
		
		//데이터를 request에 저장
		req.setAttribute("result", result);
		
		//foward 방식으로 view(jsp)를 호출
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/messageView.jsp");
		dispatcher.forward(req, resp);
	}
	
}
