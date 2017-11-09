package kr.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/todayMenu")
public class TodayMenu extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//���۵� �����Ϳ� ���� ���ڵ� ó��
		req.setCharacterEncoding("UTF-8");
		
		//���۵� ������ ��ȯ
		String[] values = req.getParameterValues("lunch");
		
		//����Ʈ Ÿ�� �� ĳ���ͼ� ����
		resp.setContentType("text/html;charset=UTF-8");
		
		//��� ��Ʈ�� ����
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head><title>������ �޴�</title></head>");
		out.println("<body>");
		out.println("<h3>���� ������</h3>");
		
		if(values!=null) {
			for(int i =0;i<values.length;i++) {
				out.println(values[i] + "<br>");
			}
		}else {
			out.println("�������� �ʾҽ��ϴ�.");
		}
		out.println("</body>");
		out.println("</html>");
		
		out.close();
	}
	
}
