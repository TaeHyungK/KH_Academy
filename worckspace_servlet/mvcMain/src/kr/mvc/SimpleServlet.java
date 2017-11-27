package kr.mvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SimpleServlet extends HttpServlet{

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
		String view = null; //jsp ���
		Action com = null; //ModelŬ������ ���� ��ü
		
		String command = req.getParameter("command");
		
		if(command==null || command.equals("list")) {
			com = new ListAction(); //�Խ��� ���
		}else if(command.equals("write")) {
			com = new WriteAction(); //�Խ��� �۾���
		}else if(command.equals("detail")) {
			com = new DetailAction(); //�Խ��� �󼼺���
		}
		
		//Model Ŭ������ �۾��޼ҵ� ȣ��
		try {
			//Servlet ȣ��� ������ request�� response ����
			//�����͸� ó���ϰ� ������ �����͸� request�� ������ �� JSP��θ� ��ȯ
			view = com.execute(req, resp);
		}catch(Exception e) {
			e.printStackTrace();
		}
		//foward������� view(jsp) ȣ��
		RequestDispatcher dispatcher = req.getRequestDispatcher(view);
		dispatcher.forward(req, resp);
		
	}
}
