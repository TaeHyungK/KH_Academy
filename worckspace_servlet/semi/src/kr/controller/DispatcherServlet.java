package kr.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet{
	
	private Map<String,Action> commandMap = new HashMap<String,Action>();
	
	@Override
	public void init(ServletConfig config) throws ServletException{
		Properties pr = new Properties();
		//"/WEB-INF/ActionMap.properties" 반환
		String props = config.getInitParameter("propertyConfig");
		//ActionMap.properties 파일의 절대 경로 구하기
		String path = config.getServletContext().getRealPath(props);
		FileInputStream fis = null;
		try {
			//파일 읽기
			fis = new FileInputStream(path);
			//파일 스트림을 Properties 객체에 넘겨
			//key와 value 구분
			pr.load(fis);
		}catch(IOException e) {
			throw new ServletException(e);
		}finally {
			if(fis!=null)try {fis.close();}catch(IOException e) {}
		}
		//Properties 객체에서 key구하기
		Iterator keyIter = pr.keySet().iterator();
		while(keyIter.hasNext()) {
			String command = (String)keyIter.next();//key
			String className = pr.getProperty(command);//value
			
			try {
				//문자열을 이용해 클래스를 찾아 Class 타입으로
				//반환
				Class commandClass = Class.forName(className);
				//객체로 생성
				Object commandInstance = commandClass.newInstance();
				//HashMap에 key와 value로 등록
				commandMap.put(command, (Action)commandInstance);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		requestPro(request,response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		requestPro(request,response);
	}
	//작업용 메서드
	private void requestPro(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException,IOException{
		String view = null; //JSP 경로
		Action com = null; //Model클래스의 구현 객체
		
		//요청URI 반환
		String command = request.getRequestURI();
		System.out.println("요청URI:"+command);
		System.out.println("컨텍스트경로:"+request.getContextPath());

		if(command.indexOf(request.getContextPath())==0) {
			command = command.substring(
					request.getContextPath().length());
			System.out.println("커맨드:"+command);
			System.out.println("----------");
		}
				
		//HashMap에 key를 넣어서 value(모델 객체)를 얻음
		com = commandMap.get(command);
		//Model 클래스의 작업 메서드 호출
		try {
			//Servlet 호출시 생성된 request와 
			//response 공유
			//데이터를 처리하고 생성된 데이터를
			//request에 저장한 후 jsp 경로 반환
			view = com.execute(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		if(view.startsWith("redirect:")) {
			//리다이렉트
			view = view.substring("redirect:".length());
			response.sendRedirect(request.getContextPath()+view);
		}else {
			//포워드
			//forward 방식으로 view(jsp) 호출
			RequestDispatcher dispatcher =
					request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
		}	
	}
}












