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
               <li><a
                  href="#">Information</a>
                  <!-- 학원소개/강사진소개 -->
                  <ul class="dropdown">
                     <li><a href="${pageContext.request.contextPath}/academy/academyMain.do">학원 정보</a></li>
                     <li><a href="${pageContext.request.contextPath}/teacher/teacherInfo.do">강사진 정보</a></li>
                     <li><a href="${pageContext.request.contextPath}/class/classList.do">강의 정보</a></li>
                  </ul>
               </li>
               <li><a class="active"
                  href="#">Participation Zone</a> <!-- 정보교류게시판/스터디그룹 모집 게시판 -->
                  <ul class="dropdown">
                     <li><a
                        href="${pageContext.request.contextPath}/board/list.do">정보
                           교류</a></li>
                     <li><a href="${pageContext.request.contextPath}/study/sblist.do">스터디그룹 모집</a></li>
                  </ul></li>
               <c:if test="${!empty user_id}">
                  <li><a
                     href="#">My Page</a> <!-- 일반회원(1) : 정보보기/찜목록, 학원회원(2): 학원등록/강사등록 --> 
                     <c:if
                        test="${user_group == 1}">
                        <ul class="dropdown">
                           <li><a href="${pageContext.request.contextPath}/member/detail.do">내 정보</a></li>
                           <li>
                       		<a href="${pageContext.request.contextPath}/class/myClass.do">내가 찜한 강의</a>
	                       	</li>
							<li>
								<a href="${pageContext.request.contextPath}/class/classCompleteList.do">수강 신청 완료 목록</a>
							</li>
                        </ul>
                     </c:if> <c:if test="${user_group == 2}">
                        <ul class="dropdown">
                           <li><a
                              href="${pageContext.request.contextPath}/academy/academyInfo.do">학원
                                 관리</a> <!-- 학원 정보 등록, 수정 --></li>
                           <li><a
                              href="${pageContext.request.contextPath}/class/classMain.do">강의
                                 관리</a> <!-- 강의 등록, 수정, 삭제 --></li>
                           <li><a
                              href="${pageContext.request.contextPath}/teacher/teacherMain.do">강사
                                 관리</a> <!-- 강사 등록, 수정, 삭제 --></li>
                        </ul>
                     </c:if></li>
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

   <div class="page-main-style">
      
      <!--    // 같은 경로에서 파일을 호출시에는 파일명만 호출해도 앞에 있는 주소는 그대로 나옴 -->

      <div class="row">
         <div class="col-md-8 col-sm-i">
            <div class="form-test">
               <div class="form-area">
                  <div class="contact-section">
                     <form:form commandName="command" action="sbupdate.do" id="update_form">
                        <form:errors element="div" cssClass="error-color"/>
                        <h3 style="margin-bottom: 25px; text-align: center;">Update Form</h3>
                        <form:hidden path="m_num" />
                        <form:hidden path="sb_num" />
                     
                        <div class="form-group">
                           <label for="sb_title">제목<span class="required">*</span></label>
                           <form:input path="sb_title" class="form-control" />
                        </div>
                        
                        <div class="form-group">
                           <label for="sb_content">내용<span class="required">*</span></label>
                           <form:textarea path="sb_content" class="form-control" placeholder="내용을 입력하세요." maxlength="140" rows="7"/>
                        </div>
                        
                        <div class="form-group">
                           <label for="sb_count">모집인원<span class="required">*</span>&nbsp;<form:errors path="sb_count" cssClass="error-color"/></label>
                           <input type="number" name="sb_count" min="1" max="30"
                             <c:if test="${command.sb_count ==0}">
                              value=""
                             </c:if>
                             <c:if test="${command.sb_count !=0}">
                              value="${command.sb_count}"
                             </c:if>
                              required="required" class="form-control" style="width:80px;">
                        </div>
                        
                     <p align="right">
                        <input type="submit" name="submit" class="btn btn-primary" id="submit_btn" value="전송">
                        <input type="button" value="목록" class="btn btn-primary" onclick="location.href='sblist.do'">
                        </p>
                        
                     </form:form>
                  </div>
               </div>
            </div>
         </div>

         <div class="col-md-4 col-sm-4">
            <div class="sidebar right-sidebar">
               <!-- Categories Widget -->
               <div class="widget widget-categories">
                  <h3 class="section-title">Categories</h3>
                  <ul>
                     <c:if test="${!empty user_id}">
                        <li><a
                           href="${pageContext.request.contextPath}/study/sbwrite.do">글쓰기</a></li>
                     </c:if>
                     <li><a
                        href="${pageContext.request.contextPath}/main/main.do">홈으로</a></li>
                  </ul>
               </div>

            </div>
         </div>
      </div>
   </div>
</div>