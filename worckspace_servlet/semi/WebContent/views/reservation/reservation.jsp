<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약 확인</title>
</head>
<body>
	<table>
			<tr>
				<td>예약번호</td>
				<td>출발지</td>
				<td>도착지</td>
				<td>예상시간</td>
				<td>출발날짜</td>
				<td>도착날짜</td>
				<td>출발시간</td>
				<td>도착시간</td>
				<td>티켓매수(성인,학생,어린이)</td>
			</tr>
			<tr>
				<td>${random}</td>
				<td>${ad.start_lo}</td>
				<td>${ad.end_lo}</td>
				<td>${ad.take_time}</td>
				<td>${ad.go_date}</td>
				<td>${ad.return_date}</td>
				<td>${ad.go_time}</td>
				<td>${ad.return_time}</td>
				<td>${ad.total_ticket}(${ad.adult},${ad.student},${ad.kid})</td>
			</tr>
	</table>
	<br>
	<input type="button" value="예약 목록으로" onclick="location.href='about.do'">
	<input type="button" value="홈으로" onclick="location.href='../main/main.do'">
</body>
</html>