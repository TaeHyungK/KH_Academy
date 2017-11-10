<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1부터 10까지의 합 - Script</title>
</head>
<body>
<%
	//스크립트릿 구역 : 변수 선언, 연산, 제어문, 출력 등 사용 가능
	int sum = 0;
	for(int i=0;i<=10;i++){
		sum += i;
	}
	//출력
	//out.println("1부터 10까지의 합은 " + sum + "입니다.<br>");
%>
<!-- HTML 주석은 compile에서 포함됨. JSP주석은 compile에서 빠지기 때문에 유저한테 보이지 않음 -->
<%-- 
JSP용 주석
표현식 : 변수의 값을 출력하거나 메소드의 결과값을 출력
	    연산의 결과값 출력
 --%>
1부터 10까지의 합은 <%=sum /*하하*/%> 입니다.


</body>
</html>