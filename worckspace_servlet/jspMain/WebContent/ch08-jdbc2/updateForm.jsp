<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ include file="dbInfo.jspf" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 정보 수정</title>
<link rel="stylesheet" href="style.css" type="text/css">
<script type="text/javascript">
	window.onload=function(){
		var myForm = document.getElementById('myForm');
		
		myForm.onsubmit=function(){
			var name = document.getElementById('name');
			var price = document.getElementById('price');
			var stock = document.getElementById('stock');
			var place = document.getElementById('place');
			
			if(name.value==''){
				alert('수정할 제품 이름을 입력하세요.')
				name.focus();
				return false;
			}else if(price.value==''){
				alert('수정할 제품의 가격을 입력하세요.')
				price.focus();
				return false;
			}else if(stock.value==''){
				alert('수정할 제품의 제품수량을 입력하세요.')
				stock.focus();
				return false;
			}else if(place.value==''){
				alert('수정할 제품의 원산지를 입력하세요.')
				place.focus();
				return false;
			}
			
		}
	}
</script>
</head>
<body>
<%
	String user_id = request.getParameter("id");
	System.out.println(user_id);	

	Connection conn= null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = null;
	
	try{
		Class.forName(driverName);
		
		conn = DriverManager.getConnection(jdbcUrl, dbId, dbPass);
		
		sql = "SELECT * FROM product WHERE id=?";
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, user_id);
		
		rs = pstmt.executeQuery();
		if(rs.next()){
			String id= rs.getString("id");
			String name= rs.getString("name");
			int price= rs.getInt("price");
			int stock= rs.getInt("stock");
			String place= rs.getString("place");
%>
			<div class="page-main-style">
				<h2>회원 정보 수정</h2>
				<form id="myForm" action="updateTest.jsp" method="post">
					<ul>
						<li>
							<label for="id">아이디</label>
							<input type="hidden" name="id" value="<%=id %>"> <%=id %>
						</li>
						<li>
							<label for="name">이름</label>
							<input type="text" name="name" id="name" value="<%=name %>" size="20" maxlength="30">
						</li>
						<li>
							<label for="price">가격</label>
							<input type="number" name="price" id="price" value="<%=price %>"max="100000000">
						</li>
						<li>
							<label for="stock">재고수량</label>
							<input type="number" name="stock" id="stock" value="<%=stock %>" >
						</li>
						<li>
							<label for="place">원산지</label>
							<input type="text" name="place" id="place" value="<%=place %>">
						</li>
					</ul>
					<div class="align-center">
						<input type="submit" value="수정완료">
						<input type="button" value="목록" onclick="location.href='listTest.jsp'">
					</div>
				</form>
			</div>

<%
		}else{
%>
		<div class="result-display">
			오류 발생! 제품 정보 수정 폼 호출 실패!<br>
			<input type="button" value="제품 목록" onclick="location.href='listTest.jsp'">
		</div>
<%
		}
		
	}catch(Exception e){
%>
		<div class="result-display">
			오류 발생! 제품 정보 수정 폼 호출 실패!
			<input type="button" value="제품 목록" onclick="location.href='listTest.jsp'">
		</div>
<%
		e.printStackTrace();
	}finally{
		if(rs!=null) try{rs.close();} catch(Exception e){}
		if(pstmt!=null) try{pstmt.close();} catch(Exception e){}
		if(conn!=null) try{conn.close();} catch(Exception e){}
	}
%>
</body>
</html>