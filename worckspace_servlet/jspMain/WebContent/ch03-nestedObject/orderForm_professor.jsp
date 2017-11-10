<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>물건구매</title>
</head>
<body>
	<form action="order_professor.jsp" method="post">
		이름 <input type="text" name="name"><br> 
		날짜 <input type="date" name="order_date"><br> 
		구매 물건 : 
		<input type="checkbox" name="item" value="가방">가방(20만원)
		<input type="checkbox" name="item" value="신발">신발(10만원)
		<input type="checkbox" name="item" value="옷">옷(5만원)
		<input type="checkbox" name="item" value="식사권">식사권(15만원) <br>
		<input type="submit" value="전송">
	</form>
</body>
</html>