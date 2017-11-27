package kr.mvc;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SimpleServletMap  extends HttpServlet{
	private Map<String, Action> commandMap = new HashMap<String, Action>();
	
	@Override
	public void init() throws ServletException {
		commandMap.put("/list.mo", new ListAction());
		commandMap.put("/write.mo", new WriteAction());
		commandMap.put("/detail.mo", new DetailAction());
		commandMap.put("/update.mo", new UpdateAction());
		commandMap.put("/delete.mo", new DeleteAction());
		commandMap.put("/search.mo", new SearchAction());
	}

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
		
		String command = req.getRequestURI();
		System.out.println("getRequestURI(): " + req.getRequestURI()); // /mvcMain/detail.do
		System.out.println("getContextPath(): " + req.getContextPath()); // /mvcMain
		
		if(command.indexOf(req.getContextPath()) == 0) {
			command = command.substring(req.getContextPath().length());
			System.out.println("command : " + command); // /detail.do
			System.out.println("------------------");
		}
		
		//HashMap에 key를 넣어서 value(모델 객체)를 얻음
		com = commandMap.get(command);
		
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
