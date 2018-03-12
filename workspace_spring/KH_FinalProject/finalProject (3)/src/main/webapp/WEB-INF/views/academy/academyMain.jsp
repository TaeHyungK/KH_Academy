 <%@page import="java.util.List"%>
<%@page import="kr.spring.finalp.domain.AcademyCommand"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
   int liked_count = 1;
   int rank = 1;
%>

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
                        <a class="active" href="#">소개</a> <!-- 학원소개/강사진소개 -->
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
                        <a href="#">내 정보 관리</a> <!-- 일반회원(1) : 정보보기/찜목록, 학원회원(2): 학원등록/강사등록 -->
                        
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
                        <a href="#">내 정보 관리</a> <!-- 일반회원(1) : 정보보기/찜목록, 학원회원(2): 학원등록/강사등록 -->
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
    
   <!-- Start Breadcrumb Section -->
    <div class="row">
        <div class="col-md-12">
            <div class="page-title">
                <div class="page-title-overlay">
                    <h2>Introduce</h2>
                    <div>
                        <ul class="breadcrumb">
                            <li><a href="${pageContext.request.contextPath}/main/main.do">Home</a></li>
                            <li class="active">Academies</li>
                            <li><a href="${pageContext.request.contextPath}/academy/teacherMain.do">Teachers</a>
                        </ul>
                    </div>
                    
                </div>
            </div>
        </div>
    </div>
    <!-- End Breadcrumb Section -->
    
    <!-- Start Pricing Page -->
    <div class="row">
        <div class="col-md-12">
            <div class="pricing-section">
                <h3 class="section-title">Top 5</h3>
                <div class="row">
                    <div class="pricing" id="pricing">
                  <c:forEach var="topItem" items="${topList}">
                  <div class="pricing-table">
                     <div class="plan-name">
                        <h3><%=rank %> 순위</h3>
                     </div>
                        <div class="plan-price line_hide">
                            <div class="price-value">${topItem.a_name}</div>
                        </div>
                        <div class="plan-list">
                            <ul>
                                <li>${topItem.a_content}</li>
                                <li style="text-align:left;"><i class="fa fa-globe"></i> <strong>위치: </strong>${topItem.a_location}</li>
                                <li style="text-align:left;"><i class="fa fa-mobile"></i> <strong>전화번호: </strong>${topItem.a_phone}</li>
                                <li style="text-align:left;"><i class="fa fa-thumbs-up"></i> <strong>좋아요: </strong>${topItem.a_good}</li>
                            </ul>
                        </div>
                        <div class="plan-signup" onclick="location.href='academyDetail.do?a_num=${topItem.a_num}'" style="cursor:pointer;">
                            <a href="academyDetail.do?a_num=${topItem.a_num}" class="btn-system btn-small">더보기</a>
                        </div>         
                  </div>
                  <%rank++; %>
                  </c:forEach>
                  
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- End Pricing Page -->
    
    <!-- Start Blog Page -->
    <div class="row">
        <div class="col-md-8 col-sm-8">
            <!-- Accordion -->
            <div class="default-page">
                
            <div class="panel-group table-responsive line-hide" id="accordion">
               
               <c:if test="${count==0}">
               <div class="align-center">등록된 게시물이 없습니다.</div>
               </c:if>
               <c:if test="${count>0}">
                      <table class="table type11">
                          <thead>
                          <tr>
                              <th >이름</th>
                              <th colspan="2">위치</th>
                              <th >전화번호</th>
                              <th>소개글</th>
                              <th>좋아요수</th>
                              <th style="width:40px;"></th>
                          </tr>
                          </thead>
                          <tbody> 
                          <tr>    
                         <% 
                          HttpSession mSession = request.getSession();
                          Integer user_num = (Integer) mSession.getAttribute("user_num");
                          List<AcademyCommand> mList = (List<AcademyCommand>) request.getAttribute("myLikedList");
                          
                          for(int i = 0; i<mList.size(); i++){
                        	  /* if((Integer)mList.get(i).getC_m_num() != 0){
                        	     if(i==0){ 
                        	    	if((Integer)mList.get(i).getCurNum() != (Integer)mList.get(i+1).getCurNum() && (Integer)mList.get(i).getC_m_num() != user_num)
										continue;
                        	     }
                        	     
	                             if(i>0){ //두번째 리스트부터 앞에꺼랑 비교!   
									if((Integer)mList.get(i).getCurNum() != (Integer)mList.get(i-1).getCurNum() )
										continue; 
							 	 } 
                        	  }  */
	                                 
                         %>
                              <td><a href="academyDetail.do?a_num=<%=mList.get(i).getA_num()%>"><%=mList.get(i).getA_name() %>(<%=mList.get(i).getA_num()%>)</a></td>
                              <td colspan="2"><%=mList.get(i).getA_location() %></td>
                              <td><%=mList.get(i).getA_phone() %></td>
                              <td><%=mList.get(i).getA_content() %></td>
                              <td id="a_good_<%=mList.get(i).getA_num() %>"><%=mList.get(i).getA_good()%> </td>
                              <td>
                         <%     
                         //      <!-- 내가 좋아요 한 학원번호랑 일반 학원번호랑 같은경우(검은색손) -->
                         //      <!-- 1. 학원번호랑 접속한아이디로 누른 학원번호가 같을때  || 2. 좋아요를 누른 회원번호랑 로그인(세션)된 번호랑 같을때  -->
                             if((Integer)mList.get(i).getC_m_num()>0){
                         %>  
                                <i id="liked-icon-<%=mList.get(i).getA_num() %>" class="fas fa-thumbs-up" data-num="<%=mList.get(i).getA_num() %>" style="cursor:pointer;" ></i>
                         <%
                             }
                             //문제!-로그인해서 1번학원 좋아요 누르고 다른아이디도 좋아요를 누르면 하얀손으로나옴!!
                             
                             //1. 로그인이 안되어 있거나 || 좋아요를 누른 회원번호가 로그인(세션)된 번호랑 다를때
                             else{
                         %> 
                                <i id="liked-icon-<%=mList.get(i).getA_num() %>" class="far fa-thumbs-up" data-num="<%=mList.get(i).getA_num() %>" style="cursor:pointer;" ></i>
                         <%        
                              }
                         %>
                            </td>
                         </tr>
                         <%
                          } 
                         %>
                   </tbody>
                          
                       </table>
                           <script type="text/javascript">
                              $('.fa-thumbs-up').click(function(){
                                 var thisEvent = $(this);
                                 var a_num = thisEvent.data('num');
                                 var currentClass = thisEvent.attr('class');
                                                                                             
                               $.ajax({
                                  type:'post',
                                  data:{a_num:a_num,currentClass:currentClass},
                                  url:'likedAcademy.do',
                                  dataType:'json',
                                  cache:false,
                                  timeout:30000,
                                  success:function(data){
                                     if(data.result == 'success'){
                                        if(thisEvent.attr('class') == 'far fa-thumbs-up'){
                                           thisEvent.attr('class', 'fas fa-thumbs-up');
                                        }else{
                                           thisEvent.attr('class', 'far fa-thumbs-up');
                                        }
                                        $('#a_good_'+a_num).text(data.likedCount);                                      
                                        
                                     }else if(data.result == 'logout'){
                                        alert('로그인 시에만 좋아요가 가능합니다.');
                                         window.location.replace("../member/login.do");
                                     }else{
                                        alert('오류 발생! 다시 시도해주세요.');
                                     }
                                  },
                                  error:function(request,error){
                                     alert('네트워크 통신 실패!');
                                  }
                               });
                              });
                          </script> 
                  <div style="text-align:center">${pagingHtml}</div>
                </c:if>   
               </div>
            </div>
         <!-- End Accordion -->
         
        </div>
        
        <!--Sidebar-->
      <div class="col-md-4 col-sm-4">
                        
            <div class="sidebar right-sidebar">
                  
            <!-- Search Widget -->
            <div class="widget widget-search">
               <form action="academyMain.do" id="academy_search_form" method="get">
                  <input type="search" placeholder="Enter Academy Name..." name = "keyword" id="keyword"/>
                  <button class="search-btn" type="submit"><i class="fa fa-search"></i></button>
               </form>
            </div>

            <!-- Categories Widget -->
            <div class="widget widget-categories">
               <h3 class="section-title">Categories</h3>
               <ul>
                  <li>
                     <a href="#">Brandign</a>
                  </li>
                  <li>
                     <a href="${pageContext.request.contextPath}/main/main.do">홈으로</a>
                  </li>
               </ul>
            </div>            

         </div>
        </div>
      <!--End sidebar-->
        
        
    </div>
    <!-- End Blog Page -->
    
    
    
    
</div>