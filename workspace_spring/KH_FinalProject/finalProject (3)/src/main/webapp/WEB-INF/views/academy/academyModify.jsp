<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/confirmId.js"></script>

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
	
	<div class="col-md-12">
	<div class="form-test">
	
		<div class="form-area">
		<div class="contact-section" >
			<form:form commandName="command" action="modify.do" id="cform"
				class="contactForm" name="cform">
				<form:errors element="div" cssClass="error-color" />
				<br style="clear: both">
				<h3 style="margin-bottom: 25px; text-align: center;">Contact
					Form</h3>
					<form:hidden path="a_num"/>
					<form:hidden path="m_id"/>
					<form:hidden path="m_num"/>
					 
				<div class="form-group">
					<label for="a_name">학원 이름<span class="required">*</span></label>
					<form:input path="a_name" class="form-control"/>
				</div>
				<div class="form-group">
					<label for="a_location">학원 위치<span class="required">*</span></label>
					<form:input path="a_location" class="form-control"/>
				</div>
				<div class="form-group">
				<label for="cp_num">학원 소개</label>
					<form:textarea path="a_content" class="form-control" placeholder="Message" maxlength="140" rows="7"/>
				</div>
				
				<div class="form-group">
					<label for="a_phone">전화 번호</label>
					<form:input path="a_phone" class="form-control"/>
				</div>
				
				<div class="form-group">
					<label for="a_phone">전화 번호</label>
					<form:input path="a_phone" class="form-control"/>
				</div>
				
				<div class="form-group">
					<label for="upload">회사 로고</label>
					<input type="file" name="upload"/>
					<c:if test="${!empty command.a_logo}">
						<br>
						<span>(${command.a_logo})파일이 등록되어 있습니다. 다시 업로드하면 기존 파일은
							삭제됩니다.</span>
					</c:if>
				</div>
								
				<input type="submit" name="submit" class="btn btn-primary" id="submit_btn" value="전송">


			</form:form>
			</div>
		</div>
		</div>
		
	</div>
</div>
