package kr.product.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.controller.Action;
import kr.product.dao.ProductDao;
import kr.product.domain.ProductDto;

public class ModifyAction implements Action{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");
		
		ProductDto product = new ProductDto();
		product.setId(req.getParameter("id"));
		product.setName(req.getParameter("name"));
		product.setPrice(Integer.parseInt(req.getParameter("price")));
		product.setStock(Integer.parseInt(req.getParameter("stock")));
		product.setPlace(req.getParameter("place"));
		
		ProductDao dao = ProductDao.getInstance();
		dao.updateProduct(product);		
		
		return "/views/modify.jsp";
	}

}
