package kr.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	//�߻� �޼ҵ�
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception;
	
}
