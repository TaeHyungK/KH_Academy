<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 상세 정보</title>
<link rel="stylesheet" href="./css/style.css" type="text/css">
</head>
<body>
<div class="page-main-style">
	<h2>상품관리 상세 정보</h2>
	<p>
		아이디 : ${product.id}<br>
		이름 : ${product.name}<br>
		가격 : ${product.price}<br>
		재고수량  : ${product.stock}<br>
		원산지 : ${product.place}<br> 
		등록일 : ${product.reg_date}
	</p>
	<div class="align-center">
		<input type="button" value="수정" onclick="location.href='modifyForm.do?id=${product.id}'">
		<input type="button" value="삭제" onclick="location.href='delete.do?id=${product.id}'">
	</div>
</div>
</body>
</html>