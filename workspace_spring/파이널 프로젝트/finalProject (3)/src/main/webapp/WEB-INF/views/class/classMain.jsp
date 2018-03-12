<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                        <a class="active" href="#">내 정보 관리</a> <!-- 일반회원(1) : 정보보기/찜목록, 학원회원(2): 학원등록/강사등록 -->
                        
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
	
	<!-- Content UI시작 -->
	<div class="row">
		<div class="sidebar right-sidebar">
			<div class="col-md-8 col-sm-i table-responsive line-hide">
			
				<c:if test="${count==0}">
					<div class="align-center">등록된 게시물이 없습니다.</div>
					</c:if>
				<c:if test="${count>0}">
				<div class="blog-section">
					<c:forEach var="aclass" items="${command}">
					<div class="blog-post standard-post">
						<div class="post-content">
							<div class="post-type">
								<c:if test="${fn:endsWith(aclass.a_logo,'.jpg')|| fn:endsWith(aclass.a_logo,'.JPG')||
									  		  fn:endsWith(aclass.a_logo,'.gif')|| fn:endsWith(aclass.a_logo,'.GIF')||
									  		  fn:endsWith(aclass.a_logo,'.png')|| fn:endsWith(aclass.a_logo,'.PNG')}">
								<img src="${pageContext.request.contextPath}/main/imageView.do?a_num=${aclass.a_num}" class="img-responsive" alt="" style="height:36px;"/>
								</c:if>
								<c:if test="${empty aclass.a_logo}">
								<img src="${pageContext.request.contextPath}/resources/images/no-image.jpg" class="img-responsive" alt="" style="height:36px;"/>
								</c:if>
							</div>
							<h1>${aclass.c_name}</h1>
							<input type="hidden" name="c_num" value="${aclass.c_num}">
							<input type="hidden" name="m_num" value="${user_num}">
							<ul class="post-meta" style="list-style:circle;">
								<li ><i class="fas fa-tags"></i>카테고리${aclass.c_category}</li>
								<li><i class="fas fa-users"></i>
									인원${aclass.c_count}/${aclass.c_max_count}</li>
								
								<li><i class="fa fa-user"></i> 강사이름 ${aclass.t_name}</li>
								<li><i class="far fa-calendar-alt"></i> 개강/종강
									${aclass.c_start} ~ ${aclass.c_end}</li>
								<li><i class="fas fa-dollar-sign"></i>수강료
									${aclass.c_tuition}</li>
								<li>
								<input type="button" value="수정"
							class="btn btn-primary"
							onclick="location.href='${pageContext.request.contextPath}/class/updateClass.do?c_num=${aclass.c_num}&a_num=${aclass.a_num}'">
								</li>	
								<li>
								<input type="button" value="삭제" class="btn btn-primary" onclick="location.href='${pageContext.request.contextPath}/class/deleteClass.do?c_num=${aclass.c_num}&a_num=${aclass.a_num}'">
							</li>
							</ul>
							<hr>
							<p>${aclass.c_content}</p>
						</div>
					</div>
					</c:forEach>
				</div>
				
					<div style="text-align:center">${pagingHtml}</div>
				</c:if>
			</div>
			
			<!--Sidebar-->
			<div class="col-md-4 col-sm-4">
				<!-- Search Widget -->
	            <div class="widget widget-search">
	               <form action="classMain.do" id="class_search_form" method="get">
	                  <input type="search" placeholder="Enter Class Name..." name = "keyword" id="keyword"/>
	                  <button class="search-btn" type="submit"><i class="fa fa-search"></i></button>
	               </form>
	            </div>
	
	            <!-- Categories Widget -->
				<div class="widget widget-categories">
					<h3 class="section-title">Categories</h3>
					<ul>
						<li><a href="${pageContext.request.contextPath}/class/myClass.do">내가 찜한 강의</a></li>
						<li><a href="${pageContext.request.contextPath}/class/insert.do">강의 등록</a></li>
						<li><a href="${pageContext.request.contextPath}/main/main.do">홈으로</a></li>
					</ul>
				</div>
	        </div>
        </div>
	     <!--End sidebar-->
	</div>
</div>