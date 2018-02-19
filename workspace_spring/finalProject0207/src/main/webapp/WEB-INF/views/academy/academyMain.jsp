<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
   int accordianCount = 1;
   int rank = 1;
%>

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
                        <a class="active" href="${pageContext.request.contextPath}/academy/academyMain.do">소개</a> <!-- 학원소개/강사진소개 -->
                        <ul class="dropdown">
                        	<li>
                        		<a href="${pageContext.request.contextPath}/academy/academyMain.do">학원 소개</a>
                        	</li>
                        	<li>
                        		<a href="#">강사진 소개</a>
                        	</li>
                        </ul>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/board/list.do">게시판</a> <!-- 정보교류게시판/스터디그룹 모집 게시판 -->
                       	<ul class="dropdown">
                        	<li>
                        		<a href="#">정보 교류 게시판</a>
                        	</li>
                        	<li>
                        		<a href="#">스터디그룹 모집 게시판</a>
                        	</li>
                        </ul>
                    </li>
                    <c:if test="${!empty user_id}">
                    <li>
                        <a href="${pageContext.request.contextPath}/academy/academyMain.do">내 정보 관리</a> <!-- 일반회원(1) : 정보보기/찜목록, 학원회원(2): 학원등록/강사등록 -->
                        
                        <c:if test="${user_group == 1}">
                        <ul class="dropdown">
                        <li>
                       		<a href="#">내 정보</a>
                       	</li>
                       	<li>
                       		<a href="#">찜 목록</a>
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
                    <h2>Introduce</h2>
                    <div>
                        <ul class="breadcrumb">
                            <li><a href="${pageContext.request.contextPath}/main/main.do">Home</a></li>
                            <li class="active">Academies</li>
                            <li><a href="${pageContext.request.contextPath}/academy/teacherMain.do">Teachers</a>
                        </ul>
                    </div>
                    
                </div>
            </div>
        </div>
    </div>
    <!-- End Breadcrumb Section -->
    
    <!-- Start Pricing Page -->
    <div class="row">
        <div class="col-md-12">
            <div class="pricing-section">
                <h3 class="section-title">Top 5</h3>
                <div class="row">
                    <div class="pricing" id="pricing">
                  <c:forEach var="topItem" items="${topList}">
                  <div class="pricing-table">
                     <div class="plan-name">
                        <h3><%=rank %> 순위</h3>
                     </div>
                               <div class="plan-price line_hide">
                                   <div class="price-value">${topItem.a_name}</div>
                               </div>
                               <div class="plan-list">
                                   <ul>
                                       <li>${topItem.a_content}</li>
                                       <li style="text-align:left;"><i class="fa fa-globe"></i> <strong>위치: </strong>${topItem.a_location}</li>
                                       <li style="text-align:left;"><i class="fa fa-mobile"></i> <strong>전화번호: </strong>${topItem.a_phone}</li>
                                       <li style="text-align:left;"><i class="fa fa-thumbs-up"></i> <strong>좋아요: </strong>${topItem.a_good}</li>
                                   </ul>
                               </div>
                               <div class="plan-signup">
                                   <a href="academyDetail.do?a_num=${topItem.a_num}" class="btn-system btn-small">더보기</a>
                               </div>         
                  </div>
                  <%rank++; %>
                  </c:forEach>
                  
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- End Pricing Page -->
    
    <!-- Start Blog Page -->
    <div class="row">
        <div class="col-md-8 col-sm-8">
            <!-- Accordion -->
            <div class="default-page">
                
            <div class="panel-group" id="accordion">
               
               <c:if test="${count==0}">
               <div class="align-center">등록된 게시물이 없습니다.</div>
               </c:if>
               <c:if test="${count>0}">
                  <c:forEach var="list" items="${list}">
                  <!-- Start Accordion -->
               <div class="panel panel-default">
                  <!-- Toggle Heading -->
                  <div class="panel-heading">
                     <h4 class="panel-title">
                        <a data-toggle="collapse" data-parent="#accordion" href="#collapse-<%=accordianCount%>" class="collapsed">
                           <i class="fa fa-angle-up control-icon"></i>
                            ${list.a_name}
                        </a>
                     </h4>
                  </div>
                  <!-- Toggle Content -->
                  <div id="collapse-<%=accordianCount %>" class="panel-collapse collapse">
                            <div class="panel-body">
                                <table class="type11">
		                            <thead>
		                            <tr>
		                                <th >이름</th>
		                                <th colspan="2">위치</th>
		                                <th >전화번호</th>
		                                <th>소개글</th>
		                                <th >좋아요수</th>
		                            </tr>
		                            </thead>
		                            <tbody class="line_hide">
		                            <tr>
		                                <td><a href="academyDetail.do?a_num=${list.a_num}">${list.a_name}</a></td>
		                                <td colspan="2">${list.a_location}</td>
		                                <td>${list.a_phone}</td>
		                                <td>${list.a_content}</td>
		                                <td>${list.a_good}</td>
		                            </tr>
		                            </tbody>
                        		</table>
                            </div>
                  </div>
               </div>
               <!-- End Accordion -->
               <%accordianCount++; %>
                  </c:forEach>
                  <div style="text-align:center">${pagingHtml}</div>
               </c:if>   
            </div>
            </div>
         <!-- End Accordion -->
         
        </div>
        
        <!--Sidebar-->
      <div class="col-md-4 col-sm-4">
                        
            <div class="sidebar right-sidebar">
                  
            <!-- Search Widget -->
            <div class="widget widget-search">
               <form action="academyMain.do" id="academy_search_form" method="get">
                  <input type="search" placeholder="Enter Keywords..." name = "keyword" id="keyword"/>
                  <button class="search-btn" type="submit"><i class="fa fa-search"></i></button>
               </form>
            </div>

            <!-- Categories Widget -->
            <div class="widget widget-categories">
               <h3 class="section-title">Categories</h3>
               <ul>
                  <li>
                     <a href="#">Brandign</a>
                  </li>
                  <li>
                     <a href="#">Design</a>
                  </li>
                  <li>
                     <a href="#">Development</a>
                  </li>
                  <li>
                     <a href="#">Graphic</a>
                  </li>
               </ul>
            </div>            

         </div>
        </div>
      <!--End sidebar-->
        
        
    </div>
    <!-- End Blog Page -->
    
    
    
    
</div>