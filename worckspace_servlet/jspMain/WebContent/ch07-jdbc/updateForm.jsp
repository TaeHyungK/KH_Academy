
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@page import="java.sql.ResultSet"%>
<%@ include file="dbInfo.jspf" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
<link rel="stylesheet" href=style.css type="text/css">
<script type="text/javascript">
	window.onload=function(){
		var myForm = document.getElementById('myForm');
		
		myForm.onsubmit=function(){
		
			var passwd = document.getElementById('passwd');
			var name = document.getElementById('name');
			
			if(passwd.value == ''){
				alert('패스워드를 입력하세요.');
				passwd.focus();
				return false;
			}else if(name.value==''){
				alert('이름을 입력하세요.');
				name.focus();
				return false;
			}
		}
	}
</script>
</head>
<body>
<%
	String user_id = request.getParameter("id");
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql= null;
	
	try{
		//JDBC 수행 1단계
		Class.forName(driverName);
		//JDBC 수행 2단계
		conn = DriverManager.getConnection(jdbcUrl, dbId, dbPass);
		//SQL문 작성
		sql = "SELECT * FROM zmember WHERE id=?";
		
		//JDBC 수행 3단계
		pstmt = conn.prepareStatement(sql);
		//SQL문의 ?에 데이터 바인딩
		pstmt.setString(1, user_id);
		
		//JDBC 수행 4단계
		rs = pstmt.executeQuery();
		if(rs.next()){
			String id = rs.getString("id");
			String name = rs.getString("name");
%>
		<div class="page-main-style">
			<h2>회원 정보 수정</h2>
			<form id="myForm" action="updateTest.jsp" method="post">
				<ul>
					<li>
						<label for="id">아이디</label>
						<input type="hidden" name="id" id="id" value="<%=id %>"><%=id %>
					</li>
					<li>
						<label for="passwd">비밀번호</label>
						<input type="password" name="passwd" id="passwd" size="20" maxlength="10">
					</li>
					<li>
						<label for="name">이름</label>
						<input type="text" name="name" id="name" value="<%=name %>" size="20" maxlength="10">
					</li>
				</ul>
				<div class="align-center">
					<input type="submit" value="보내기">
					<input type="button" value="목록" onclick="location.href='selectTest.jsp'">
				</div>
			</form>
		</div>
		
<%	
		}else{
%>
			<div class="result-display">
				오류 발생! 회원 정보 수정 폼 호출 실패!<br>
				<input type="button" value="회원 목록" onclick="location.href='selectTest.jsp'"> 
			</div>
<%
		}
		
	}catch(Exception e){
%>
		<div class="result-display">
				오류 발생! 회원 정보 수정 폼 호출 실패!<br>
				<input type="button" value="회원 목록" onclick="location.href='selectTest.jsp'"> 
			</div>
<%
		e.printStackTrace();
	}finally{
		//자원정리
		if(rs!=null) try{rs.close();} catch(Exception e){}
		if(pstmt!=null) try{pstmt.close();} catch(Exception e){}
		if(conn!=null) try{conn.close();} catch(Exception e){}
	}
%>
</body>
</html>	