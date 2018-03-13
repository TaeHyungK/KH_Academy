<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
                        <a href="#">My Page</a> <!-- 일반회원(1) : 정보보기/찜목록, 학원회원(2): 학원등록/강사등록 -->
                        
                        <c:if test="${user_group == 1}">
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
                            <li class="active">Academies</li>
                            <li><a href="${pageContext.request.contextPath}/academy/teacherMain.do">Teachers</a>
                        </ul>
                    </div>

				</div>
			</div>
		</div>
	</div>
	
	<!-- Search Widget -->
    <div class="widget widget-search">
       <form action="classList.do" id="teacher_search_form" method="get">
       	  <ul class="search">
       	  	<li>
       	  		<select name="keyfield">
       	  			<option value="c_name">강의 이름</option>
       	  			<option value="t_name">강사 이름</option>
       	  			<option value="c_category">카테고리</option>
       	  			<option value="c_content">내용</option>
       	  		</select>
       	  	</li>
       	  </ul>
       	  <br>
          <input type="search" placeholder="Enter Keyword..." name = "keyword" id="keyword"/>
          <button class="search-btn" type="submit"><i class="fa fa-search"></i></button>
       </form>
    </div>
	
	<div class="row">
	<form:form commandName="command" action="classGet.do" id="cform"
				class="contactForm" name="cform">
				<form:errors element="div" cssClass="error-color" />
	<c:if test="${count==0}"> 
		<div style="text-align:center">등록된 게시물이 없습니다.</div>
	</c:if>
	<c:if test="${count>0}">
		<div class="blog-section">
		<c:forEach var="command" items="${command}">
			<div class="blog-post standard-post">
				<!-- Post Content -->
				<div class="post-content">
					<div class="post-type">
						<c:if test="${fn:endsWith(command.a_logo,'.jpg')|| fn:endsWith(command.a_logo,'.JPG')||
									  fn:endsWith(command.a_logo,'.gif')|| fn:endsWith(command.a_logo,'.GIF')||
									  fn:endsWith(command.a_logo,'.png')|| fn:endsWith(command.a_logo,'.PNG')}">
						<img src="${pageContext.request.contextPath}/main/imageView.do?a_num=${command.a_num}" class="img-responsive" alt="" style="height:36px;"/>
						</c:if>
						<c:if test="${empty command.a_logo}">
						<img src="${pageContext.request.contextPath}/resources/images/no-image.jpg" class="img-responsive" alt="" style="height:36px;"/>
						</c:if>
                                
					</div>
				<h1>${command.c_name}</h1>
				<input type=hidden name="c_num" value="${command.c_num}" >
				<input type=hidden name="m_num" value="${user_num}">
				<ul class="post-meta">
					<li><i class="fas fa-tags"></i>카테고리${command.c_category}</li>
					<li><i class="fas fa-users"></i>
						인원${command.c_count}/${command.c_max_count}</li>

					<li><i class="fa fa-user"></i> 강사이름 ${command.t_name}</li>
					<li><i class="far fa-calendar-alt"></i> 개강/종강
						${command.c_start} ~ ${command.c_end}</li>
					<li><i class="fas fa-dollar-sign"></i>수강료
						<fmt:formatNumber value="${command.c_tuition}" pattern="#,###원"></fmt:formatNumber>
					</li>
				</ul>
				<hr>
				<p>${command.c_content}</p>
				<input type="button" class="btn btn-primary" id="submit_btn" onclick="location.href='${pageContext.request.contextPath}/class/classGet.do?c_num=${command.c_num}&m_num=${user_num}'" value="찜하기">
				<!-- <input type="submit" name="submit" class="btn btn-primary" id="submit_btn" value="찜하기"> -->
				</div>
			</div>
		</c:forEach>
				<div style="text-align:center">${pagingHtml}</div>
		</div>

	</c:if>
	</form:form>
	</div>
</div>