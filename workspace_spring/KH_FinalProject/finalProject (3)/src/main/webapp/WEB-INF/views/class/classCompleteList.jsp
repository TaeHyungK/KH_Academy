<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<head> 
 <link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">
</head>

<div class="container">
	<!-- Start Navigation Section -->
    <div class="navigation">
        
        <div class="navbar navbar-default navbar-top">
            <div class="navbar-header">
                <!-- Stat Toggle Nav Link For Mobiles -->
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <i class="fa fa-bars"></i>
                </button>
            </div>
            <div class="navbar-collapse collapse">
    
                <!-- Start Navigation List -->
                <ul class="nav navbar-nav">
                    <li> 
                        <a href="${pageContext.request.contextPath}/main/main.do">Home</a>
                    </li>
                    <li> 
                        <a class="active">소개</a> <!-- 학원소개/강사진소개 -->
                        <ul class="dropdown">
                        	<li>
                        		<a href="${pageContext.request.contextPath}/academy/academyMain.do">학원 소개</a>
                        	</li>
                        	<li>
                        		<a href="${pageContext.request.contextPath}/teacher/teacherInfo.do">강사진 소개</a>
                        	</li>
                        	<li>
                        		<a href="${pageContext.request.contextPath}/class/classList.do">강의 소개</a>
                        	</li>
                        </ul>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/board/list.do">게시판</a> <!-- 정보교류게시판/스터디그룹 모집 게시판 -->
                       	<ul class="dropdown">
                        	<li>
                        		<a href="${pageContext.request.contextPath}/board/list.do">정보 교류 게시판</a>
                        	</li>
                        	<li>
                        		<a href="${pageContext.request.contextPath}/study/sblist.do">스터디그룹 모집 게시판</a>
                        	</li>
                        </ul>
                    </li>
                    <c:if test="${!empty user_id}">
                    <li>
                        <a href="${pageContext.request.contextPath}/academy/academyMain.do">내 정보 관리</a> <!-- 일반회원(1) : 정보보기/찜목록, 학원회원(2): 학원등록/강사등록 -->
                        
                        <c:if test="${user_group == 1}">
                        <ul class="dropdown">
                        <li>
                       		<a href="${pageContext.request.contextPath}/member/detail.do">내 정보</a>
                       	</li>
                       	<li>
                       		<a href="${pageContext.request.contextPath}/class/myClass.do">찜 목록</a>
                       	</li>
                       	</ul>
                        </c:if>
                        <c:if test="${user_group == 2}">
                        <ul class="dropdown">
                        <li>
                       		<a href="#">학원 정보 보기</a> <!-- 학원 정보 등록, 수정 -->
                       	</li>
                       	<li>
                       		<a href="${pageContext.request.contextPath}/class/classMain.do">강의 정보 보기</a> <!-- 강의 등록, 수정, 삭제 -->
                       	</li>
                       	<li>
                       		<a href="${pageContext.request.contextPath}/teacher/teacherMain.do">강사 정보 보기</a> <!-- 강사 등록, 수정, 삭제 -->
                       	</li>
                       	</ul>
                        </c:if>
                    </li>
                    </c:if>
                    
                </ul>
                <!-- End Navigation List -->
            </div>
        </div>
        
    </div>
    <!-- End Navigation Section -->

    
	<!-- Start Breadcrumb Section -->
	<div class="row">
		<div class="col-md-12">
			<div class="page-title">
				<div class="page-title-overlay">
					<h2>Pricing</h2>
					<div>
						<ul class="breadcrumb">
							<li><a href="">Home</a></li>
							<li class="active">Pricing</li>
						</ul>
					</div>

				</div>
			</div>
		</div>
	</div>
	
	<div class="row">
		<div class="sidebar right-sidebar">
			<div class="col-md-8">
            	<div class="contact-section">
            	
 
            	
					<table class="table table-condensed">
						<thead>
							<tr class="cart_menu" align="center">
								<td class="description">강의 명</td>
								<td class="price">개강/종강</td>
								<td class="quantity">현재인원/총인원</td>
								<td class="total">수강료</td>
							</tr>
						</thead>

						 
						<tbody>		
						
						<c:forEach var="list" items="${list}">
							<tr align="center" id="one${list.my_num}" data-num="${list.my_num}">
								
								<td class="cart_description">
									<h4><a href="">${list.c_name}</a></h4>
									<p>학원 이름 : ${list.a_num}</p>
								</td>
								<td class="cart_price">
									<p>${list.c_start} ~ ${list.c_end}</p>
									
								</td>
								
								<td class="cart_quantity">
								${list.c_count}/${list.c_max_count}
								</td> 
								 
								<td class="cart_total">
									<p class="cart_total_price" id="c_price">${list.c_tuition}</p>
 								</td>
								
								
							</tr>
							</c:forEach>
						</tbody>

					</table>
					총 수강료 :  <span id="total">0</span>&nbsp;원
					<script type="text/javascript">
					var list = new Array();
					var total = 0;
		            <c:forEach var="list" items="${list}">
		 		    	list.push(Number("${list.c_tuition}"));
		            </c:forEach>
					 for(var i=0; i<list.length; i++){
						 total += list[i];
					 }
					 showTotal(); 
						
					
					 function showTotal(){ 
				  	 	   $('#total').html(total.toLocaleString());
				  	  	}
					</script>
					
				</div>
        	</div>
			<div class="col-md-4"> 
				<!-- Categories Widget -->
				<div class="widget widget-categories">
					<h3 class="section-title">Categories</h3>
					<ul>
						<li><a href="${pageContext.request.contextPath}/class/myClass.do">내가 찜한 강의</a></li>
						<li><a href="${pageContext.request.contextPath}/member/detail.do">회원 정보 보기</a></li>
						<li><a href="${pageContext.request.contextPath}/member/delete.do">회원 탈퇴</a></li>
						<li><a href="${pageContext.request.contextPath}/main/main.do">홈으로</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</div>
