<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Script 연습</title>
</head>
<body>
	<h2>표현식 예제 - 배열의 내용 출력</h2>
 	<%!
 		//선언부 : 변수 선언, 메소드 선언
 		String[] str = {"JSP가", "정말", "재미", "있다."};
 	%>
 	<table border="1">
 		<tr>
 			<th>배열의 인덱스</th>
 			<th>배열의 내용</th>
 		</tr>
 		<%
 		//스크립트릿 : 변수 선언, 연산, 제어문, 출력
 		for(int i=0;i<str.length;i++){
 			//출력
 			out.println("<tr>");
 			out.println("  <td>" + i + "</td>");
 			out.println("  <td>" + str[i] + "</td>");
 			out.println("</tr>");
 		}
 		%>
 	</table>
 	<br>
 	스크립트릿과 표현식 사용
 	<table border="1">
 		<tr>
 			<th>배열의 인덱스</th>
 			<th>배열의 내용</th>
 		</tr>
 		<%
 			for(int i=0;i<str.length;i++){
 		%>
	 		<tr>
	 			<td><%= i %></td>
	 			<td><%= str[i] %></td>
	 		</tr>
 		<%
 			}
 		%>
 	</table>
 	<br>
 	확장 for문 사용
 	<table border="1">
 		<tr>
 			<th>배열의 내용</th>
 		</tr>
 	<%
 		for(String s : str){
 	%>
 		<tr>
 			<td><%= s %></td>
 		</tr>
 	<%
 		}
 	%>
 	</table>
 	

</body>
</html>