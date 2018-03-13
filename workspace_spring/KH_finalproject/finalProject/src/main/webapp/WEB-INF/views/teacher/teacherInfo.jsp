<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
                        <a class="active" href="#">Information</a> <!-- 학원소개/강사진소개 -->
                        <ul class="dropdown">
                        	<li>
                        		<a href="${pageContext.request.contextPath}/academy/academyMain.do">학원 정보</a>
                        	</li>
                        	<li>
                        		<a href="${pageContext.request.contextPath}/teacher/teacherInfo.do">강사진 정보</a>
                        	</li>
                        	<li>
                        		<a href="${pageContext.request.contextPath}/class/classList.do">강의 정보</a>
                        	</li>
                        </ul>
                    </li>
                    <li>
                        <a href="#">Participation Zone</a> <!-- 정보교류게시판/스터디그룹 모집 게시판 -->
                       	<ul class="dropdown">
                        	<li>
                        		<a href="${pageContext.request.contextPath}/board/list.do">정보 교류</a>
                        	</li>
                        	<li>
                        		<a href="${pageContext.request.contextPath}/study/sblist.do">스터디그룹 모집</a>
                        	</li>
                        </ul>
                    </li>
                    <c:if test="${!empty user_id}">
                    <li>
                        <c:if test="${user_group == 1}">
                        <a href="#">My Page</a> <!-- 일반회원(1) : 정보보기/찜목록, 학원회원(2): 학원등록/강사등록 -->
                        
                        <ul class="dropdown">
                        <li>
                       		<a href="${pageContext.request.contextPath}/member/detail.do">내 정보</a>
                       	</li>
                       	<li>
                       		<a href="${pageContext.request.contextPath}/class/myClass.do">내가 찜한 강의</a>
                       	</li>
						<li>
							<a href="${pageContext.request.contextPath}/class/classCompleteList.do">수강 신청 완료 목록</a>
						</li>
                       	</ul>
                        </c:if>
                        <c:if test="${user_group == 2}">
                        <a href="#">My Page</a> <!-- 일반회원(1) : 정보보기/찜목록, 학원회원(2): 학원등록/강사등록 -->
                        <ul class="dropdown">
                        <li>
                       		<a href="${pageContext.request.contextPath}/academy/academyInfo.do">학원 관리</a> <!-- 학원 정보 등록, 수정 -->
                       	</li>
                       	<li>
                       		<a href="${pageContext.request.contextPath}/class/classMain.do">강의 관리</a> <!-- 강의 등록, 수정, 삭제 -->
                       	</li>
                       	<li>
                       		<a href="${pageContext.request.contextPath}/teacher/teacherMain.do">강사 관리</a> <!-- 강사 등록, 수정, 삭제 -->
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
					<h2>Information</h2>
					<div>
                        <ul class="breadcrumb">
                            <li><a href="${pageContext.request.contextPath}/main/main.do">Home</a></li>
                            <li><a href="${pageContext.request.contextPath}/academy/academyMain.do">Academies</a></li>
                            <li><a class="active">Teachers</a>
                        </ul>
                    </div>

				</div>
			</div>
		</div>
	</div>
	<!-- End Breadcrumb Section -->
		
	  <!-- Start Our Team Page --->
	  <c:forEach var="list" items="${listByAnum}" varStatus="i">
    <div class="row">
        <div class="col-md-12">
        
            <div class="team-section" style="margin-bottom:30px;">
                <h3 class="section-title">${list[0].a_name}</h3>

					<div class="our-team" id="engineer-team">
						<c:forEach var="teacher" items="${list}">
							<div class="team-member">
	                        <c:if test="${fn:endsWith(teacher.t_image,'.jpg')|| fn:endsWith(teacher.t_image,'.JPG')||
										  fn:endsWith(teacher.t_image,'.gif')|| fn:endsWith(teacher.t_image,'.GIF')||
										  fn:endsWith(teacher.t_image,'.png')|| fn:endsWith(teacher.t_image,'.PNG')}">
										<!-- TODO 강사 상세보기 만들면 url 바꿔야됨!! -->
	                        	<img src="t_imageView.do?t_num=${teacher.t_num}" class="img-responsive" alt="" style="width:367px;height:244px;"/>
	                        </c:if> 
	                        <c:if test="${empty teacher.t_image}">
	                        	<img src="${pageContext.request.contextPath}/resources/images/no-image.jpg" class="img-responsive" alt="" style="width:367px;height:244px;"/>
	                        </c:if>
	                        <div class="team-details">
	                            <h4>강사 이름 : ${teacher.t_name}</h4>
	                            <p>소속 학원: ${teacher.a_name}</p>
	                            <p>좋아요 수 : ${teacher.t_good}</p>
	                            <button onclick="location.href='${pageContext.request.contextPath}/teacher/teacherInfoDetail.do?t_num=${teacher.t_num}'">상세보기<i class="fa fa-linkedin"></i></button>
	                           <%--  <ul>
	                                <li>
	                                <button onclick="location.href='${pageContext.request.contextPath}/teacher/teacherInfoDetail.do?t_num=${teacher.t_num}'"></button>
	                                <a href="${pageContext.request.contextPath}/teacher/teacherInfoDetail.do?t_num=${teacher.t_num}">
	                                	<i class="fa fa-linkedin"></i>상세보기-${teacher.t_num}
	                                </a>
	                                </li>
	                            <li><a href="${pageContext.request.contextPath}/teacher/teacherInfoDetail.do?t_num=${teacher.t_num}"><i class="fa fa-pinterest"></i></a></li>
	                            </ul> --%>
	                        </div>
	                    </div>
	                    </c:forEach>
					</div>
	                    
		</div>
						
					</div>

				</div>
</c:forEach>
        </div>
    <!-- /.row -->
    <!-- End Our Team Page --->

	        
	        
	<!-- Content UI 끝 -->
	
	</div>
	
	