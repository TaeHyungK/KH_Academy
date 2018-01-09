<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="login.form.title"/></title>
</head>
<body>
<form:form commandName="login">
	<form:errors element="div"/>
	<p>
		<label for="id"><spring:message code="login.form.id"/>
			<form:input path="id"/>
			<form:errors path="id"/>
		</label>
	</p>
	<p>
		<label for="password"><spring:message code="login.form.password"/>
			<form:password path="password"/>
			<form:errors path="password"/>
		</label>
	</p>
	<input type="submit" value="<spring:message code="login.form.submit"/>">
</form:form>

</body>
</html>