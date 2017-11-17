<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.guestbook.dao.GuestbookDao" %>
<%@ page import="kr.guestbook.domain.GuestbookDto" %>
<%@ page import="java.util.List" %>
<%
	//한 화면에 몇 개의 글(행, 레코드)을 보여줄 지 지정
	int rowCount = 10;	

	//선택한 페이지 번호
	String pageNum = request.getParameter("pageNum");
	if(pageNum==null){ //처음에 list.jsp로 호출시
		pageNum = "1";
	}
	int currentPage = Integer.parseInt(pageNum);
	
	int startRow = (currentPage-1) * rowCount + 1;
	int endRow = currentPage*rowCount;
	
	int count = 0;
	
	List<GuestbookDto> bookList = null;
	GuestbookDao dao = GuestbookDao.getInstance();
	count = dao.getCount();
	if(count>0){
		bookList = dao.getList(startRow, endRow);
	}
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
				<td class="align-right"><a href="writeForm.jsp">글쓰기</a></td>
			</tr>
		</table>
		
<%
		if(count ==0){//등록된 데이터가 없는경우
%>
		<div class="align-center">방명록에 저장된 글이 없습니다.</div>
<%
		}else{//등록된 데이터가 있는 경우
%>
		
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
<%
		}
		
		if(count > 0){
%>
			<div class="align-center">
<%
			//한 화면에 몇개의 페이지 번호가 보여지는지를 지정
			int pageBlock = 10;
			//페이지 갯수
			int pageCount = (count -1) / rowCount +1;
			int startPage = ((currentPage - 1)/pageBlock) * pageBlock +1;
			int endPage = startPage + pageBlock - 1;
			
			if(endPage > pageCount) endPage = pageCount;
			
			if(startPage > pageBlock){
%>				<%--자기 자신을 호출 --%>
				<a href="list.jsp?pageNum=<%= startPage-1 %>">[이전]</a>
<%
			}
			for(int i=startPage;i<=endPage;i++){
				if(i==currentPage){ //현재 페이지일 경우 링크 X
%>
					<span>[<%=i %>]</span>
<%
				}else{ //현재 페이지가 아닐 경우 링크 O
%>					<%--자기 자신을 호출 --%>
					<a href="list.jsp?pageNum=<%=i%>">[<%=i %>]</a>
<%
				}
				
			}
			
			if(endPage < pageCount){
%>
				<a href="list.jsp?pageNum=<%= startPage+pageBlock %>">[다음]</a>
<%
			}
%>
			</div>
<%
		}
%>
	</div>
</body>
</html>