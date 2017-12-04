<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글상세</title>
<link rel="stylesheet" type="text/css" href="../css/style.css">
</head>
<body>
	<div class="page-main-style">
		<h2>게시판 글상세</h2>
		<ul>
			<li>글번호: ${board.num}</li>
			<li>제목: ${board.title}</li>
			<li>작성자: ${board.id}</li>
			<li>조회수: ${board.hit}</li>
		</ul>
		<hr size="1" noshade width="100%">
		<div class="align-center">
			<c:if test="${!empty board.filename}">
				<img src="../upload/${board.filename}" class="detail-img">
			</c:if>
		</div>
		<p>
			${board.content}
		</p>
		<div class="align-right">
			등록날짜: ${board.regdate}
			<input type="button" value="수정" onclick="location.href='updateForm.do?num=${board.num}'"
				<c:if test="${user_id != board.id}">disabled="disabled"</c:if>	
			>
			<input type="button" value="삭제" onclick="location.href='delete.do?num=${board.num}'"
				<c:if test="${user_id != board.id}">disabled="disabled"</c:if>	
			>
			<input type="button" value="목록" onclick="location.href='list.do'">
			
		</div>
	</div>
</body>
</html>