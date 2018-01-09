<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring</title>
</head>
<body>

<a href="${pageContext.request.contextPath}/login/login.do">LoginController</a><br>
<a href="${pageContext.request.contextPath}/changeLanguage.do?lang=ko">changeLanguage.do?lang=ko</a><br>
<a href="${pageContext.request.contextPath}/changeLanguage.do?lang=en">changeLanguage.do?lang=en</a><br>
<a href="${pageContext.request.contextPath}/login/login.do?language=ko">/login/login.do?language=ko</a><br>
<a href="${pageContext.request.contextPath}/login/login.do?language=en">/login/login.do?language=en</a><br>
<a href="${pageContext.request.contextPath}/file.do">DownloadController</a><br>
<a href="${pageContext.request.contextPath}/pageRanks.do">pageRanks.do(엑셀)</a><br>

</body>
</html>