<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.member.dao.MemberDao" %>
<%@ page import="kr.member.domain.MemberDto" %>
<%
	String user_id = (String)session.getAttribute("user_id");
	if(user_id==null){//로그인 되지 않은 경우
		response.sendRedirect("loginForm.jsp");
	}else{//로그인 된 경우
		MemberDao dao = MemberDao.getInstance();
		MemberDto member = dao.getMember(user_id);
		boolean check = false;
		
		if(member!=null){
			//전송된 데이터에 대한 인코딩 처리
			request.setCharacterEncoding("UTF-8");
			
			String passwd = request.getParameter("passwd");
			//비밀번호 일치 여부 체크
			check = member.isCheckedPasswd(passwd);
		}
		if(check){//비밀번호 일치시
			//회원정보 삭제
			dao.deleteMember(user_id);
			//로그아웃
			session.invalidate();
		
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 탈퇴</title>
<link rel="stylesheet" href="../css/style.css" type="text/css">
</head>
<body>
	<div class="page-main-style">
		<h1>회원탈퇴 완료</h1>
		<div class="result-dsiplay">
			회원 탈퇴가 완료되었습니다.
			<a href="main.jsp">홈으로</a>
		</div>
	</div>
</body>
</html>
<%
		}else{//비밀번호 불일치시
%>
			<script>
				alert('비밀번호가 불일치합니다.');
				history.go(-1);
			</script>
<%
		}
	}
%>