<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/style.css">
<script type="text/javascript" src="../js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="../js/board.js"></script>
</head>
<body>
	<div class="page-main-style">
		<h2>게시판 글수정</h2>
		<form id="update_form" action="update.do" method="post" enctype="multipart/form-data">
			<input type="hidden" name="num" value="${board.num}">
			<ul>
				<li>
					<label for="title">제목</label>
					<input type="text" name="title" id="title" maxlength="50" value="${board.title}">
				</li>
				<li>
					<label for="content">내용</label>
					<textarea rows="5" cols="30" name="content" id="content">${board.content}</textarea>
				</li>
				<li>
					<label for="filename">파일제목</label>
					<input type="file" name="filename" id="filename" accept="image/*">
					<c:if test="${!empty board.filename}">
						<br>
						<span>(${board.filename})파일이 등록되어 있습니다.<br>
						다시 업로드하면 기존 파일은 삭제됩니다.</span>
					</c:if>
				</li>
			</ul>
			<div class="align-center">
					<input type="submit" value="수정">
					<input type="button" value="목록" onclick="location.href='../board/list.do'">
			</div>
		</form>
	</div>
</body>
</html>