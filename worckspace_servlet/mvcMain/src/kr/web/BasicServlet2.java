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
		//����Ʈ Ÿ�� ����
		resp.setContentType("text/html;charset=UTF-8");

		//���۵� �����Ϳ� ���� ���ڵ� ó��
		req.setCharacterEncoding("UTF-8");

		//���۵� ������ ��ȯ
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		String[] values = req.getParameterValues("city");

		//��� ��Ʈ�� ����
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head><title>������ ����</title></head>");
		out.println("<body>");
		out.println("�̸� : " + name + "<br>");
		out.println("���� : " + age + "<br>");
		out.println("������ ������<br>");
		if(values!=null) {
			for(int i=0;i<values.length;i++) {
				if(i>0) out.println(", ");
				out.println(values[i]);
			}
		}else {
			out.println("����");
		}
		out.println("</body>");
		out.println("</html>");
		
		out.close();

	}

}
