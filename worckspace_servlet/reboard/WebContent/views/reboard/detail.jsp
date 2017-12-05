<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>댓글게시판 글 상세</title>
<link rel="stylesheet" type="text/css" href="../css/style.css">
<script type="text/javascript" src="../js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="../js/board.js"></script>
</head>
<body>
	<div class="page-main-style">
		<h2>게시판 글상세</h2>
		<ul>
			<li>글 번호 : ${board.num}</li>
			<li>제목 : ${board.title}</li>
			<li>작성자 : ${board.id}</li>
			<li>조회수 : ${board.hit}</li>			
		</ul>
		<hr size="1" noshade width="100%">
		<p>
			${board.content}
		</p>
		<div class="align-right">
			등록날짜 : ${board.regdate}
			<input type="button" value="수정" onclick="location.href='updateForm.do?num=${board.num}'"
			<c:if test="${user_id != board.id}">disabled="disabled"</c:if>
			>
			<input type="button" value="삭제" onclick="location.href='delete.do?num=${board.num}'"
			<c:if test="${user_id != board.id}">disabled="disabled"</c:if>
			>
			<input type="button" value="목록" onclick="location.href='list.do'">
		</div>
		<div id="reply_div">
			<span class="reply-title">댓글 달기</span>
			<form id="re_form">
				<input type="hidden" name="num" value="${board.num}" id="num">
				<input type="hidden" name="id" value="${user_id}" id="user_id">
				<textarea rows="3" cols="50" name="re_content"></textarea>
				<c:if test="${!empty user_id}">
				<div id="re_first">
					<span class="letter-count">300/300</span>
				</div>
				<div id="re_second" class="align-right">
					<input type="submit" value="전송">
				</div>
				</c:if>
			</form>
		</div>
	</div>
</body>
</html>