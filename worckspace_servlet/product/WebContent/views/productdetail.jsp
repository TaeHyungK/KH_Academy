<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ page import="my.product.dao.ProductDao"%>
<%@ page import="my.product.domain.ProductDto"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상품 상세정보</title>
<style type="text/css">
table {
   margin: auto;
}
.align-center{
   text-align:center;
}
</style>
</head>
<body>
   <%
      int num = Integer.parseInt(request.getParameter("num"));

      ProductDao dao = ProductDao.getInstance();
      ProductDto product = dao.getProduct(num);
   %>
   <h2>상품 상세정보</h2>
   <form action="changeList.jsp" method="post">
   	<input type="hidden" name= "num" value="<%=num %>">
   	<input type="hidden" name= "currentStock" value="<%=product.getStock() %>">
      <table border="1">
         <tr>
            <td><img src="../img/default.jpg" width="340" height="300"></td>
            <td>
               <table border="1" style="height: 300px; width: 400px;">
                  <tr align="center">
                     <td>상품명</td>
                     <td id="name"><%=product.getName()%></td>
                  </tr>
                  <tr align="center">
                     <td>가격</td>
                     <td id="price"><%=product.getPrice()%></td>
                  </tr>
                  <tr align="center">
                     <td>상품소개</td>
                     <td id="content"><%=product.getContent()%></td>
                  </tr>
                  <tr align="center">
                     <td>구매 수량</td>
                     <td>
                        <span>재고</span> <span id="stock"><%=product.getStock() %></span><br>
                    <%
	 					int currentStock = product.getStock();
   	  					if(currentStock>0){
   					%>
                        <input type="number" value="재고수량" name="buy" min="0" max="<%=product.getStock()%>">
                    <%
   	  					}else{
                    %>
                    		<span>재고가 없습니다. 구매하실 수 없습니다.</span>    
                    <%
   	  					}
                    %>
                     </td>
                  </tr>
               </table>
            </td>
         </tr>
      </table>
      <div class="align-center">
      <%
      	if(currentStock>0){
      %>
      		<input type="submit" value="주문">
      <%
      	}
      %>
      <input type="button" value="목록" onclick="location.href='list.jsp'">
   </div>
   </form>
   
</body>
</html>