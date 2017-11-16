<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.guestbook.dao.GuestbookDao" %>
<%@ page import="kr.guestbook.domain.GuestbookDto" %>
<%@ page import="java.util.List" %>
<%
	int startRow = 1;
	int endRow = 10;
	List<GuestbookDto> bookList = null;
	GuestbookDao dao = GuestbookDao.getInstance();
	bookList = dao.getList(startRow, endRow);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록 글목록</title>
<link rel="stylesheet" href="../css/style.css" type="text/css">
</head>
<body>
	<div class="page-main-style">
		<h1>방명록 글목록</h1>
		<table>
			<tr>
				<td class="align-right"> <a href="wirteForm.jsp">글쓰기</a></td>
			</tr>
		</table>
		<!-- 목록 출력 시작 -->
		<table>
<% 
			for(GuestbookDto book : bookList){
%>
			<tr>
				<td>
					<div class="content-header">
						<b><%=book.getName() %></b> - <%=book.getRegister() %>
						<a href="updateForm.jsp?num=<%= book.getNum() %>">[수정]</a>
						<a href="deleteForm.jsp?num=<%= book.getNum() %>">[삭제]</a>
					</div>
					<p>
						<%= book.getContent() %>
					</p>
				</td>
			</tr>
<%
			}
%>
		</table>
		<!-- 목록 출력 끝 -->
	</div>
</body>
</html>