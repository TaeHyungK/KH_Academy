<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.HashMap"%>
<!-- 
   구매 금액이 30만원 미만이면 배송비 5천원 추가
   [출력예시]
   이름 : 
   날짜 :
   구입 내용 :
   배송비 :
   총구매비용(배송비포함) :
 -->
<%
	request.setCharacterEncoding("utf-8");

	HashMap<String,Integer> map = new HashMap<String,Integer>();
	map.put("가방", 200000);
	map.put("신발", 100000);
	map.put("옷", 50000);
	map.put("식사권", 150000);
	
	int delivery_fee = 5000;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구매 내역</title>
</head>
<body>
이름 : <%= request.getParameter("name") %><br> 
날짜 : <%= request.getParameter("order_date") %><br> 
구입 내용 :
<%
	String[] items = request.getParameterValues("item");
    int sum = 0;
	if(items!=null){
		for(int i=0;i<items.length;i++){
			sum += map.get(items[i]);	
%>
	<%= items[i] %>
<%			
	}	
%>
	<br>
	배송비 :
<%	
	if(sum<300000) sum += delivery_fee;
	else delivery_fee = 0;
%>
	<%= delivery_fee %>원<br>
	총구매비용(배송비 포함) : <%= sum %>
<%				
	}
%>
</body>
</html>