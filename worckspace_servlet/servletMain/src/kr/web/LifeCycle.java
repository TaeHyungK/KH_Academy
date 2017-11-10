package kr.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/lifeCycle")
public class LifeCycle extends HttpServlet {
	int initCnt =0;
	int serviceCnt = 0;
	int destroyCnt =0;
	
	@Override
	public void init() throws ServletException {
		System.out.println("init �޼ҵ�� ù ��û�� ȣ��� : " + (++initCnt));
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("service �޼ҵ尡 ��û������ ȣ��� : " + (++serviceCnt));
		
		//����Ʈ Ÿ�� �� ĳ���ͼ� ����
		resp.setContentType("text/html;charset=UTF-8");
		
		//��½�Ʈ�� ����
		PrintWriter out = resp.getWriter();
		out.println("</html>");
		out.println("<head><title>Servlet Life Cycle</title></head>");
		out.println("<body>");
		out.println("���� �ν��Ͻ��� ID : " + initCnt+ "<br>");
		out.println("���� service ȣ�� ID : " + serviceCnt+ "<br>");
		Thread th = Thread.currentThread();
		out.println("���� Thread �̸� : " + th.getName() + "<br>");
		out.println("</body>");
		out.println("</html>");
		
		//��Ʈ�� �ݱ�
		out.close();
	}

	@Override
	public void destroy() {
		System.out.println("Destroy �޼ҵ�� �� Servlet�� �� �̻� ������ ���� ���� ȣ��� : " + (++destroyCnt));
	}
	
	


	
	
	
	
}
