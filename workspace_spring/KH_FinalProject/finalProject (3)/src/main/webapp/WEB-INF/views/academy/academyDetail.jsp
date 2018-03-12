<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
    
    <!-- Start Map Section -->
    <div class="row">
        <div class="col-md-12">
            <div class="default-page">
                
                <!-- TODO 맵 추가해야함 -->
                <div id="map" data-position-latitude="23.858092" data-position-longitude="90.262181"></div>
                
                <!-- script-->
                <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyB3zfTYI_-reir-ZFHjmHPCCFrLfIToQns"></script>
				    <script>
				    var directionsDisplay;
				    var directionsService = new google.maps.DirectionsService();
				    var map;
				    
				    var academyLocation; // 학원 위치
				    var currentLocation; // 현재 기기의 위치
				    
				    var size_x = 40;
				    var size_y = 40;
				    
				    var marker = null;
				    var image = new google.maps.MarkerImage( 'http://www.larva.re.kr/home/img/boximage3.png',
                            new google.maps.Size(size_x, size_y),
                            '',
                            '',
                            new google.maps.Size(size_x, size_y));
         
				 
				    function initialize() {
				      directionsDisplay = new google.maps.DirectionsRenderer();
				      
				      //Geocoding 주소 -> 좌표
				      var address = '${academy.a_location}';
				      var geocoder = new google.maps.Geocoder();
				      geocoder.geocode({'address': address}, function(results, status){
				    	  if(status == google.maps.GeocoderStatus.OK){
				    		  academyLocation = results[0].geometry.location;
				    		  marker = new google.maps.Marker({
				    			  icon:image, //마커 이미지
				    			  title:'${academy.a_name}',
				    			  position: academyLocation
				    		  });
				    		  
				    		  //말풍선 안의 내용
				    		  var content = '${academy.a_name}' + "<br/><br/>Tel:'${academy.a_phone}'";
				    		  
				    		  var mapOptions = {
								        zoom:18,
								        mapTypeId: google.maps.MapTypeId.ROADMAP,
								        center: academyLocation
								      }
						      map = new google.maps.Map(document.getElementById('map'), mapOptions);
						      marker.setMap(map);
						      
						      //마커 클릭시 이벤트 (말풍선 표시)
				    		  var infowindow = new google.maps.InfoWindow({content:content});
				    		  google.maps.event.addListener(marker,"click",function(){infowindow.open(map,marker);});
						      
						      directionsDisplay.setMap(map);
				    		  
				    	  }else{
				    		  alert('학원 위치를 지도에 표시할 수 없습니다.');
				    	  }
				      });
				      if(navigator.geolocation){
				    		navigator.geolocation.getCurrentPosition(function(position){
				    			currentLocation = {
				    					lat: position.coords.latitude,
				    					lng: position.coords.longitude
				    			}
				    		});
				      }else{
				    	  alert('현재 기기의 위치를 알 수 없습니다.');
				      }
				      
				      
				    }
				    
				 
				    function calcRoute() {
				    					      
				      var start = currentLocation;
				      var end = academyLocation;
				      var mode = 'TRANSIT';
				 
				      var request = {
				          origin:start,
				          destination:end,
				          travelMode: eval("google.maps.DirectionsTravelMode."+mode)
				      };
				      directionsService.route(request, function(response, status) {
				        if (status == google.maps.DirectionsStatus.OK) {
				            directionsDisplay.setDirections(response);
				        }
				      });
				    }
				 
				    google.maps.event.addDomListener(window, 'load', initialize);
				 
				    </script>
                                
            </div>
        </div>
    </div>
    <!-- End Map Section -->
    
    <!-- Start Contact Section -->
    <div class="row">
        <div class="col-md-8">
            <div class="contact-section">
				<h3 class="section-title">${academy.a_name}</h3>
				
				<!-- Some Info -->
				<p>${academy.a_content}</p>
				
				<!-- Info - Icons List -->
				<ul class="icons-list">
					<li><i class="fa fa-globe">  
						</i> <strong>위치:</strong> ${academy.a_location}<span style="float:right;"><input type="submit" value="길찾기" class="btn btn-primary" onclick="Javascript:calcRoute();" /></span>
					</li>
					<li><i class="fa fa-envelope-o"></i> <strong>전화번호:</strong> ${academy.a_phone}</li>
					<li><i class="fa fa-mobile"></i> <strong>좋아요: </strong> ${academy.a_good}</li>
					<li><strong>할인행사 유무: </strong>
					<c:if test="${empty academy.cp_num}">X</c:if>
					<c:if test="${!empty academy.cp_num}">O</c:if>
					</li>
				</ul>
				
			</div>
        </div>
        <div class="col-md-4">
            <div class="contact-section">
                <!-- Start Contact Form -->
				<h3 class="section-title">Working Hours</h3>
		
				<ul class="list-unstyled">
					<li><strong>Monday - Friday</strong> - 9am to 5pm</li>
					<li><strong>Saturday</strong> - 9am to 2pm</li>
					<li><strong>Sunday</strong> - Closed</li>
				</ul>
				<br/>
				<input type="button" onclick="location.href='${pageContext.request.contextPath}/class/classList.do'"class="btn btn-primary"  value="강의 정보 보기">
				
				<!-- End Contact Form -->
            </div>
        </div>
    </div>
    <!-- End Contact Section -->
        
</div>