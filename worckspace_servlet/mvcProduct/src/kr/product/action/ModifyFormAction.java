package kr.product.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.controller.Action;
import kr.product.dao.ProductDao;
import kr.product.domain.ProductDto;

public class ModifyFormAction implements Action{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		String id = req.getParameter("id");
		ProductDao dao = ProductDao.getInstance();
		ProductDto product = dao.getProduct(id);
		
		req.setAttribute("product", product);
		
		return "/views/modifyForm.jsp";
	}

}
