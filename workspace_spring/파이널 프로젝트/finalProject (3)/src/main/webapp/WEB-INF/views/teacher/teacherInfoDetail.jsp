<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
					<h2>Pricing</h2>
					<div>
						<ul class="breadcrumb">
							<li><a href="">Home</a></li>
							<li class="active">Pricing</li>
						</ul>
					</div>

				</div>
			</div>
		</div>
	</div>
	<!-- End Breadcrumb Section -->
	<div class="col-md-12">
            <div class="default-page">
                <div class="row">
                
                    <div class="col-md-7">
                        <c:if test="${fn:endsWith(teacher.t_image,'.jpg')|| fn:endsWith(teacher.t_image,'.JPG')||
										  fn:endsWith(teacher.t_image,'.gif')|| fn:endsWith(teacher.t_image,'.GIF')||
										  fn:endsWith(teacher.t_image,'.png')|| fn:endsWith(teacher.t_image,'.PNG')}">
										<!-- TODO 강사 상세보기 만들면 url 바꿔야됨!! -->
	                        	<img src="t_imageView.do?t_num=${teacher.t_num}" class="img-responsive" alt="" style="width:520px;height:250px;"/>
	                        </c:if>
	                        <c:if test="${empty teacher.t_image}">
	                        	<img src="${pageContext.request.contextPath}/resources/images/no-image.jpg" class="img-responsive" alt="" style="width:520px;height:250px;"/>
	                    </c:if>
                    </div>
                    <!-- /.col-md-7 -->
                    <div class="col-md-5">
                        <h4>강사 이름 : ${teacher.t_name} </h4>
                        <p>강사 소개 : ${teacher.t_content }</p>
                        <div class="service-details">
                            <ul>
                                <li><i class="fa fa-check-square-o"></i>
                                 강사 이력 : ${teacher.t_record}</li>
                                <li><i class="fa fa-check-square-o"></i> 
                                미리 보기 : ${teacher.t_preview}</li>
                              <li>
                           	 좋아요 수 : <div id="t_good_${teacher.t_num}">${teacher.t_good}</div>
                           	 </li> 
                          	<li><i class="fa fa-check-square-o"></i> 
                          <c:if test="${teacher.c_m_num <=0}">
                          		<i id="liked-icon-${teacher.t_num}" class="far fa-thumbs-up" data-num="${teacher.t_num}" style="cursor:pointer;" ></i>
                          	</c:if>
                          	
                          	<c:if test="${teacher.c_m_num>0}">
                          		<i id="liked-icon-${teacher.t_num}" class="fas fa-thumbs-up" data-num="${teacher.t_num}" style="cursor:pointer;" ></i>
                          	</c:if>	
                           	 </li>  
                           	  
                            </ul>
                        </div>  
                    </div>
            	</div>
            </div>
            <script type="text/javascript">
                              $('.fa-thumbs-up').click(function(){
                                 var thisEvent = $(this);
                                 var t_num = thisEvent.data('num');
                                 var currentClass = thisEvent.attr('class');
                               $.ajax({
                                  type:'post',
                                  data:{t_num:t_num,currentClass:currentClass},
                                  url:'likedTeacher.do',
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
                                        $('#t_good_'+t_num).text(data.likedCount);                                      
                                        
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
        </div>
	
