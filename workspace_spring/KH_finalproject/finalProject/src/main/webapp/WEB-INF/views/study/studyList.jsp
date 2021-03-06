<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/board.js"></script>
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
               <li><a class="active" href="#">Participation Zone</a>
                  <!-- 정보교류게시판/스터디그룹 모집 게시판 -->
                  <ul class="dropdown">
                     <li><a href="${pageContext.request.contextPath}/board/list.do">정보 교류</a></li>
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
               <h2>Study Group</h2>
               <div>
                  <ul class="breadcrumb">
                     <li><a href="">Home</a></li>
                     <li class="active">Study Group</li>
                  </ul>
               </div>

            </div>
         </div>
      </div>
   </div>
   <!-- End Breadcrumb Section -->

   <div class="row">
      <div class="col-md-8 col-sm-i">
         <c:if test="${count==0}">
            <div class="align-center">등록된 게시물이 없습니다.</div>
         </c:if>
         <c:if test="${count>0}">
            <table class="type11">
               <tr>
                  <th style="text-align:center">글번호</th>
                  <th style="text-align:center">제목</th>
                  <th style="text-align:center">모집인원</th>
                  <th style="text-align:center">조회수</th>
                  <th style="text-align:center">작성날짜</th>
                  <th style="text-align:center">아이디</th>
               </tr>
               <c:forEach var="article" items="${list}">
                  <tr>
                     <td>${article.sb_num}</td>
                     <td><a href="sbdetail.do?sb_num=${article.sb_num}">${article.sb_title}(${article.reply_cnt})</a></td>
                     <td>${article.sb_count}</td>
                     <td>${article.sb_hit}</td>
                     <td>${article.sb_date}</td>
                     <td>${article.m_id}</td>
                  </tr>
               </c:forEach>
            </table>
            <div style="text-align:center">${pagingHtml}</div>
            
         </c:if>
      </div>
      <!-- Sidebar -->
      <div class="col-md-4 col-sm-4">
         <div class="sidebar right-sidebar">
            <!-- Search Widget -->
            <div class="widget widget-search">
               <form action="sblist.do" id="search_form" method="get">
                  <ul class="search">
                     <li><select name="keyfield">
                           <option value="sb_title">제목</option>
                           <option value="m_id">아이디</option>
                           <option value="sb_content">내용</option>
                     </select>&nbsp;
                     
                     <input type="text" name="keyword" id="keyword" size="30"></li>
                     
                     <li><br><input type="submit" value="검색" style="float:right"></li>
                     
                  </ul>
               </form>
            </div>
            
            <!-- Categories Widget -->
            <div class="widget widget-categories">
               <h3 class="section-title">Categories</h3>
               <ul>
                  <c:if test="${!empty user_id}">
                  <li><a href="${pageContext.request.contextPath}/study/sbwrite.do">글쓰기</a></li>
                  </c:if>
                  <li><a href="${pageContext.request.contextPath}/main/main.do">홈으로</a></li>
               </ul>
            </div>
         </div>
      </div>
      <!-- End Sidebar -->
      
   </div>
</div>
