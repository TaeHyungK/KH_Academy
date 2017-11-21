<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="my.product.dao.ProductDao" %>
<%@ page import="my.product.domain.ProductDto" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="item" class="my.product.domain.ProductDto"/>
<jsp:setProperty name="item" property="*"/>
<%
	ProductDao dao = ProductDao.getInstance();
	ProductDto product = dao.getProduct(item.getNum());
	
	dao.productUpdate(product);
%>
	<script>
		alert('상품 정보 수정을 완료했습니다.');
		location.href='list.jsp';
	</script>