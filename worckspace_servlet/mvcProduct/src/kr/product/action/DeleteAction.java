package kr.product.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.controller.Action;
import kr.product.dao.ProductDao;

public class DeleteAction implements Action{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String id = req.getParameter("id");
		
		ProductDao dao = ProductDao.getInstance();
		dao.deleteProduct(id);
		
		return "/views/delete.jsp";
	}

}
