<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="my.product.dao.ProductDao" %>
<%@ page import="my.product.domain.ProductDto" %>
<%
	int num = Integer.parseInt(request.getParameter("num"));
	ProductDao dao = ProductDao.getInstance();
	ProductDto product = dao.getProduct(num);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 내용 수정</title>
<style type="text/css">
	.align-center{
	text-align:center;
	}
	.align-right{
	text-align:right;
	}
	table{
		margin:auto;
	}
</style>
<script type="text/javascript">
window.onload=function(){
	var myForm = document.getElementById('myForm');
	//submit 이벤트 연결
	myForm.onsubmit=function(){
		var name = document.getElementById('name');
		if(name.value==''){
			alert('이름을 입력하세요');
			name.focus();
			return false;
		}
		var price = document.getElementById('price');
		if(passwd.value==''){
			alert('판매 가격을 입력하세요');
			price.focus();
			return false;
		}
		var content = document.getElementById('content');
		if(email.value==''){
			alert('내용을 입력하세요');
			content.focus();
			return false;
		}
		var stock = document.getElementById('stock');
		if(content.value==''){
			alert('재고 수량을 입력하세요');
			stock.focus();
			return false;
		}
		var passwd = document.getElementById('passwd');
		if(content.value==''){
			alert('판매자 비밀번호를 입력하세요');
			passwd.focus();
			return false;
		}
	};
};
</script>
</head>
<body>
 <h2>상품 정보 수정</h2> 
 	<form id="myForm" action="productUpdate.jsp" method="post">
 		<input type="hidden" name="num" value="<%=num %>">
	    <table border="1">
	        <tr>
	            <td>
	                <img src="../img/default.jpg" width="340" height="300">
	            </td>
	            <td>
	                <table border="1" style="height: 300px; width: 400px;">
	                    <tr align="center">
	                        <td>상품명</td>
	                        <td>
	                        	<input type="text" value="<%=product.getName() %>" name="name" id="name">
	                        </td>
	                    </tr>
	                    <tr align="center">
	                        <td>가격</td>
	                        <td>
	                        	<input type="number" value="<%=product.getPrice() %>" name="price" id="price">
	                        </td>
	                    </tr>
	                    <tr align="center">
	                        <td>상품소개</td>
	                        <td>
	                        	<input type="text" value="<%=product.getContent() %>"name="content" id="content" >
	                        </td>
	                    </tr>
	                    <tr align="center">
	                        <td>재고 수량</td>
	                        <td>
	                        	<input type="number" value="<%=product.getStock() %>"name="stock" id="stock">
	                        </td>
	                    </tr>
	                    <tr align="center">
	                    	<td>작성자 비밀번호</td>
	                    	<td>
	                    		<input type="password" name="passwd" id="passwd">
	                    	</td>
	                    </tr>
	                </table>
	            </td>
	        </tr>
	    </table>
	    <div class="align-center">
	    	<input type="submit" value="상품 정보 수정">
	    	<input type="button" value="목록" onclick="location.href='list.jsp'">
	    </div>
    </form>
</body>
</html>