package kr.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BasicServlet2 extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//컨텐트 타입 지정
		resp.setContentType("text/html;charset=UTF-8");

		//전송된 데이터에 대한 인코딩 처리
		req.setCharacterEncoding("UTF-8");

		//전송된 데이터 반환
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		String[] values = req.getParameterValues("city");

		//출력 스트림 생성
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head><title>여행지 선택</title></head>");
		out.println("<body>");
		out.println("이름 : " + name + "<br>");
		out.println("나이 : " + age + "<br>");
		out.println("선택한 여행지<br>");
		if(values!=null) {
			for(int i=0;i<values.length;i++) {
				if(i>0) out.println(", ");
				out.println(values[i]);
			}
		}else {
			out.println("없음");
		}
		out.println("</body>");
		out.println("</html>");
		
		out.close();

	}

}
