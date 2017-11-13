
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
<title>상품 목록 보기</title>
<link rel="stylesheet" href="style.css" type="text/css">
</head>
<body>

	<div class="page-main-style">
		<h2 class="align-center">상품 목록 보기</h2>
		<div class="align-right">
			<input type="button" value="등록" onclick="location.href='insertForm.jsp'">
		</div>
		<!-- 아이디, 이름, 가격, 재고, 원산지, 등록일, 삭제 -->
		<table>
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>가격</th>
				<th>재고</th>
				<th>원산지</th>
				<th>등록일</th>
				<th>삭제</th>
			</tr>
<%
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql= null;
			
			try{
				Class.forName(driverName);
				
				conn = DriverManager.getConnection(jdbcUrl, dbId, dbPass);
				
				sql = "SELECT * FROM product ORDER BY reg_date DESC";
				
				pstmt = conn.prepareStatement(sql);
				
				rs = pstmt.executeQuery();
				
				while(rs.next()){
					String id=rs.getString("id");
					String name=rs.getString("name");
					int price = rs.getInt("price");
					int stock = rs.getInt("stock");
					String place = rs.getString("place");
					String reg_date = rs.getString("reg_date");
%>
					<tr>
						<td><a href="updateForm.jsp?id=<%= id %>"><%=id %></a></td>
						<td><%=name %></td>
						<td><%=price %></td>
						<td><%=stock %></td>
						<td><%=place %></td>
						<td><%=reg_date %></td>
						<td class="align-center"><a href="deleteForm.jsp">X</a></td>		
					</tr>
<%				
				}
			}catch(Exception e){
%>
				<tr>
					<td colspan="5" class="align-center">오류 발생 </td>
				</tr>					
<%
				e.printStackTrace();
			}finally{
				//자원 정리
				if(rs!=null) try{rs.close();} catch(Exception e){}
				if(pstmt!=null) try{pstmt.close();} catch(Exception e){}
				if(conn!=null) try{conn.close();} catch(Exception e){}
			}
%>
		</table>
	</div>

</body>
</html>