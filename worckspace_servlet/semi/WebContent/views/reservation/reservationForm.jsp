<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>검색한 비행기</title>
<link rel="stylesheet" type="text/css" href="../css/style.css">
<link rel="stylesheet" href="../css/jquery-ui.css">
<script type="text/javascript" src="../js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="../js/jquery-ui.min.js"></script>
<script type="text/javascript" src="../js/reservation.js"></script>
</head>
<body>
<div>
<h2>검색하신 비행이 현황</h2>
		<table>
			<tr>
				<td>출발지</td>
				<td>도착지</td>
				<td>예상시간</td>
				<td>출발날짜</td>
				<td>도착날짜</td>
				<td>출발시간</td>
				<td>도착시간</td>
			</tr>
		</table>
		<c:forEach var="ad" items="${list}">
		<form action="reservation.do" method="post" id="resForm">
			<input type="hidden" id="snum" name="snum" value="${ad.snum}">
		<table>		
				<tr>
					<td>${ad.start_lo}</td>
					<td>${ad.end_lo}</td>
					<td>${ad.take_time}시간</td>
					<td>${ad.go_date}</td>
					<td>${ad.return_date}</td>
					<td>${ad.go_time}</td>
					<td>${ad.return_time}</td>
				</tr>
				<tr>
					<td>
                  	<label for="a_ticket">성인</label>
                  	<input class="ticket" type="number" min="0" max="1000" name="a_ticket" class="a_ticket1" value="0">
                  
	               	</td>
	               	<td>
	                  <label for="as_ticket">청소년</label>
	                  <input class="ticket" type="number" min="0" max="1000" name="as_ticket" class="as_ticket1" value="0">
	               	</td>
	               	<td>   
	                  <label for="c_ticket">어린이</label>
	                  <input class="ticket" type="number" min="0" max="1000" name="c_ticket" class="c_ticket1" value="0">
	               	</td>
					<td>
						<div style="text-align:center">
						<input type="submit" value="예약" id="ok">
					</div>
					</td>
				</tr>
			</table>
			</form>
			</c:forEach>
			

			<input type="button" value="홈으로" onclick="location.href='../main/main.do'">
</div>
</body>
</html>