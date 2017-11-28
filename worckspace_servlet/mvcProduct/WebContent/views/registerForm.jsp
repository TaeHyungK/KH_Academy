<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록 폼</title>
<link rel="stylesheet" href="./css/style.css" type="text/css">
<script type="text/javascript">
	window.onload=function(){
		var myForm = document.getElementById('myForm');
		myForm.onsubmit=function(){
			var id=document.getElementById('id');
			if(id.value==''){
				alert('아이디를 입력하세요.');
				id.focus();
				return false;
			}
			var name=document.getElementById('name');
			if(name.value==''){
				alert('상품명 입력하세요.');
				name.focus();
				return false;
			}
			var price=document.getElementById('price');
			if(price.value==''){
				alert('가격을 입력하세요.');
				price.focus();
				return false;
			}
			var stock=document.getElementById('stock');
			if(stock.value==''){
				alert('재고수량을 입력하세요.');
				stock.focus();
				return false;
			}
			var place=document.getElementById('place');
			if(place.value==''){
				alert('원산지를 입력하세요.');
				place.focus();
				return false;
			}
		}
	}
</script>
</head>
<body>
<div class="page-main-style">
	<h2>상품 등록</h2>
	<form id="myForm" action="register.do" method="post">
		<ul>
			<li>
				<label for="id">상품ID</label>
				<input type="text" name="id" id="id" size="20">
			</li>
			<li>
				<label for="name">상품명</label>
				<input type="text" name="name" id="name" size="20">
			</li>
			<li>
				<label for="price">가격</label>
				<input type="number" name="price" id="price" size="20">
			</li>
			<li>
				<label for="stock">재고수량</label>
				<input type="number" name="stock" id="stock" size="20">
			</li>
			<li>
				<label for="place">원산지</label>
				<input type="text" name="place" id="place" size="20">
			</li>
			<li>
				<label for="reg_date">등록일</label>
				<input type="date" name="reg_date" id="reg_date" size="20">
			</li>
		</ul>
		<div class="align-center">
			<input type="submit" value="등록">
			<input type="button" value="목록" onclick="location.href='list.do'">;
		</div>
	</form>
</div>
</body>
</html>