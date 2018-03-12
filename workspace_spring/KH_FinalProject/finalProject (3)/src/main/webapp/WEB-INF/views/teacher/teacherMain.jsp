<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
                        <a href="#">소개</a> <!-- 학원소개/강사진소개 -->
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
                        <a href="#">게시판</a> <!-- 정보교류게시판/스터디그룹 모집 게시판 -->
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
                        <c:if test="${user_group == 1}">
                        <a class="active" href="#">내 정보 관리</a> <!-- 일반회원(1) : 정보보기/찜목록, 학원회원(2): 학원등록/강사등록 -->
                        
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
                        <a class="active" href="#">내 정보 관리</a> <!-- 일반회원(1) : 정보보기/찜목록, 학원회원(2): 학원등록/강사등록 -->
                        <ul class="dropdown">
	                        <li>
	                       		<a href="${pageContext.request.contextPath}/academy/academyInfo.do">학원 정보 보기</a> <!-- 학원 정보 등록, 수정 -->
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
	<!-- End Breadcrumb Section -->
	
	<!-- Content UI 시작 -->
	<div class="row">
		<div class="sidebar right-sidebar">
			<div class="col-md-8 col-sm-i table-responsive line-hide">
				<c:if test="${count==0}">
					<div class="align-center">등록된 게시물이 없습니다.</div>
				</c:if>
				<c:if test="${count>0}">
					<table class="type11">
						<tr>
							<th style="width:70px;">번호</th>
							<th>이름</th>
							<th style="width:170px;">내용</th>
							<th>이력</th>
							<th>미리보기</th>
							<th>수정/삭제</th>
						</tr>
			 
						<c:forEach var="teacher" items="${list}">
						<tr> 
							<td>${teacher.t_num}<input type="hidden" name="a_num" value="${teacher.a_num}"></td>
							<td><a href="detail.do?num=${teacher.t_name}">${teacher.t_name}</a></td>
							<td>${teacher.t_content}</td>
							<td>${teacher.t_record}</td>
							<td>${teacher.t_preview}</td>
							<td><input type="button" value="수정"
							class="btn btn-primary"
							onclick="location.href='${pageContext.request.contextPath}/teacher/updateTeacher.do?t_num=${teacher.t_num}&a_num=${teacher.a_num}'">
							<input type="button" value="삭제"
							class="btn btn-primary" 
							onclick="location.href='${pageContext.request.contextPath}/teacher/deleteTeacher.do?t_num=${teacher.t_num}&a_num=${teacher.a_num}'">
							</td>
						</tr>
						</c:forEach>
					</table>
					
					<div style="text-align:center">${pagingHtml}</div>
				</c:if>
				</div>
				
				
			<!--Sidebar-->
			<div class="col-md-4 col-sm-4">
				<!-- Search Widget -->
	            <div class="widget widget-search">
	               <form action="teacherMain.do" id="teacher_search_form" method="get">
	                  <input type="search" placeholder="Enter Teacher Name..." name = "keyword" id="keyword"/>
	                  <button class="search-btn" type="submit"><i class="fa fa-search"></i></button>
	               </form>
	            </div>
	            	
	            <!-- Categories Widget -->
				<div class="widget widget-categories">
					<h3 class="section-title">Categories</h3>
					<ul>
						<li><a href="${pageContext.request.contextPath}/class/myClass.do">내가 찜한 강의</a></li>
						<li><a
							href="${pageContext.request.contextPath}/teacher/insert.do">강사 등록</a></li>
						<li><a href="${pageContext.request.contextPath}/main/main.do">홈으로</a></li>
					</ul>
				</div>
	        </div>
	        <!--End sidebar-->
 
        </div>
	</div>
</div>     
	        
	        
	<!-- Content UI 끝 -->
	
	
	
	