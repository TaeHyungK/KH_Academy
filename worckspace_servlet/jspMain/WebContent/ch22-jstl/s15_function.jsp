<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>함수 사용</title>
</head>
<body>
<c:set var="str1" value="Functions 사용합니다."/>
<c:set var="str2" value="사용"/>
문자열 str1의 길이 : ${fn:length(str1)}<br>
대문자로 표시 : ${fn:toUpperCase(str1)}<br>
소문자로 표시 : ${fn:toLowerCase(str1)}<br>
문자열 추출 : ${fn:substring(str1,3,6)}<br>
문자 대체 : ${fn:replace(str1," ","-")}<br>
인덱스 구하기 : ${fn:indexOf(str1,str2)}<br>
문자열 검색 : ${fn:startsWith(str1,"Fun")}<br> <%--해당 문자열이 시작인지 --%>
문자열 검색 : ${fn:endsWith(str1,"합니다.")}<br> <%--해당 문자열이 마지막인지 --%>
문자열 검색 : ${fn:contains(str1,str2)}<br> <%--첫번째 문자열에 두번째 문자열이 포함되어 있는지 --%>
</body>
</html>