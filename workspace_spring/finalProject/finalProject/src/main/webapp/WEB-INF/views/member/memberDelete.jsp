<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="page-main-style">
	<h1>회원 로그인</h1>
	<!-- 	// 같은 경로에서 파일을 호출시에는 파일명만 호출해도 앞에 있는 주소는 그대로 나옴 -->
	<form:form commandName="command" action="delete.do" id="delete_form">
	<form:hidden path="id"/>
		<form:errors element="div" cssClass="error-color"/>
		<ul>
			<li>
				<label for="passwd">비밀번호</label>
				<form:password path="passwd"/>
				<form:errors path="passwd" cssClass="error-color"/>
			</li>
		</ul>
		<div class="align-center">
			<input type="submit" value="전송">
			<input type="button" value="Home" onclick="location.href='${pageContext.request.contextPath}/main/main.do'">
		</div>
	</form:form>
</div>
























