<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	int bag = 200000;
	int shoes = 100000;
	int clothes = 50000;
	int foodTickets = 150000;
	int sum = 0;
	int fee = 0; 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 
조건 : 구매 금액이 30만원 미만이면 5,000원의 배송비가 추가
[출력예시]
이름 :
날짜 :
구입내용 :
배송비 : (0 | 5000)
총 구매비용(배송비 포함) : 

 -->
	이름 : <%= request.getParameter("name") %> <br>
	날짜 : <%= request.getParameter("date") %> <br>
	구입 내용 : 
	<%
	 	String[] productList = request.getParameterValues("product");
		if(productList!=null){
			for(int i=0;i<productList.length;i++){
	%>
				<%= productList[i]%>
	<%		
			}
		}
	%>
	<br>
	배송비 :
	<%
		for(int i=0;i<productList.length; i++){
			switch(productList[i]){
			case "가방":
				sum += bag;
				break;
			case "신발":
				sum += shoes;
				break;
			case "옷":
				sum += clothes;
				break;
			case "식사권":
				sum += foodTickets;
				break;
			}
		}
	
		if(sum<300000) fee = 5000;
		else fee = 0;
	%>
	<%= fee %>
	<br>
	
	총 구매 비용(배송비 포함) : <%= sum+fee %>
	
</body>
</html>