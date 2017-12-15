<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>항로 추가</title>
<script type="text/javascript" src="../js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="../js/reservation.js"></script>
</head>
<body>
	<div>
		<form action="insertAir.do" method="post">
			<table>
			<tr>
				<td>출발지</td>
				<td><input type="text" name="start_lo" id="start_lo"></td>
			</tr>
			<tr>  
				<td>도착지</td>
				<td><input type="text" name="end_lo" id="end_lo"></td>
				</tr>
			<tr>
				<td>출발날짜</td>
				<td><input type="text" name="go_date" id="go_date"></td>
				</tr>
			<tr>
				<td>도착날짜</td>
				<td><input type="text" name="return_date" id="return_date"></td>
				</tr>
			<tr>
				<td>출발 비행기 시간</td>
				<td><input type="text" name="go_time" id="go_time"></td>
				</tr>
			<tr>
				<td>왕복 비행기 시간</td>
				<td><input type="text" name="return_time" id="return_time"></td>
				</tr>
			<tr>
				<td>예상시간</td>
				<td><input type="text" name="take_time" id="take_time"></td>
				</tr>
			<tr>
				<td>비행기 번호</td>
				<td><input type="text" name="ap_num" id="ap_num"></td>
				</tr>
			<tr>
				<td>좌석 수</td>
				<td><input type="number" name="seats" id="seats"></td>
			</tr>
			</table>
			<div>
				<input type="submit" value="추가">
				<input type="button" value="관리자 페이지" onclick="location.href='admin.do'">
			</div>
		</form>
	</div>
</body>
</html>