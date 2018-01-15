<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta  content="UTF-8">
<title>회원정보 수정</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" type="text/css">
</head>
<body>
<div class="page-main-style">
   <h2>회원정보 수정</h2>
   <form:form commandName="memberCommand" action="update.do">
   <form:hidden path="id"/>
   <ul>
			<li>
				<label for="id">아이디</label>
				${memberCommand.id}
			</li>
			<li>
				<label for="passwd">비밀번호</label>
				<form:errors path="passwd" cssClass="error-color"/>
			</li>
			<li>
				<label for="name">이름</label>
				<form:input path="name" />
				<form:errors path="name" cssClass="error-color"/>
			</li>
		</ul>
		<div class="align-center">
			<input type="submit" value="수정">
			<input type="button" value="홈으로" onclick="location.href='list.do'">
		</div>
   </form:form>
</div>
</body>
</html>