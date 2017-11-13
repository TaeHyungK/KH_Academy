<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록</title>
<link rel="stylesheet" href="style.css" type="text/css">
<script type="text/javascript">
	window.onload=function(){
		var myForm = document.getElementById('myForm');
		
		myForm.onsubmit=function(){
			var id = document.getElementById('id');
			var name = document.getElementById('name');
			var price = document.getElementById('price');
			var stock = document.getElementById('stock');
			var place = document.getElementById('place');
			
			if(id.value==''){
				alert('제품 ID를 입력해주세요.');
				id.focus();
				return false;
			}else if(name.value==''){
				alert('제품 이름을 입력해주세요.');
				name.focus();
				return false;
			}else if(price.value==''){
				alert('제품 가격을 입력해주세요.');
				price.focus();
				return false;
			}else if(stock.value==''){
				alert('제품 재고수량을 입력해주세요.');
				stock.focus();
				return false;
			}else if(place.value==''){
				alert('제품 원산지를 입력해주세요.');
				place.focus();
				return false;
			}
		};
	};
</script>
</head>
<body>
<!-- 
1. 자바스크립트를 이용한 유효성 체크
2. 등록폼(파라미터 id(상품ID), name, price, stock(재고수량), place(원산지)
 -->
	<div class="page-main-style">
		<h2 class="align-center">상품 등록</h2>
		<form id="myForm" action="insertTest.jsp" method="post">
			<ul>
				<li>
					<label for="id">아이디</label>
					<input type="text" name="id" id="id" size="20" maxlength="10">					
				</li>
				<li>
					<label for="name">이름</label>
					<input type="text" name="name" id="name" size="20" maxlength="30">	
				</li>
				<li>
					<label for="price">가격</label>
					<input type="number" name="price" id="price" max="100000000">
				</li>
				<li>
					<label for="stock">재고수량</label>
					<input type="number" name="stock" id="stock">
				</li>
				<li>
					<label for="place">원산지</label>
					<input type="text" name="place" id="place">
				</li>
			</ul>
			<div class="align-center">
				<input type="submit" value="입력완료">
				<input type="button" value="목록" onclick="location.href='listTest.jsp'">
			</div>
		</form>
	</div>
</body>
</html>