<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.guestbook.dao.GuestbookDao" %>
<%
	//전송된 데이터에 대한 인코딩 처리
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="book" class="kr.guestbook.domain.GuestbookDto"/>
<jsp:setProperty name="book" property="*"/>
<%
	GuestbookDao dao = GuestbookDao.getInstance();
	dao.insert(book);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기 완료</title>
<link rel="stylesheet" href="../css/style.css" type="text/css">
</head>
<body>
	<div class="page-main-style">
		<h1>글쓰기 완료</h1>
		<div class="result-display">
			방명록에 글을 등록했습니다.
			<a href="list.jsp">목록</a>
		</div>
	</div>
</body>
</html>