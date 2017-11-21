<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="my.product.dao.ProductDao" %> 
<%@ page import="my.product.domain.ProductDto" %>
<%@ page import="java.util.List" %>
<%
	//한 화면에 몇개의 글을 보여줄 지 지정
	int rowCount = 10;
	//선택한 페이지 번호
	String pageNum = request.getParameter("pageNum");
	if(pageNum == null){
		pageNum = "1";
	}
	
	int currentPage = Integer.parseInt(pageNum);
	int startRow = (currentPage-1) * rowCount +1;
	int endRow = currentPage * rowCount;
	
	int count = 0;
	
	List<ProductDto> productList = null;
	ProductDao dao = ProductDao.getInstance();
	count = dao.getCount();
	if(count>0){
		productList = dao.getList(startRow, endRow);
	}
 %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 목록</title>
<link rel="stylesheet" href="../css/style.css" type="text/css">
</head>
<body>

    <div class="page-main-style">
         <h1>상품 목록</h1>
         <table>
           <tr>
                <td class="align-right"><a href="productForm.jsp">상품 등록</a></td>
            </tr>
         </table>
<%
		if(count == 0){ //등록된 데이터가 없는경우
%>
		<div class="align-center">등록된 상품이 없습니다.</div>
<%
		}else{ //등록된 데이터가 있는 경우
%>
          <table>
           <%
              for(ProductDto product : productList){
                 %>
                 <tr>
                     <td>
                         <div class="content-header">
                            <b><%=product.getName() %></b> 
							상품가격 <%=product.getPrice() %>
							재고 <%=product.getStock() %> 
							등록일 <%=product.getReg_date() %>
							<a class="algitn-right" href="poductUpdateForm.jsp?num=<%=product.getNum() %>">[수정]</a>
							<a class="algitn-right" href="poductDeleteForm.jsp?num=<%=product.getNum() %>">[삭제]</a>
                         </div>
                         <p>
                             <%=product.getContent() %>
                         </p>
                     </td>
                     
                 </tr>
                 <%
              }
           %>
        </table>
<%
		}

		if(count > 0){
%>
		<div class="align-center">
<%
			//한 화면에 몇개의 페이지 번호가 보여질지를 지정
			int pageBlock = 10;
			//페이지 갯수
			int pageCount = (count-1)/rowCount +1;
			int startPage = ((currentPage-1)/pageBlock) * pageBlock+1;
			int endPage = startPage + pageBlock -1;
			
			if(endPage > pageCount) endPage = pageCount;
			
			if(startPage > pageBlock){
%>
				<a href="list.jsp?pageNum=<%= startPage-1 %>">[이전]</a>
<%
			}
			for(int i=startPage; i<=endPage; i++){
				if(i==currentPage){//현재 페이지일 경우 링크X
%>
				<sapn>[<%=i %>]</sapn>
<%
				}else{//현재 페이지가 아닐 경우 링크 O
%>
					<a href="list.jsp?pageNum=<%=i %>">[<%=i %>]</a>
<%
				}
			}
%>
		</div>
<%
		}
%>
	<h2 class="align-center"><a href="main.jsp">홈으로</a></h2>
    </div>
</body>
</html>