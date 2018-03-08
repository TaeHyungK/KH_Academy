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
                        		<a href="${pageContext.request.contextPath}/board/list.do">정보 교류 게시판</a>
                        	</li>
                        	<li>
                        		<a href="#">스터디그룹 모집 게시판</a>
                        	</li>
                        </ul>
                    </li>
                    <c:if test="${!empty user_id}">
                    <li>
                        <c:if test="${user_group == 1}">
                        <a class="active" href="#">내 정보 관리</a> <!-- 일반회원(1) : 정보보기/찜목록, 학원회원(2): 학원등록/강사등록 -->
                        
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
                        <a class="active" href="${pageContext.request.contextPath}/academy/academyInfo.do">내 정보 관리</a> <!-- 일반회원(1) : 정보보기/찜목록, 학원회원(2): 학원등록/강사등록 -->
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
	<form action="teacherMain.do" id="search_form" method="get">
		<ul class="search">
			<li><select name="keyfield">
					<option value="t_name">강사이름</option>
			</select></li>
			<li><input type="text" name="keyword" id="keyword"></li>
			<li><input type="submit" value="검색"></li>
		</ul>
	</form>
	<div class="align-right">
		<c:if test="${!empty user_id}">
			<input type="button" value="글쓰기" onclick="location.href='write.do'">
		</c:if>
		<c:if test="${empty user_id}">
			<input type="button" value="글쓰기" onclick="location.href='write.do'"
				disabled>
		</c:if>
	</div>
	<c:if test="${count==0}">
		<div class="align-center">등록된 게시물이 없습니다.</div>
	</c:if>
	<c:if test="${count>0}">
		<table>
			<tr>
				<th>번호</th>
				<th width="400">이름</th>
				<th>내용</th>
				<th>이력</th>
				<th>미리보기</th>
			</tr>

			<c:forEach var="teacher" items="${list}">
				<tr>
					<td>${teacher.t_num}</td>
					<td><a href="detail.do?num=${teacher.t_name}">${teacher.t_name}</a></td>
					<td>${teacher.t_content}</td>
					<td>${teacher.t_record}</td>
					<td>${teacher.t_preview}</td>
				</tr>
			</c:forEach>
		</table>
		<div class="align-center">${pagingHtml}</div>
	</c:if>
	<div class="row">
		<div class="col-md-4">

			<!-- Categories Widget -->
			<div class="widget widget-categories">
				<h3 class="section-title">Categories</h3>
				<ul>
					<li><a href="#">내가 찜한 강의</a></li>
					<li><a
						href="${pageContext.request.contextPath}/teacher/insert.do">강사
							등록</a></li>
					<li><a href="${pageContext.request.contextPath}/main/main.do">홈으로</a></li>
				</ul>
			</div>

		</div>
	</div>
	<!-- End Pricing Page -->
	<div class="single-blog-post">
		<h3>Girls Pink T Shirt arrived in store</h3>
		<div class="post-meta">
			<ul>
				<li><i class="fa fa-user"></i> Mac Doe</li>
				<li><i class="fa fa-clock-o"></i> 1:33 pm</li>
				<li><i class="fa fa-calendar"></i> DEC 5, 2013</li>
			</ul>
			<span> <i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
				class="fa fa-star"></i> <i class="fa fa-star"></i> <i
				class="fa fa-star-half-o"></i>
			</span>
		</div>
		<a href=""> <img src="images/blog/blog-one.jpg" alt="">
		</a>
		<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed
			do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut
			enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi
			ut aliquip ex ea commodo consequat. Duis aute irure dolor in
			reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla
			pariatur.</p>
		<a class="btn btn-primary" href="">Read More</a>
	</div>



</div>