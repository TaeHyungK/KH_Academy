<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//전송된 데이터에 대한 인코딩 처리
	request.setCharacterEncoding("UTF-8");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>요청 파라미터 출력</title>
</head>
<body>
	<h3>request.getParameter() 메소드 사용</h3>
	이름 : <%=request.getParameter("name") %><br>
	주소 : <%=request.getParameter("address") %><br>
	
	<h3>request.getParameterValues() 메소드 사용</h3>
	좋아하는 동물 : 
	<%
		String[] values = request.getParameterValues("pet");
		if(values!=null){
			for(int i=0;i<values.length;i++){
	%>
				<%=values[i] %>
	<%		}
		}
	%>
</body>
</html>