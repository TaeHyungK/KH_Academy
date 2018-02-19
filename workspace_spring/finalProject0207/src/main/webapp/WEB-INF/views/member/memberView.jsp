<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                        <a href="${pageContext.request.contextPath}/academy/academyMain.do">소개</a> <!-- 학원소개/강사진소개 -->
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
                        <a class="active" href="#">내 정보 관리</a> <!-- 일반회원(1) : 정보보기/찜목록, 학원회원(2): 학원등록/강사등록 -->
                        
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
                       		<a href="${pageContext.request.contextPath}/academy/academyMain.do">학원 정보 보기</a> <!-- 학원 정보 등록, 수정 -->
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
						<h2>Contact</h2>
						<div>
							<ul class="breadcrumb">
								<li><a href="#">Home</a></li>
								<li class="active">Contact</li>
							</ul>
						</div>

					</div>
				</div>
			</div>
		</div>
		<!-- End Breadcrumb Section -->

		<!-- Start Contact Section -->
		<div class="row">
			<div class="sidebar right-sidebar">
		 <div class="col-md-8">
            <div class="contact-section">
				
				<h3 class="section-title">회원정보</h3>
				
				<!-- Info - Icons List -->
				<ul class="icons-list">
					<li><i class="fa fa-user"></i> <strong>ID:</strong> ${member.m_id}</li>
					<li><i class="fa fa-tag"></i> <strong>이름:</strong>${member.m_name}</li>
					<li><i class="fa fa-phone"></i> <strong>Phone:</strong>${member.m_phone}</li>
					<li><i class="fa fa-envelope-o"></i> <strong>이메일:</strong>${member.m_email}</li>
					<li><i class="fa fa-map-marker"></i><strong>주소:</strong>${member.m_address}</li>
					<li><i class="fa fa-calendar"></i> <strong>가입일:</strong>${member.m_regdate}</li>
					
				</ul>
				
			</div>
        </div>
				<div class="col-md-4">
					
					<!-- Categories Widget -->
					<div class="widget widget-categories">
						<h3 class="section-title">Categories</h3>
						<ul>
							<li><a href="#">내가 찜한 강의</a></li>
							<li><a href="${pageContext.request.contextPath}/member/modify.do">회원 정보 수정</a></li>
							<li><a href="${pageContext.request.contextPath}/member/delete.do">회원 탈퇴</a></li>
							<li><a href="${pageContext.request.contextPath}/main/main.do">홈으로</a></li>
						</ul>
					</div>

				</div>

			</div>
		</div>
		<!-- End Contact Section -->



	</div>
	<!-- /.container -->

	<a href="#" class="back-to-top"><i class="fa fa-angle-up"></i></a>
