package kr.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/now")
public class NowServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//����Ʈ Ÿ�� �� ĳ���ͼ�
		response.setContentType("text/html;charset=UTF-8");
		
		//Date��ü ����
		Date now = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy��MM��dd�� a hh:mm:ss");
		
		//��� ��Ʈ�� ����
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>���� ��¥�� �ð�</title></head>");
		out.println("<body>");
		out.println("���� ��¥�� �ð� :" + sf.format(now));
		out.println("</body>");
		out.println("</html>");
		//��Ʈ�� �ݱ�
		out.close();
	}
	
}
