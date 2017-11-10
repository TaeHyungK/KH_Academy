<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%
 	Date nowDate = new Date();
 	SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>물건구매</title>
</head>
<body>
<!-- 
이름, 날짜, 
구매물건-> 가방(20만원), 신발(10만원), 옷(5만원), 식사권(15만원)
 -->
 	<form action="order.jsp" method="post">
 		이름 : <input type="text" name="name"><br>
 		날짜 : <input type="text" name="date" readonly value="<%=sf.format(nowDate) %>">
 		<br>
 		구매 물건<br>
 		<input type="checkbox" name="product" value="가방">가방(\200,000)
 		<input type="checkbox" name="product" value="신발">신발(\100,000)
 		<input type="checkbox" name="product" value="옷">옷(\50,000)
 		<input type="checkbox" name="product" value="식사권">식사권(\150,000)
 		<br>
 		
 		<input type="submit" value="주문">
 		
 	</form>

</body>
</html>