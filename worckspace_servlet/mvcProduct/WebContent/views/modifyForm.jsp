<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 정보 수정</title>
<link rel="stylesheet" href="./css/style.css" type="text/css">
<script type="text/javascript">
	window.onload=function(){
		var myForm = document.getElementById('myForm');
		myForm.onsubmit=function(){			
			var name = document.getElementById('name');
			if(name.value==''){
				alert('이름을 입력해주세요.');
				name.focus();
				return false;
			}
			var price = document.getElementById('price');
			if(price.value==''){
				alert('상품가격을 입력해주세요.');
				price.focus();
				return false;
			}
			var stock = document.getElementById('stock');
			if(stock.value==''){
				alert('재고수량을 입력해주세요.');
				stock.focus();
				return false;
			}
			var place = document.getElementById('place');
			if(place.value==''){
				alert('원산지를 입력해주세요.');
				place.focus();
				return false;
			}
			
		};
	}
</script>
</head>
<body>
<div class="page-main-style">
	<h2>상품 수정</h2>
	<form id="myForm" action="modify.do" method="post">
		<ul>
			<li>
				<label for="id">아이디</label>
				<input type="hidden" name="id" id="id" value="${product.id}">${product.id}
			</li>
			<li>
				<label for="name">상품명</label>
				<input type="text" name="name" id="name" size="20" maxlength="10" value="${product.name}">
			</li>
			<li>
				<label for="price">가격</label>
				<input type="number" name="price" id="price" value="${product.price}">
			</li>
			<li>
				<label for="stock">재고수량</label>
				<input type="number" name="stock" id="stock" value="${product.stock}">
			</li>
			<li>
				<label for="place">원산지</label>
				<input type="text" name="place" id="place" value="${product.place}">
			</li>
		</ul>
		<div class="align-center">
				<input type="submit" value="수정">
				<input type="button" value="목록" onclick="location.href='select.do'">
		</div>
	</form>
</div>
</body>
</html>