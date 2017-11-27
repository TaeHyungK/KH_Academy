package kr.mvc;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SimpleServletMap  extends HttpServlet{
	private Map<String, Action> commandMap = new HashMap<String, Action>();
	
	@Override
	public void init() throws ServletException {
		commandMap.put("/list.mo", new ListAction());
		commandMap.put("/write.mo", new WriteAction());
		commandMap.put("/detail.mo", new DetailAction());
		commandMap.put("/update.mo", new UpdateAction());
		commandMap.put("/delete.mo", new DeleteAction());
		commandMap.put("/search.mo", new SearchAction());
	}

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
		
		//HashMap�� key�� �־ value(�� ��ü)�� ����
		com = commandMap.get(command);
		
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
