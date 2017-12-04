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
		<form id="search_form" action="list.do" method="get">
			<ul class="search">
				<li>
					<select name="keyfield">
						<option value="title">제목</option>
						<option value="id">ID</option>
						<option value="content">내용</option>
					</select>
				</li>
				<li>
					<input type="search" size="16" name="keyword" id="keyword">
				</li>
				<li>
					<input type="submit" value="검색">
				</li>
			</ul>
		</form>
		<div class="list-space align-right">
			<input type="button" value="글쓰기" onclick="location.href='writeForm.do'"
				<%--로그인이 안되어있을 경우에 비활성화 --%>
				<c:if test="${empty user_id}">disabled="disabled"</c:if>
			>
			<input type="button" value="목록" onclick="location.href='list.do'">
			<input type="button" value="홈으로" onclick="location.href='../main/main.do'">
		</div>
		<c:if test="${count == 0}">
		<div class="result-display">
			등록된 게시물이 없습니다.
		</div>
		</c:if>
		<c:if test="${count>0}">
		<div id="wrap">
			<c:forEach var="board" items="${list}">
			<div class="item">
				<a href="detail.do?num=${board.num}">
				<c:if test="${!empty board.filename}">
				<img src="../upload/${board.filename}" class="list-img">
				<br>
				</c:if>
				<c:if test="${empty board.filename}">
				<div class="list-blank"></div>
				</c:if>
				${board.title}</a>
			</div>
			</c:forEach>
		</div>
		</c:if>
		<div class="align-center">
			${pagingHtml}
		</div>
	</div>
</body>
</html>