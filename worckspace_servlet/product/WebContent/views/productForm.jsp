<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%
 	Date nowDate = new Date();
 	SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../css/style.css" type="text/css">
<script type="text/javascript">
window.onload=function(){
   
   var form = document.getElementById('productInsert');
   form.onsubmit=function(){
      
      var name= document.getElementById('name');
      if(name.value==''){
         alert('상품명을 입력하세요');
         name.focus();
         return false;
      }
      var price= document.getElementById('price');
      if(price.value==''){
         alert('가격 입력하세요');
         price.focus();
         return false;
      }   
      var stock = document.getElementById('stock');
      if(stock.value==''){
         alert('수량을 입력하세요');
         stock.focus();
         return false;
   }
      var content= document.getElementById('content');
      if(content.value==''){
         alert('상품설명을 입력하세요');
         content.focus();
         return false;
      }
      var reg_date= document.getElementById('reg_date');
      if(reg_date.value==''){
         alert('등록일을 입력하세요');
         reg_date.focus();
         return false;
      }
  };

};

</script>
<title>상품 등록</title>

</head>
<body>

<div class="page-main-style">
     <h1>상품 등록</h1>
     <form id="productInsert" action="product.jsp" method="post">
        <ul>
            <li>
                <label for="name">상품명</label>
                <input type="text" name="name" id="name" >
            </li>
            <li>
                <label for="price">가격</label>
                <input type="number" name="price" id="price">
            </li>
            <li>
                <label for="stock">수량</label>
                <input type="number" name="stock" id="stock">
            </li>
            <li>
                <label for="content">상품설명</label>
                <input type="text" name="content" id="content" >
            </li>
            
        </ul>
        <div class="align-center">
                <input type="submit" value="등록">
                <input type="button"
                  value="홈으로" onclick="location.href='main.jsp'">
        </div>
     </form>

</div>

</body>
</html>