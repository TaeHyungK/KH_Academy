package kr.mvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SimpleServlet extends HttpServlet{

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
		String view = null; //jsp 경로
		Action com = null; //Model클래스의 구현 객체
		
		String command = req.getParameter("command");
		
		if(command==null || command.equals("list")) {
			com = new ListAction(); //게시판 목록
		}else if(command.equals("write")) {
			com = new WriteAction(); //게시판 글쓰기
		}else if(command.equals("detail")) {
			com = new DetailAction(); //게시판 상세보기
		}
		
		//Model 클래스의 작업메소드 호출
		try {
			//Servlet 호출시 생성된 request와 response 공유
			//데이터를 처리하고 생성된 데이터를 request에 저장한 후 JSP경로를 반환
			view = com.execute(req, resp);
		}catch(Exception e) {
			e.printStackTrace();
		}
		//foward방식으로 view(jsp) 호출
		RequestDispatcher dispatcher = req.getRequestDispatcher(view);
		dispatcher.forward(req, resp);
		
	}
}
