<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
<link rel="stylesheet" type="text/css" href="../css/style.css">
<script type="text/javascript" src="../js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="../js/board.js"></script>
</head>
<body>
	<div class="page-main-style">
		<h2>게시판 목록</h2>
		<div class="list-space align-right">
			<input type="button" value="글쓰기" onclick="location.href='writeForm.do'"
				<%--로그인이 안되어있을 경우에 비활성화 --%>
				<c:if test="${empty user_id}">disabled="disabled"</c:if>
			>
			<input type="button" value="홈으로" onclick="location.href='../main/main.do'">
		</div>
		<c:if test="${count == 0}">
		<div class="result-display">
			등록된 게시물이 없습니다.
		</div>
		</c:if>
		<c:if test="${count>0}">
		<table>
			<tr>
				<th>글번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>날짜</th>
				<th>조회</th>
			</tr>
			<c:forEach var="board" items="${list}">
			<tr>
				<td>${board.num}</td>
				<td><a href="detail.do?num=${board.num}">${board.title}</a></td>
				<td>${board.id}</td>
				<td>${board.regdate}</td>
				<td>${board.hit}</td>
			</tr>
			</c:forEach>
		</table>
		</c:if>
		<div class="align-center">
			${pagingHtml}
		</div>
	</div>
</body>
</html>