package kr.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

class UserInfo{
	String name;
	int age;
	String job;
	String address;
	
	UserInfo(String name, int age, String job, String address){
		this.name = name;
		this.age = age;
		this.job = job;
		this.address = address;
	}
}

@WebServlet("/myInfo")
public class MyInfoServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		 * [실습]개인 정보 출력하기
		 * (데이터를 저장할 변수 지정, name, age, job, address)
		 * 이름 : 홍길동
		 * 나이 : 20살
		 * 직업 : 학생
		 * 주소 : 서울시
		 */
		
		UserInfo user = new UserInfo("홍길동", 20, "학생", "서울시");
		
		resp.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head><title>개인 정보 출력</title></head>");
		out.println("<body>");
		out.println("이름: " + user.name + "<br>");
		out.println("나이: " + user.age + "<br>");
		out.println("직업: " + user.job + "<br>");
		out.println("주소: " + user.address + "<br>");
		out.println("</body>");
		out.println("</html>");
		//스트림 닫기
		out.close();
		
	}
	
}
