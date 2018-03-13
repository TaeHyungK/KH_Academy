<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<script type="text/javascript"src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/board.reply.js"></script>
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
               <li><a href="${pageContext.request.contextPath}/main/main.do">Home</a>
               </li>
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
                     <c:if test="${user_group == 1}">
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

   <div class="col-md-8 col-sm-i">

      <h2>${form.ib_title}</h2>
      <hr>
      <ul>
         <li>글번호 : ${form.ib_num}</li>
         <li>작성자 : ${form.m_id}</li>
         <li>조회수 : ${form.ib_hit}</li>
         <li>작성날짜 : ${form.ib_date}</li>
      </ul>

      <br>

      <p>${form.ib_content}</p>

      <hr size="1" width="100%">

      <div class="align-right">
         <p align="right">
          <c:if test="${!empty user_id && user_id == form.m_id}">
         <input type="button" value="수정" class="btn btn-primary"
            onclick="location.href='update.do?ib_num=${form.ib_num}'" >
         <input type="button" value="삭제" class="btn btn-primary"
            onclick="location.href='delete.do?ib_num=${form.ib_num}'" >
         </c:if>
         <input type="button" value="목록" class="btn btn-primary"
            onclick="location.href='list.do'" >
         </p>
      </div>

      <br><br><br>

      <div id="reply_div">
         <form id="re_form">
            <input type="hidden" name="m_id" value="${user_id}" id="user_id">
            <input type="hidden" name="m_num" value="${user_num}" id="user_num">
            <input type="hidden" name="ib_num" value="${form.ib_num}" id="ib_num">

            <textarea rows="3" cols="100" name="ic_content" id="ic_content"
               class="rep-content"
               <c:if test="${empty user_id}">disabled="disabled"</c:if>><c:if
                  test="${empty user_id}">로그인시에 댓글 입력이 가능합니다.</c:if></textarea>
               <c:if test="${!empty user_id}">
               
               <br><br>
               
               <div id="mre_second" class="align-right">
                  <input type="submit" class="btn btn-primary" value="전송" style="float:right">
               </div>
            </c:if>
         </form>

      </div>
      
      <br><br>
      
      <!-- 목록 출력 -->
      <div id="output"></div>
      <div class="paging-button" style="display: none;">
         <input type="button" value="다음글 보기">
      </div>
      <div id="loading" style="display: none;">
         <img
            src="${pageContext.request.contextPath}/resources/images/ajax-loader.gif">
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
                     href="${pageContext.request.contextPath}/board/write.do">글쓰기</a></li>
               </c:if>
               <li><a href="${pageContext.request.contextPath}/main/main.do">홈으로</a></li>
            </ul>
         </div>
      </div>
   </div>
</div>