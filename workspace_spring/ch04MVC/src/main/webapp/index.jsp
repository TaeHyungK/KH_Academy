<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring Framework</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/hello.do">HelloController</a><br>
<a href="${pageContext.request.contextPath}/work.do">WorkController</a><br>
<a href="${pageContext.request.contextPath}/search/internal.do?query=kim&p=2">SearchController - internal.do</a><br>
<a href="${pageContext.request.contextPath}/search/external.do">SearchController - external.do</a><br>
<a href="${pageContext.request.contextPath}/article/newArticle.do?">newArticleController</a><br>
<a href="${pageContext.request.contextPath}/cookie/make.do">CookieController - make.do</a><br>
<a href="${pageContext.request.contextPath}/cookie/view.do">CookieController - view.do</a><br>
<a href="${pageContext.request.contextPath}/search/main.do">GameSearchController</a><br>

</body>
</html>