<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="my.product.dao.ProductDao" %>
<%@ page import="my.product.domain.ProductDto" %>
<%
      //전송된 데이터에 대한 인코딩 처리
      request.setCharacterEncoding("UTF-8");
      //전송된 데이터 반환
      int num = Integer.parseInt(request.getParameter("num"));

   String user_id = (String) session.getAttribute("user_id");
   
   if(user_id ==null){//로그인인 안된 경우
      response.sendRedirect("list.jsp");
   }else{//로그인인 된 경우
      ProductDao dao = ProductDao.getInstance();
       ProductDto products = dao.getProduct(num);
       
       if(products!=null){
          //상품삭제
        dao.productDelete(products);
       }
   }
%>
<!DOCTYPE html">
<html>
<head>
<meta charset="UTF-8">
<title>상품 삭제</title>
<link rel="stylesheet" href="../css/style.css" type="text/css">
</head>
<body>
     <div class="page-main-style">
          <h1>상품 삭제 완료</h1>
          <div class="result-display">
              상품삭제가 완료되었습니다.
              <a href="main.jsp">홈으로</a>
          </div>
     </div>
</body>
</html>