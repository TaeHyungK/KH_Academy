<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.guestbook.dao.GuestbookDao" %>
<%@ page import="kr.guestbook.domain.GuestbookDto" %>
<%
	//전송된 데이터에 대한 인코딩 처리
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="book" class="kr.guestbook.domain.GuestbookDto"/>
<jsp:setProperty name="book" property="*"/>
<%
	GuestbookDao dao = GuestbookDao.getInstance();
	GuestbookDto guestbook = dao.getGuestbook(book.getNum());
	boolean check=false;
	
	if(guestbook!=null){
		check = guestbook.isCheckedPasswd(book.getPasswd());
	}
	
	if(check){
		dao.update(book);
%>
		<script>
		alert('글 수정을 완료했습니다.');
		location.href='list.jsp';
		</script>
<%
	}else{	//비밀번호 불일치시
%>
		<script>
			alert('비밀번호가 틀렸습니다.');
			history.go(-1);
		</script>
<%
	}
%>