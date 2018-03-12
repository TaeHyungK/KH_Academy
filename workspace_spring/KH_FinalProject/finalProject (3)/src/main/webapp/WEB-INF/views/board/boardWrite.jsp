<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
   <!-- Start Navigation Section -->
   <div class="navigation">

      <div class="navbar navbar-default navbar-top">
         <div class="navbar-header">
            <!-- Stat Toggle Nav Link For Mobiles -->
            <button type="button" class="navbar-toggle" data-toggle="collapse"
               data-target=".navbar-collapse">
               <i class="fa fa-bars"></i>
            </button>

         </div>
         <div class="navbar-collapse collapse">

            <!-- Start Navigation List -->
            <ul class="nav navbar-nav">
               <li><a href="${pageContext.request.contextPath}/main/main.do">Home</a></li>
               <li><a href="#">소개</a>
                  <!-- 학원소개/강사진소개 -->
                  <ul class="dropdown">
                     <li><a href="${pageContext.request.contextPath}/academy/academyMain.do">학원 소개</a></li>
                     <li><a href="${pageContext.request.contextPath}/teacher/teacherInfo.do">강사진 소개</a></li>
                     <li><a href="${pageContext.request.contextPath}/class/classList.do">강의 소개</a></li>
                  </ul>
               </li>
               <li><a class="active" href="${pageContext.request.contextPath}/board/list.do">게시판</a>
                  <!-- 정보교류게시판/스터디그룹 모집 게시판 -->
                  <ul class="dropdown">
                     <li><a href="${pageContext.request.contextPath}/board/list.do">정보 교류 게시판</a></li>
                     <li><a href="${pageContext.request.contextPath}/study/sblist.do">스터디그룹 모집 게시판</a></li>
                  </ul>
               </li>
               <c:if test="${!empty user_id}">
                  <li>
                     <a href="${pageContext.request.contextPath}/academy/academyMain.do">내 정보 관리</a> <!-- 일반회원(1) : 정보보기/찜목록, 학원회원(2): 학원등록/강사등록 -->
                     <c:if test="${user_group == 1}">
                        <ul class="dropdown">
                           <li><a href="${pageContext.request.contextPath}/member/detail.do">내 정보</a></li>
                           <li><a href="${pageContext.request.contextPath}/class/myClass.do">찜 목록</a></li>
                        </ul>
                     </c:if> 
                     <c:if test="${user_group == 2}">
                        <ul class="dropdown">
                           <li><a
                              href="${pageContext.request.contextPath}/academy/academyInfo.do">학원
                                 정보 보기</a> <!-- 학원 정보 등록, 수정 --></li>
                           <li><a
                              href="${pageContext.request.contextPath}/class/classMain.do">강의
                                 정보 보기</a> <!-- 강의 등록, 수정, 삭제 --></li>
                           <li><a
                              href="${pageContext.request.contextPath}/teacher/teacherMain.do">강사
                                 정보 보기</a> <!-- 강사 등록, 수정, 삭제 --></li>
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
               <h2>Information Exchange</h2>
               <div>
                  <ul class="breadcrumb">
                     <li><a href="">Home</a></li>
                     <li class="active">Information Exchange</li>
                  </ul>
               </div>

            </div>
         </div>
      </div>
   </div>
   <!-- End Breadcrumb Section -->

   <div class="row">
      <div class="col-md-8 col-sm-i">
         <div class="form-test">
            <div class="form-area">
               <div class="contact-section" >
                  <form:form commandName="command" action="write.do" id="write_form">
                        <form:errors element="div" cssClass="error-color"/>
                        <h3 style="margin-bottom: 25px; text-align: center;">Write Form</h3>
                        <form:hidden path="m_num" />
                     
                        <div class="form-group">
                           <label for="ib_title">제목<span class="required">*</span>&nbsp;<form:errors path="ib_title" cssClass="error-color"/></label>
                           <form:input path="ib_title" class="form-control" />
                           
                        </div>
                        
                        <div class="form-group">
                           <label for="ib_content">내용<span class="required">*</span>&nbsp;<form:errors path="ib_content" cssClass="error-color"/></label>
                           <form:textarea path="ib_content" class="form-control" placeholder="내용을 입력하세요." maxlength="140" rows="7"/>
                        </div>
                        
                     <p align="right">
                        <input type="submit" name="submit" class="btn btn-primary" id="submit_btn" value="전송" >
                        <input type="button" value="목록" class="btn btn-primary" onclick="location.href='list.do'">
                        </p>
                        
                     </form:form>
               </div>
            </div>
         </div>
      </div>
      
      <!-- Sidebar -->
      <div class="col-md-4 col-sm-4">
         <div class="sidebar right-sidebar">
            <!-- Categories Widget -->
            <div class="widget widget-categories">
               <h3 class="section-title">Categories</h3>
               <ul>
                  <li><a href="${pageContext.request.contextPath}/main/main.do">홈으로</a></li>
               </ul>
            </div>
         </div>
      </div>
      <!-- End Sidebar -->
   </div>
      
   </div>






















