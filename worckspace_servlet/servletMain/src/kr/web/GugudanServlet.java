package kr.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/gugudan")
public class GugudanServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		 * [�ǽ�] ������ ����ϱ�
		 * ---��¿���---
		 * 9��
		 * --------
		 * 9 * 1 = 9
		 */
		
		int dan = Integer.parseInt(req.getParameter("dan"));
		
		resp.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = resp.getWriter();
		
		out.println("<html>");
		out.println("<head><title>������ ����ϱ�</title></head>");
		out.println("<body>");
		out.println(dan + "��<br>");
		out.println("--------------<br>");
		for(int i=2;i<=9;i++) {
			out.printf("%d * %d = %d <br>", dan, i, (i*dan));
		}
		out.println("</body>");
		out.println("</html>");
		
		out.close();
		
	}
	
}
