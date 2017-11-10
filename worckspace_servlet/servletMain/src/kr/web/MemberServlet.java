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
		 * [�ǽ�] ���۵� ȸ�� ����(�̸�, ����, ����, ��ȭ��ȣ)�� ǥ���Ͻÿ�.
		 * ---��� ����---
		 * �̸� : ȫ�浿
		 * ���� : 30
		 * ���� : ����
		 * ��ȭ��ȣ : 010-1234-5678
		 */
		req.setCharacterEncoding("UTF-8");
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		String job = req.getParameter("job");
		String[] tel = req.getParameterValues("tel");

		resp.setContentType("text/html;charset=UTF-8");

		PrintWriter out = resp.getWriter();

		out.println("<html>");
		out.println("<head><title>ȸ������</title><head>");
		out.println("<body>");
		out.println("�̸� : " + name + "<br>");
		out.println("���� : " + age + "<br>");
		out.println("���� : " + job + "<br>");
		/*if(tel!=null) {
			out.printf("��ȭ��ȣ : %s-%s-%s <br>",tel[0], tel[1], tel[2]);
		}*/
		out.println("��ȭ��ȣ : <br>");
		
		if(tel!=null) {
			for(int i=0;i<tel.length;i++) {
				//��ȭ��ȣ�� �Է����� �ʾ��� ���
				//�� ���ڿ� ���·� ���۵Ǳ� ������ �� ���ڿ� üũ
				if(!tel[i].equals("")) {
					if(i>0) {
						out.print("-");
					}
					
					out.print(tel[i]);
				}else{
					out.print("���Է�");
					break;
				}
			}
		}

		out.println("</body>");
		out.println("</html>");

		out.close();

	}

}
