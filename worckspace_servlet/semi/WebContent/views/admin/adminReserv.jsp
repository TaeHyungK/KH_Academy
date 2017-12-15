<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>항로 추가/삭제</title>
<link rel="stylesheet" type="text/css" href="../css/style.css">
<link rel="stylesheet" href="../css/jquery-ui.css">
<script type="text/javascript" src="../js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="../js/jquery-ui.min.js"></script>
<script type="text/javascript" src="../js/reservation.js"></script>
</head>
<body>
<div>
	<c:if test="${empty list}">
		<h2>등록된 항목이 없습니다.</h2>
	</c:if>
<c:forEach var="ad" items="${list}">
	<div>
		<table>
			<tr>
				<td>
				출발지 : ${ad.start_lo}
				</td>
				<td>
				도착지 : ${ad.end_lo}
				</td>
				<td>
				출발 날짜 : ${ad.go_date}
				</td>
				<td>
				돌아오는 날 : ${ad.return_date}
				</td>
			</tr>
		</table>
		<div>
			<input type="button" value="수정" onclick="location.href='modifyFormAir.do?snum=${ad.snum}'">
			<input type="button" value="삭제" onclick="location.href='deleteAir.do?snum=${ad.snum}'">
		</div>
	</div>
</c:forEach>
<br> 
		<div>
			<input type="button" value="추가" onclick="location.href='insertFormAir.do'">
			<input type="button" value="홈으로" onclick="location.href='main.do'">
		</div>
</div>
</body>
</html>