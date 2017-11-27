package kr.mvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SimpleServletURI extends HttpServlet{
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
		
		String command = req.getRequestURI();
		System.out.println("getRequestURI(): " + req.getRequestURI()); // /mvcMain/detail.do
		System.out.println("getContextPath(): " + req.getContextPath()); // /mvcMain
		
		if(command.indexOf(req.getContextPath()) == 0) {
			command = command.substring(req.getContextPath().length());
			System.out.println("command : " + command); // /detail.do
			System.out.println("------------------");
		}
		
		if(command.equals("/*.do")) command = "/list.do";
		
		if(command==null || command.equals("/list.do")) {
			com = new ListAction(); //�Խ��� ���
		}else if(command.equals("/write.do")) {
			com = new WriteAction(); //�Խ��� �۾���
		}else if(command.equals("/detail.do")) {
			com = new DetailAction(); //�Խ��� �󼼺���
		}else if(command.equals("/update.do")) {
			com = new UpdateAction();
		}else if(command.equals("/delete.do")) {
			com = new DeleteAction();
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
