package kr.mvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DefaultServlet2 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		requestPro(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		requestPro(req, resp);
	}
	
	//작업용 메소드
	private void requestPro(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String command = req.getParameter("command");
		String result = null;
		
		if(command==null || command.equals("")) {
			result = "게시판 목록";
		}else if(command.equals("write")) {
			result = "게시판에 글쓰기";
		}else if(command.equals("detail")) {
			result = "게시판 상세 글 보기";
		}else if(command.equals("update")) {
			result = "게시판 글 수정";
		}else if(command.equals("delete")) {
			result = "게시판 글 삭제";
		}else {
			result = "잘못 호출했습니다.";
		}
		
		//데이터를 request에 저장
		req.setAttribute("result", result);
		
		//foward방식으로 view(jsp)호출
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/messageView2.jsp");
		dispatcher.forward(req, resp);
	}
}
