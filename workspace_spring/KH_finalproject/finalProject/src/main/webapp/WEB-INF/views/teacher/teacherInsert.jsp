<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/confirmId.js"></script>
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
                        		<a href="${pageContext.request.contextPath}/stydt/sblist.do">스터디그룹 모집</a>
                        	</li>
                        </ul>
                    </li>
                    <c:if test="${!empty user_id}">
                    <li>
                        <c:if test="${user_group == 1}">
                        <a class="active" href="#">My Page</a> <!-- 일반회원(1) : 정보보기/찜목록, 학원회원(2): 학원등록/강사등록 -->
                        
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
                        <a class="active" href="#">My Page</a> <!-- 일반회원(1) : 정보보기/찜목록, 학원회원(2): 학원등록/강사등록 -->
                        <ul class="dropdown">
                        <li>
                       		<a href="${pageContext.request.contextPath}/academy/academyInfo.do">학원 관리</a> <!-- 학원 정보 등록, 수정 -->
                       	</li>
                       	<li>
                       		<a href="${pageContext.request.contextPath}/class/classMain.do">강의관리</a> <!-- 강의 등록, 수정, 삭제 -->
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
    
    <div class="col-md-12">
   <div class="form-test">
   
      <div class="form-area">
      <div class="contact-section" >
         <form:form commandName="teacher" action="insert.do" id="cform"
            class="contactForm" name="cform" enctype="multipart/form-data">
            <form:errors element="div" cssClass="error-color" />
            <br style="clear: both">
            <h3 style="margin-bottom: 25px; text-align: center;">Contact
               Form</h3>
               <form:hidden path="a_num"/>
               <form:hidden path="m_id"/>
                
            <div class="form-group">
               <label for="t_name">강사 이름<span class="required">* <form:errors path="t_name" cssClass="error-color"/></span></label>
               <form:input path="t_name" class="form-control"/>
            </div>
            
            <div class="form-group">
            <label for="t_content">강사 소개<span class="required">* <form:errors path="t_content" cssClass="error-color"/></span></label>
               <form:textarea path="t_content" class="form-control" placeholder="Message" rows="7"/>
            </div>
            
            <div class="form-group">
            <label for="t_record">강사 이력</label>
               <form:textarea path="t_record" class="form-control" placeholder="Message" maxlength="140" rows="7"/>
            </div>
            
            <div class="form-group">
            <label for="t_preview">미리 보기</label>
               <form:textarea path="t_preview" class="form-control" placeholder="Message" maxlength="140" rows="7"/>
            </div>
            
            <div class="form-group">
               <label for="upload">강사 이미지</label>
               <input type="file" name="upload"/>
            </div>
            
            <input type="submit" name="submit" class="btn btn-primary" id="submit_btn" value="전송">


         </form:form>
         </div>
      </div>
      </div>
      
   </div>
</div>