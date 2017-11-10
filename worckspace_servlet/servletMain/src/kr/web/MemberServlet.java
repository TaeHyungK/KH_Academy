package kr.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/member")
public class MemberServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		 * [실습] 전송된 회원 정보(이름, 나이, 직업, 전화번호)를 표시하시오.
		 * ---출력 예시---
		 * 이름 : 홍길동
		 * 나이 : 30
		 * 직업 : 경찰
		 * 전화번호 : 010-1234-5678
		 */
		req.setCharacterEncoding("UTF-8");
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		String job = req.getParameter("job");
		String[] tel = req.getParameterValues("tel");

		resp.setContentType("text/html;charset=UTF-8");

		PrintWriter out = resp.getWriter();

		out.println("<html>");
		out.println("<head><title>회원가입</title><head>");
		out.println("<body>");
		out.println("이름 : " + name + "<br>");
		out.println("나이 : " + age + "<br>");
		out.println("직업 : " + job + "<br>");
		/*if(tel!=null) {
			out.printf("전화번호 : %s-%s-%s <br>",tel[0], tel[1], tel[2]);
		}*/
		out.println("전화번호 : <br>");
		
		if(tel!=null) {
			for(int i=0;i<tel.length;i++) {
				//전화번호를 입력하지 않았을 경우
				//빈 문자열 형태로 전송되기 때문에 빈 문자열 체크
				if(!tel[i].equals("")) {
					if(i>0) {
						out.print("-");
					}
					
					out.print(tel[i]);
				}else{
					out.print("미입력");
					break;
				}
			}
		}

		out.println("</body>");
		out.println("</html>");

		out.close();

	}

}
