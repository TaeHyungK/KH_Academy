<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.guestbook.dao.GuestbookDao" %>
<%@ page import="kr.guestbook.domain.GuestbookDto" %>
<%
	//전송된 데이터에 대한 인코딩 처리
	request.setCharacterEncoding("UTF-8");

	//전송된 데이터 반환
	int num = Integer.parseInt(request.getParameter("num"));
	String passwd = request.getParameter("passwd");
	
	GuestbookDao dao = GuestbookDao.getInstance();
	GuestbookDto book = dao.getGuestbook(num);
	boolean check = false;
	
	if(book!=null){
		//비밀번호 체크
		check = book.isCheckedPasswd(passwd);
	}
	
	if(check){//비밀번호 일치시
		//삭제 작업
		dao.delete(num);
%>
		<script>
			alert('글을 삭제했습니다!');
			location.href='list.jsp';
		</script>
<%
	}else{//비밀번호 불일치시
%>
		<script>
			alert('비밀번호가 불일치합니다.');
			history.go(-1);
		</script>
<%	
	}
%>
