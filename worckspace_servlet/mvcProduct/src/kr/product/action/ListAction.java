package kr.product.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.controller.Action;
import kr.product.dao.ProductDao;
import kr.product.domain.ProductDto;

public class ListAction implements Action{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		ProductDao dao = ProductDao.getInstance();
		
		List<ProductDto> productList = dao.getList();
		
		req.setAttribute("productList", productList);
		
		return "/views/list.jsp";
	}
}