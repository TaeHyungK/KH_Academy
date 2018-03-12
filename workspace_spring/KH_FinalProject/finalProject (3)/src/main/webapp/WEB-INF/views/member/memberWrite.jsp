<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/confirm_Id.js"></script>

<div class="container">
   <!-- Start Navigation Section -->
    <div class="navigation">
        
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
                              <a href="${pageContext.request.contextPath}/teacher/teacherInfo.do">강사진 소개</a>
                           </li>
                           <li>
                              <a href="${pageContext.request.contextPath}/class/classList.do">강의 소개</a>
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
                              <a href="${pageContext.request.contextPath}/study/sblist.do">스터디그룹 모집 게시판</a>
                           </li>
                        </ul>
                    </li>
                    <c:if test="${!empty user_id}">
                    <li>
                        <c:if test="${user_group == 1}">
                        <a class="active" href="${pageContext.request.contextPath}/member/detail.do">내 정보 관리</a> <!-- 일반회원(1) : 정보보기/찜목록, 학원회원(2): 학원등록/강사등록 -->
                        
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
    
   <div class="row">
                <div class="col-md-12">
         <div class="contact-section">
            <h3 class="section-title">Contact with Us</h3>
            <!-- Start Contact Form -->
            <div id="contact-form" class="contatct-form">
               <div class="loader"></div>

               <form:form commandName="command" action="write.do" id="cform"
                  class="contactForm" name="cform">
                  <form:errors element="div" cssClass="error-color" />
                  <div class="row">
                  	<div class="col-md-6 col-md-offset-4">
                  	<label for="m_group">회원 구분<span class="required">* <form:errors path="m_group" cssClass="error-color"/></span></label>
                     	<input type="radio" name="m_group" value="1" checked>일반 회원
                     	<input type="radio" name="m_group" value="2">학원 관리자
                     </div>
                  	<div class="col-md-6 col-md-offset-4">
                        <label for="m_id">아이디<span class="required">* <form:errors path="m_id" cssClass="error-color"/></span></label>
                         <input type="button" id="confirmId" value="ID중복체크">
                         <form:input path="m_id"/>
						<span id="message_id"></span>
						<img src="${pageContext.request.contextPath}/resources/images/ajax-loader.gif" id="loading" width="16" height="16" style="display:none;">
                        
                     </div>
                  	<div class="col-md-6 col-md-offset-4">
                        <label for="m_pw">패스워드<span class="required">* <form:errors path="m_pw" cssClass="error-color"/></span></label>
                         <form:password path="m_pw"/>
                     </div>
                  	<div class="col-md-6 col-md-offset-4">
                        <label for="m_name">이름<span class="required">* <form:errors path="m_name" cssClass="error-color"/></span></label> 
                        <form:input path="m_name"/>
                     </div>

                  	<div class="col-md-6 col-md-offset-4">
                        <label for="m_phone">전화번호<span class="required">* <form:errors path="m_phone" cssClass="error-color"/></span></label>
                        <form:input path="m_phone"/>
                     </div>
                  	<div class="col-md-6 col-md-offset-4">
                        <label for="m_email">이메일<span class="required">* <form:errors path="m_email" cssClass="error-color"/></span></label> 
                        <form:input path="m_email" type="email"/>
                     </div>
                  	<div class="col-md-6 col-md-offset-4">
                        <label for="m_address">주소<span class="required">* <form:errors path="m_address" cssClass="error-color"/></span></label>
                        <form:input path="m_address"/>
                     </div>
                  	<div class="col-md-4 col-md-offset-6">
                     <input type="submit" name="submit" class="btn btn-primary" id="submit_btn" value="전송">
                        <input type="button" class="btn btn-primary" value="Home" onclick="location.href='${pageContext.request.contextPath}/main/main.do'">
                     </div>
                  </div>
               </form:form>
            </div>
               </div>
            
            <!-- End Contact Form -->
         
         </div>
      </div>
            </div>

</div>