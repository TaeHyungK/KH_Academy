package kr.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/lifeCycle")
public class LifeCycle extends HttpServlet {
	int initCnt =0;
	int serviceCnt = 0;
	int destroyCnt =0;
	
	@Override
	public void init() throws ServletException {
		System.out.println("init 메소드는 첫 요청만 호출됨 : " + (++initCnt));
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("service 메소드가 요청때마다 호출됨 : " + (++serviceCnt));
		
		//컨텐트 타입 및 캐릭터셋 지정
		resp.setContentType("text/html;charset=UTF-8");
		
		//출력스트림 생성
		PrintWriter out = resp.getWriter();
		out.println("</html>");
		out.println("<head><title>Servlet Life Cycle</title></head>");
		out.println("<body>");
		out.println("서블릿 인스턴스의 ID : " + initCnt+ "<br>");
		out.println("서블릿 service 호출 ID : " + serviceCnt+ "<br>");
		Thread th = Thread.currentThread();
		out.println("현재 Thread 이름 : " + th.getName() + "<br>");
		out.println("</body>");
		out.println("</html>");
		
		//스트림 닫기
		out.close();
	}

	@Override
	public void destroy() {
		System.out.println("Destroy 메소드는 본 Servlet이 더 이상 사용되지 않을 때만 호출됨 : " + (++destroyCnt));
	}
	
	


	
	
	
	
}
