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
					<h2>Class Information</h2>
					<div>
						<ul class="breadcrumb">
							<li><a href="">Home</a></li>
							<li class="active">Class Information</li>
						</ul>
					</div>

				</div>
			</div>
		</div>
	</div>
	<!-- End Breadcrumb Section -->
	
	<!-- UI시작 -->
	<div class="row">
		<div class="col-md-8 col-sm-i">
			<c:if test="${count==0}">
				<div class="align-center">등록된 게시물이 없습니다.</div>
				</c:if>
				<c:if test="${count>0}">
					<table class="type11">
						<tr style="text-align:center">
							<th style="width:70px;">번호</th>
							<th width="400">이름</th>
							<th colspan="2">내용</th>
							<th>개강일</th>
							<th>종강일</th>
							<th>등록일</th>
						</tr>
						
						<c:forEach var="aclass" items="${command}">
						<tr>
							<td>${aclass.c_num}</td>
							<td><a href="detail.do?num=${aclass.c_name}">${aclass.c_name}</a></td>
							<td colspan="2">${aclass.c_content}</td>
							<td>${aclass.c_start}</td>
							<td>${aclass.c_end}</td>
							<td>${aclass.c_regdate}</td>
						</tr>
						</c:forEach>
					</table>
					<div style="text-align:center">${pagingHtml}</div>
			</c:if>
		</div>
		
		<!--Sidebar-->
		<div class="col-md-4 col-sm-4">
			<div class="sidebar right-sidebar">
	                  
			<!-- Search Widget -->
				<div class="widget widget-search">
					<form action="classMain.do" id="search_form" method="get">
				 		<ul class="search">
							<li>
								<select name="keyfield">
									<option value="t_name">강사이름</option>
								</select>
							</li>
							<li>
								<input type="text" name="keyword" id="keyword">
							</li>
							<li>
								<input type="submit" value="검색">
							</li>
						</ul>
					</form>
	            </div>
	
	            <!-- Categories Widget -->
				<div class="widget widget-categories">
					<h3 class="section-title">Categories</h3>
					<ul>
						<li><a href="#">내가 찜한 강의</a></li>
						<li><a href="${pageContext.request.contextPath}/class/insert.do">강의 등록</a></li>
						<li><a href="${pageContext.request.contextPath}/main/main.do">홈으로</a></li>
					</ul>
				</div>
	        </div>
        </div>
	     <!--End sidebar-->
		
	</div>
</div>