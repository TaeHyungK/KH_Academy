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
		 * [�ǽ�]���� ���� ����ϱ�
		 * (�����͸� ������ ���� ����, name, age, job, address)
		 * �̸� : ȫ�浿
		 * ���� : 20��
		 * ���� : �л�
		 * �ּ� : �����
		 */
		
		UserInfo user = new UserInfo("ȫ�浿", 20, "�л�", "�����");
		
		resp.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head><title>���� ���� ���</title></head>");
		out.println("<body>");
		out.println("�̸�: " + user.name + "<br>");
		out.println("����: " + user.age + "<br>");
		out.println("����: " + user.job + "<br>");
		out.println("�ּ�: " + user.address + "<br>");
		out.println("</body>");
		out.println("</html>");
		//��Ʈ�� �ݱ�
		out.close();
		
	}
	
}
