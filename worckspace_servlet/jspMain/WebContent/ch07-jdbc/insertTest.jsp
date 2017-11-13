<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ include file="dbInfo.jspf" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 등록</title>
<link rel="stylesheet" href="style.css" type="text/css">
</head>
<body>
<%
	//전송된 데이터에 대한 인코딩 처리
	request.setCharacterEncoding("UTF-8");

	//전송된 데이터 반환
	String id = request.getParameter("id");
	String passwd= request.getParameter("passwd");
	String name = request.getParameter("name");
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	String sql=null;
	
	try{
		//JDBC 수행 1단계
		Class.forName(driverName);
		//JDBc 수행 2단계
		conn = DriverManager.getConnection(jdbcUrl, dbId, dbPass);
		sql = "INSERT into zmember(id, passwd, name, reg_date) values(?,?,?,sysdate)";
		
		//JDBC 수행 3단계
		pstmt = conn.prepareStatement(sql);
		//SQL문의 ?에 데이터 바인딩
		pstmt.setString(1, id);
		pstmt.setString(2, passwd);
		pstmt.setString(3, name);
		
		//JDBC 수행 4단계
		pstmt.executeUpdate();
%>
	<div class="result-display">
		회원 가입 성공! <br>
		<input type="button" value="목록보기" onclick="location.href='selectTest.jsp'">
	</div>
<%
	}catch(Exception e){
%>
		<div class="result-display">
			오류 발생! 회원 가입 실패! <br>
			<input type="button" value="회원가입폼" onclick="location.href='insertForm.jsp'">
		</div>
<%		
		
		e.printStackTrace();
	}finally{
		//자원 정리
		if(pstmt!=null) try{pstmt.close();} catch(Exception e){}
		if(conn!=null) try{conn.close();} catch(Exception e){}
	}
%>

</body>
</html>