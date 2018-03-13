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
                        <a class="active" href="${pageContext.request.contextPath}/main/main.do">Home</a>
                    </li>
                    <li>
                        <a href="#">Information</a> <!-- 학원소개/강사진소개 -->
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
<!-- Start Main Slider Section -->
    <div class="row">
        <div class="col-md-12">
            <div class="main-slider hidden-sm hidden-xs" id="main-slider">
                
                <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                    <!-- Indicators -->
                    <ol class="carousel-indicators">
                        <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                        <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                    </ol>

                    <!-- Wrapper for slides -->
                    <div class="carousel-inner" role="listbox">
                        <div class="item active">
                            <img src="${pageContext.request.contextPath}/resources/bootstrap/images/slider/slider1.jpeg" class="img-responsive" alt="Slider images 1" style="width:1098px; height:500px;">
                            <div class="carousel-caption">
                                <h1>IoT(사물인터넷)에 대하여</h1>
                                <a href="https://brunch.co.kr/@y-sean/33"><p>여러 전문가는 사물인터넷을 더러 '연결 그 이상'이라든지 '모든 산업의 혁신'이 될 것으로 기대합니다. 이미 2013년 8월에 옥스퍼드 영어 사전에 공식 등재됐고, 관련 기술이 발전하면서 사물인터넷보다 더 큰 개념이라는 만물인터넷(Internet of Everything)이란 말이 등장하기도 했습니다.<br> IoT에 더 자세히 알아보려면 클릭해주세요.</p></a>
                            </div>
                        </div>
                        <div class="item">
                            <img src="${pageContext.request.contextPath}/resources/bootstrap/images/slider/slider2.png" class="img-responsive" alt="Slider images 2" style="width:1098px; height:500px;">
                            <div class="carousel-caption">
                                <h1>추천 공모전</h1>
                                <a href="http://www.detizen.net/contest/?Category=8&Idx=59502"><p>판교 제 2 테크노밸리(제로시티) 스마트시티 서비스 아이디어 공모전<br>
                                	- 판교 제2테크노밸리 (제로시티) 스마트시티 구현을 위한 서비스 아이디어<br>
										 ㆍ인공지능(AI), IoT, 드론, 가상 및 증강현실, 빅데이터, 로봇 등의 요소기술을 활용하여 
										     스마트시티 구현을 위한 신규 서비스 아이디어 개발<br>
									- 기간 및 일정<br>
										ㆍ 접수기간 : 2018.2.7(수) ~ 3.18(일) <br>
									- 상세 내용을 원하시면 클릭해주세요.
                                </p></a>
                            </div>
                        </div>
                    </div>

                    <!-- Controls -->
                    <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
                        <i class="fa fa-angle-left"></i>
                        <span class="sr-only">Previous</span>
                    </a>
                    <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
                        <i class="fa fa-angle-right" aria-hidden="true"></i>
                        <span class="sr-only">Next</span>
                    </a>
                </div>
                
            </div>
        </div>
    </div>
    <!-- Start Featured Project Section First -->
    <div class="row">
        <div class="col-md-12 col-sm-12">
            <div class="project-section">
                <h3 class="section-title">학원 랭크</h3>
                <!-- Start Portfolio items -->
                    <ul id="portfolio-list" data-animated="fadeIn">
                    	<c:forEach var="topItem" items="${academyTopList}">	
                        <li>
                        	<div class="portfolio-item">
                            	<c:if test="${fn:endsWith(topItem.a_logo,'.jpg')|| fn:endsWith(topItem.a_logo,'.JPG')||
											  fn:endsWith(topItem.a_logo,'.gif')|| fn:endsWith(topItem.a_logo,'.GIF')||
											  fn:endsWith(topItem.a_logo,'.png')|| fn:endsWith(topItem.a_logo,'.PNG')}">
                                <img src="imageView.do?a_num=${topItem.a_num}" class="img-responsive" alt="" style="width:367px;height:244px;"/>
                                </c:if>
                                <c:if test="${empty topItem.a_logo}">
                                <img src="${pageContext.request.contextPath}/resources/images/no-image.jpg" class="img-responsive" alt="" style="width:367px;height:244px;"/>
                                </c:if>
                                <div class="figure-caption">
                                    <h4>${topItem.a_name}</h4>
                                    <p>
                                    	<i class="fa fa-globe"></i>${topItem.a_location}<br/>
                                    	<i class="fa fa-mobile"></i>${topItem.a_phone}<br/>
                                    	<i class="fa fa-thumbs-up"></i>${topItem.a_good}
                                    </p>
                                    <a href="../academy/academyDetail.do?a_num=${topItem.a_num}">상세보기</a>
                                </div>			
                            </div>
                        </li>  
                        </c:forEach>                     
                    </ul>
                    <!-- End Portfolio items -->
            </div>
        </div>
    </div>
    <!-- End Featured Project Section First -->
    
    <!-- Start Featured Project Section Second -->
    <div class="row">
        <div class="col-md-12">
            <div class="project-section">
                <h3 class="section-title">강사 랭크</h3>
                <!-- Start Portfolio items -->
                    <ul id="portfolio-list" data-animated="fadeIn">
                        <c:forEach var="topItem" items="${teacherTopList}">	
                        <li>
                        	<div class="portfolio-item">
                            	<c:if test="${fn:endsWith(topItem.t_image,'.jpg')|| fn:endsWith(topItem.t_image,'.JPG')||
											  fn:endsWith(topItem.t_image,'.gif')|| fn:endsWith(topItem.t_image,'.GIF')||
											  fn:endsWith(topItem.t_image,'.png')|| fn:endsWith(topItem.t_image,'.PNG')}">
								<!-- TODO 강사 상세보기 만들면 url 바꿔야됨!! -->
                                <img src="t_imageView.do?t_num=${topItem.t_num}" class="img-responsive" alt="" style="width:367px;height:244px;"/>
                                </c:if>
                                <c:if test="${empty topItem.t_image}">
                                <img src="${pageContext.request.contextPath}/resources/images/no-image.jpg" class="img-responsive" alt="" style="width:367px;height:244px;"/>
                                </c:if>
                                <div class="figure-caption">
                                    <h4>이  름 : ${topItem.t_name}</h4>
                                    <p>
                                    	<i class="fas fa-clipboard"></i>소속 학원 : ${topItem.a_name}<br/>
                                    	<i class="fa fa-thumbs-up"></i>좋아요 수 : ${topItem.t_good}
                                    </p>
                                    <!-- TODO 강사 상세보기 만들면 path 바꿔야됨!! -->
                                    <a href="../teacher/teacherInfoDetail.do?t_num=${topItem.t_num}">상세보기</a>
                                </div>			
                            </div>
                        </li>  
                        </c:forEach>                        
                    </ul>
                    <!-- End Portfolio items -->
            </div>
        </div>
    </div>
    <!-- End Featured Project Section Second -->
    <!-- End Main Slider Section -->
</div>


