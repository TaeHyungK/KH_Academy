<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta content="UTF-8">
<title>Spring Framework</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/hello.do">HelloController</a><br>
<a href="${pageContext.request.contextPath}/work.do">WorkController</a><br>
<a href="${pageContext.request.contextPath}/search/internal.do?query=kim">SearchController - internal.do</a><br>
<a href="${pageContext.request.contextPath}/search/external.do">SearchController - external.do</a><br>
<a href="${pageContext.request.contextPath}/article/newArticle.do">NewArticleController</a><br>
<a href="${pageContext.request.contextPath}/cookie/make.do">CookieController - make.do</a><br>
<a href="${pageContext.request.contextPath}/cookie/view.do">CookieController - view.do</a><br>
<a href="${pageContext.request.contextPath}/search/main.do">GameSearchController</a><br>
<a href="${pageContext.request.contextPath}/login/login.do">LoginController</a><br>
<a href="${pageContext.request.contextPath}/report/submitReport.do">SubmitReportController</a><br>
<a href="${pageContext.request.contextPath}/file/fileUpload.do">FileController(다중업로드)</a><br>
<a href="${pageContext.request.contextPath}/math/divide.do?op1=5&op2=2">ArithmeticOperatorController(다중업로드)</a><br>
<a href="${pageContext.request.contextPath}/math/divide.do?op1=5&op2=2">ArithmeticOperatorController</a><br>
</body>
</html>