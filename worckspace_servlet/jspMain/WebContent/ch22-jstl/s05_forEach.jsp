<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.HashMap" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forEach 태그</title>
</head>
<body>
<h4>1부터 100까지 홀수의 합</h4>
<c:set var="sum" value="0"/>
<c:forEach var="i" begin="1" end="100">
	<c:set var="sum" value="${sum+i}"/> <%--jstl을 이용해 데이터를 저장, EL을 이용해 데이터 연산 --%>
</c:forEach>
결과 = ${sum}

<h4>구구단 : 4단</h4>
<ul>
	<c:forEach var="i" begin="1" end="9">
		<li>4 * ${i} = ${4*i}</li>
	</c:forEach>
</ul>

<h4>int형 배열</h4>
<c:set var="intArray" value="<%= new int[]{10,20,30,40,50} %>"/>
<%--확장 for문 형태는 items 속성을 이용함! , varSatatus속성 : 루프에 대한 정보(인덱스,루프 돈 횟수 등)를 읽어올 수 있음--%>
<c:forEach var="i" items="${intArray}" begin="2" end="4" varStatus="status">
	
	${status.first} / ${status.last} / intArray[${status.index}] = ${i} / 루프 카운트 : ${status.count}<br>
</c:forEach>

<h4>Map</h4>
<%
	HashMap<String, String> mapData = new HashMap<String, String>();
	mapData.put("name", "홍길동");
	mapData.put("job", "경찰");
%>
<c:set var="map" value="<%=mapData %>"/>
<c:forEach var="i" items="${map}">
	${i.key} = ${i.value}<br>
</c:forEach>
</body>
</html>