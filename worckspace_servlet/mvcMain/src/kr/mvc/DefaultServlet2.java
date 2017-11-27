package kr.mvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DefaultServlet2 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		requestPro(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		requestPro(req, resp);
	}
	
	//�۾��� �޼ҵ�
	private void requestPro(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String command = req.getParameter("command");
		String result = null;
		
		if(command==null || command.equals("")) {
			result = "�Խ��� ���";
		}else if(command.equals("write")) {
			result = "�Խ��ǿ� �۾���";
		}else if(command.equals("detail")) {
			result = "�Խ��� �� �� ����";
		}else if(command.equals("update")) {
			result = "�Խ��� �� ����";
		}else if(command.equals("delete")) {
			result = "�Խ��� �� ����";
		}else {
			result = "�߸� ȣ���߽��ϴ�.";
		}
		
		//�����͸� request�� ����
		req.setAttribute("result", result);
		
		//foward������� view(jsp)ȣ��
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/messageView2.jsp");
		dispatcher.forward(req, resp);
	}
}
