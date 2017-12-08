<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>댓글게시판 글수정</title>
<link rel="stylesheet" type="text/css" href="../css/style.css">
<script type="text/javascript" src="../js/jquery-3.2.1.min.js"></script>                       
<script type="text/javascript" src="../js/board.js"></script>
</head>
<body>
<div class="page-main-style">
	<h2>댓글게시판 글수정</h2>
	<form id="update_form" action="update.do" method="post">
		<input type="hidden" name="num" value="${board.num}">
		<ul>
			<li>
				<label for="title">제목</label>
				<input type="text" name="title"
				    value="${board.title}"
				    id="title" maxlength="50">
			</li>
			<li>
				<label for="content">내용</label>
				<textarea rows="5" cols="30"
				  name="content" id="content">${board.content}</textarea>
			</li>
		</ul> 
		<div class="align-center">
			<input type="submit" value="수정">
			<input type="button" value="목록"
			       onclick="location.href='list.do'">
		</div>                    
	</form>
</div>
</body>
</html>













