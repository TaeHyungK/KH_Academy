<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
	<!-- Start Header Section -->
    <div class="header-section">
        <div class="row">
            <div class="col-md-5 col-sm-5">
                <div class="logo-img">
                    <a href="${pageContext.request.contextPath}/main/main.do"><img src="${pageContext.request.contextPath}/resources/bootstrap/images/logo.png" class="img-responsive" alt=""></a>
                </div>
            </div>
            <div class="col-md-7 col-sm-7">
                <div class="top-info">
                    <ul class="top-social">
                        <li><a href="#" class="facebook"><i class="fa fa-facebook"></i></a></li>
                        <li><a href="#" class="twitter"><i class="fa fa-twitter"></i></a></li>
                        <li><a href="#" class="linkedin"><i class="fa fa-linkedin"></i></a></li>
                        <li><a href="#" class="flickr"><i class="fa fa-flickr"></i></a></li>
                        <li><a href="#" class="google-plus"><i class="fa fa-google-plus"></i></a></li>
                    </ul>
                    <div class="top-phone clearfix">
                    	<c:if test="${empty user_id }">
							<button type="button" class="btn" onclick="location.href='${pageContext.request.contextPath}/member/write.do'">회원가입</button>
							<button type="button" class="btn" onclick="location.href='${pageContext.request.contextPath}/member/login.do'">로그인</button>
						</c:if>
						<c:if test="${!empty user_id }">
							${user_id} 님 로그인 중
							<button type="button" class="btn" onclick="location.href='${pageContext.request.contextPath}/member/detail.do'">회원정보</button>
							<button type="button" class="btn" onclick="location.href='${pageContext.request.contextPath}/member/logout.do'">로그아웃</button>
						</c:if>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- End Header Section -->
    
    
</div>