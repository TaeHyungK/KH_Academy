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
                        <a class="active" href="${pageContext.request.contextPath}/main/main.do">Home</a>
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
                        <a href="#">내 정보 관리</a> <!-- 일반회원(1) : 정보보기/찜목록, 학원회원(2): 학원등록/강사등록 -->
                        
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
                        <a href="${pageContext.request.contextPath}/academy/academyInfo.do">내 정보 관리</a> <!-- 일반회원(1) : 정보보기/찜목록, 학원회원(2): 학원등록/강사등록 -->
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
                            <img src="${pageContext.request.contextPath}/resources/bootstrap/images/slider/sl1.jpg" class="img-responsive" alt="Slider images 1">
                            <div class="carousel-caption">
                                <h1>This is Slider Caption 1</h1>
                                <p>Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Lorem ipsum dolor. reprehenderit. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Lorem ipsum dolor. reprehenderit</p>
                            </div>
                        </div>
                        <div class="item">
                            <img src="${pageContext.request.contextPath}/resources/bootstrap/images/slider/sl2.jpg" class="img-responsive" alt="Slider images 2">
                            <div class="carousel-caption">
                                <h1>This is Slider Caption 2</h1>
                                <p>Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Lorem ipsum dolor. reprehenderit. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Lorem ipsum dolor. reprehenderit</p>
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
        <div class="col-md-12">
            <div class="project-section">
                <h3 class="section-title">Our Featured Project</h3>
                <!-- Start Portfolio items -->
                    <ul id="portfolio-list" data-animated="fadeIn">
                        <li>
                            <div class="portfolio-item">
                                <img src="${pageContext.request.contextPath}/resources/bootstrap/images/building/project-5.jpg" class="img-responsive" alt=""/>
                                <div class="figure-caption">
                                    <h4>Project No. 1</h4>
                                    <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium totam rem aperiam voluptatem accusantium.</p>
                                    <a href="#">View Details</a>
                                </div>			
                            </div>

                        </li>
                        
                        <li>
                            <div class="portfolio-item">
                                <img src="${pageContext.request.contextPath}/resources/bootstrap/images/building/project-2.jpg" class="img-responsive" alt=""/>
                                <div class="figure-caption">
                                    <h4>Project No. 3</h4>
                                    <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium totam rem aperiam voluptatem accusantium.</p>
                                    <a href="#">View Details</a>
                                </div>			
                            </div>

                        </li>
                        <li>
                            <div class="portfolio-item">
                                <img src="${pageContext.request.contextPath}/resources/bootstrap/images/building/project-3.jpg" class="img-responsive" alt=""/>
                                <div class="figure-caption">
                                    <h4>Project No. 4</h4>
                                    <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium totam rem aperiam voluptatem accusantium.</p>
                                    <a href="#">View Details</a>
                                </div>			
                            </div>

                        </li>
                        <li>
                            <div class="portfolio-item">
                                <img src="${pageContext.request.contextPath}/resources/bootstrap/images/building/project-7.jpg" class="img-responsive" alt=""/>
                                <div class="figure-caption">
                                    <h4>Project No. 5</h4>
                                    <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium totam rem aperiam voluptatem accusantium.</p>
                                    <a href="#">View Details</a>
                                </div>			
                            </div>

                        </li>
                        <li>
                            <div class="portfolio-item">
                                <img src="${pageContext.request.contextPath}/resources/bootstrap/images/building/project-6.jpg" class="img-responsive" alt=""/>
                                <div class="figure-caption">
                                    <h4>Project No. 6</h4>
                                    <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium totam rem aperiam voluptatem accusantium.</p>
                                    <a href="#">View Details</a>
                                </div>			
                            </div>

                        </li>
                        <li>
                            <div class="portfolio-item">
                                <img src="${pageContext.request.contextPath}/resources/bootstrap/images/building/project-8.jpg" class="img-responsive" alt=""/>
                                <div class="figure-caption">
                                    <h4>Project No. 7</h4>
                                    <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium totam rem aperiam voluptatem accusantium.</p>
                                    <a href="#">View Details</a>
                                </div>			
                            </div>

                        </li>
                       
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
                <h3 class="section-title">Our Featured Project</h3>
                <!-- Start Portfolio items -->
                    <ul id="portfolio-list" data-animated="fadeIn">
                        <li>
                            <div class="portfolio-item">
                                <img src="${pageContext.request.contextPath}/resources/bootstrap/images/building/project-5.jpg" class="img-responsive" alt=""/>
                                <div class="figure-caption">
                                    <h4>Project No. 1</h4>
                                    <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium totam rem aperiam voluptatem accusantium.</p>
                                    <a href="#">View Details</a>
                                </div>			
                            </div>

                        </li>
                        
                        <li>
                            <div class="portfolio-item">
                                <img src="${pageContext.request.contextPath}/resources/bootstrap/images/building/project-2.jpg" class="img-responsive" alt=""/>
                                <div class="figure-caption">
                                    <h4>Project No. 3</h4>
                                    <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium totam rem aperiam voluptatem accusantium.</p>
                                    <a href="#">View Details</a>
                                </div>			
                            </div>

                        </li>
                        <li>
                            <div class="portfolio-item">
                                <img src="${pageContext.request.contextPath}/resources/bootstrap/images/building/project-3.jpg" class="img-responsive" alt=""/>
                                <div class="figure-caption">
                                    <h4>Project No. 4</h4>
                                    <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium totam rem aperiam voluptatem accusantium.</p>
                                    <a href="#">View Details</a>
                                </div>			
                            </div>

                        </li>
                        <li>
                            <div class="portfolio-item">
                                <img src="${pageContext.request.contextPath}/resources/bootstrap/images/building/project-7.jpg" class="img-responsive" alt=""/>
                                <div class="figure-caption">
                                    <h4>Project No. 5</h4>
                                    <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium totam rem aperiam voluptatem accusantium.</p>
                                    <a href="#">View Details</a>
                                </div>			
                            </div>

                        </li>
                        <li>
                            <div class="portfolio-item">
                                <img src="${pageContext.request.contextPath}/resources/bootstrap/images/building/project-6.jpg" class="img-responsive" alt=""/>
                                <div class="figure-caption">
                                    <h4>Project No. 6</h4>
                                    <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium totam rem aperiam voluptatem accusantium.</p>
                                    <a href="#">View Details</a>
                                </div>			
                            </div>

                        </li>
                        <li>
                            <div class="portfolio-item">
                                <img src="${pageContext.request.contextPath}/resources/bootstrap/images/building/project-8.jpg" class="img-responsive" alt=""/>
                                <div class="figure-caption">
                                    <h4>Project No. 7</h4>
                                    <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium totam rem aperiam voluptatem accusantium.</p>
                                    <a href="#">View Details</a>
                                </div>			
                            </div>

                        </li>
                       
                    </ul>
                    <!-- End Portfolio items -->
            </div>
        </div>
    </div>
    <!-- End Featured Project Section Second -->
    <!-- End Main Slider Section -->
</div>
