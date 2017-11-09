package kr.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/add")
public class AddServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//클라이언트에서 전송된 데이터는 HttpServletRequest에 파라미터네임=값 형태로
		//저장되어 있음
		//전송된 데이터는 데이터 타입에 상관없이 getParameter에서 String으로 반환함
		String str1 = req.getParameter("num1");
		String str2 = req.getParameter("num2");
		//String -> int
		int num1 = Integer.parseInt(str1);
		int num2 = Integer.parseInt(str2);
		//연산
		int sum = num1+num2;
		
		//컨텐트 타입 및 캐릭터셋 지정
		resp.setContentType("text/html;charset=UTF-8");
		
		//출력스트림 생성
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head><title>덧셈 프로그램</title></head>");
		out.println("<body>");
		out.printf("%d + %d = %d", num1,num2,sum);
		out.println("</body>");
		out.println("</html>");
		//스트림 닫기
		out.close();
		
	}
	
}
