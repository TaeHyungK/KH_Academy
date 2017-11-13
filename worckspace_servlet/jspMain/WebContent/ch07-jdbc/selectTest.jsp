<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Date" %>
<%@ include file="dbInfo.jspf" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록 보기</title>
<link rel="stylesheet" href="style.css" type="text/css">
</head>
<body>
	<div class="page-main-style">
		<h2>회원 목록 보기</h2>
		<div class="align-right">
			<input type="button" value="등록" onclick="location.href='insertForm.jsp'">
 		</div>
	
		<table>
			<tr>
				<th>아이디</th>
				<th>비밀번호</th>
				<th>이름</th>
				<th>가입일</th>
				<th>삭제</th>
			</tr>
	<%
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rs = null;
			String sql = null;
			
			try{
				//JDBC 수행 1단계
				Class.forName(driverName);
				//JDBC 수행 2단계
				conn =DriverManager.getConnection(jdbcUrl, dbId, dbPass);
				
				//SQL문장
				sql = "SELECT * FROM zmember ORDER bY reg_date DESC";
				
				//JDBC 수행 3단계
				pstmt = conn.prepareStatement(sql);
				
				//JDBC 수행 4단계
				rs = pstmt.executeQuery();
				
				//반복문을 이용해서 데이터 반환
				while(rs.next()){
					String id= rs.getString("id");
					String passwd = rs.getString("passwd"); //연습용이기때문에 명시!
					String name = rs.getString("name");
					Date reg_date = rs.getDate("reg_date");
%>
					<tr>
						<td><a href= "updateForm.jsp?id=<%= id %>"><%=id %></a></td>
						<td><%= passwd %></td>
						<td><%= name %></td>
						<td><%= reg_date %></td>
						<td class="align-center"><a href="deleteForm.jsp?id=<%= id %>">X</a></td>
					</tr>				
<%
				}
			}catch(Exception e){
%>
				<tr>
					<td colspan="5" class="align-center">오류 발생! </td>
				</tr>
<%
				e.printStackTrace();
			}finally{
				//자원정리
				if(rs!=null) try{rs.close();} catch(Exception e){}
				if(pstmt!=null) try{pstmt.close();} catch(Exception e){}
				if(conn!=null) try{conn.close();} catch(Exception e){}
				
			}
%>
			
		</table>
	</div>
</body>
</html>