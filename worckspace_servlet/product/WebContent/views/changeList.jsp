<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="my.product.dao.ProductDao" %>
<%@ page import="my.product.domain.ProductDto" %>
<%
   request.setCharacterEncoding("UTF-8");
   int num = Integer.parseInt(request.getParameter("num"));
   int buy = Integer.parseInt(request.getParameter("buy"));
   int currentStock = Integer.parseInt(request.getParameter("currentStock"));
%>
<jsp:useBean id="product" class="my.product.domain.ProductDto"/>
<jsp:setProperty name="product" property="*"/>
<%
   ProductDao dao = ProductDao.getInstance();
   ProductDto products = dao.getProduct(product.getNum());
   
   if(products!=null){
%>
<% 
   boolean result = dao.productUpdate(product, currentStock, buy);
   if(result){
%>
      <script>
      alert('상품 정보 수정을 완료했습니다.');
      location.href='list.jsp';
   </script>
<%
      }
   }else{
%>
   <script>
      alert('상품 정보 수정을 실패했습니다. 다시 시도해주세요.');
      location.href='list.jsp';
   </script>
<%
   }
%>