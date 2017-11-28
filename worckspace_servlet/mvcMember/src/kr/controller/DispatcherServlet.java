package kr.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet{
private Map<String, Action> commandMap = new HashMap<String, Action>();
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		Properties pr = new Properties();
		//"/WEB-INF/ActionMap.properties" ��ȯ
		String props = config.getInitParameter("propertyConfig");
		//ActionMap.properties ������ ���� ��� ���ϱ�
		String path = config.getServletContext().getRealPath(props);
		FileInputStream fis = null;
		try {
			//���� �б�
			fis = new FileInputStream(path);
			//���� ��Ʈ���� Properties ��ü�� �Ѱ� key�� value�� ����
			pr.load(fis);
			
		}catch(Exception e) {
			throw new ServletException(e);
		}finally {
			if(fis!=null) try {fis.close();} catch(Exception e) {}
		}
		
		//Properties ��ü���� key ���ϱ�
		Iterator keyIter = pr.keySet().iterator();
		while(keyIter.hasNext()) {
			String command = (String) keyIter.next(); //key
			String className = pr.getProperty(command); //value
			
			try {
				//���ڿ��� �̿��� class�� ã�� Class Ÿ������ ��ȯ
				Class commandClass = Class.forName(className);
				//Object Ÿ������ Ŭ������ ��ü�� ����
				Object commandInstance = commandClass.newInstance();
				//HashMap�� key�� value�� ����
				commandMap.put(command, (Action)commandInstance);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
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
