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
                        <a class="active" href="#">�Ұ�</a> <!-- �п��Ұ�/�������Ұ� -->
                        <ul class="dropdown">
                        	<li>
                        		<a href="${pageContext.request.contextPath}/academy/academyMain.do">�п� �Ұ�</a>
                        	</li>
                        	<li>
                        		<a href="${pageContext.request.contextPath}/teacher/teacherInfo.do">������ �Ұ�</a>
                        	</li>
                        	<li>
                        		<a href="${pageContext.request.contextPath}/class/classList.do">���� �Ұ�</a>
                        	</li>
                        </ul>
                    </li>
                    <li>
                        <a href="#">�Խ���</a> <!-- ���������Խ���/���͵�׷� ���� �Խ��� -->
                       	<ul class="dropdown">
                        	<li>
                        		<a href="${pageContext.request.contextPath}/board/list.do">���� ���� �Խ���</a>
                        	</li>
                        	<li>
                        		<a href="${pageContext.request.contextPath}/study/sblist.do">���͵�׷� ���� �Խ���</a>
                        	</li>
                        </ul>
                    </li>
                    <c:if test="${!empty user_id}">
                    <li>
                        <c:if test="${user_group == 1}">
                        <a href="#">�� ���� ����</a> <!-- �Ϲ�ȸ��(1) : ��������/����, �п�ȸ��(2): �п����/������ -->
                        
                        <ul class="dropdown">
                        <li>
                       		<a href="${pageContext.request.contextPath}/member/detail.do">�� ����</a>
                       	</li>
                       	<li>
                       		<a href="${pageContext.request.contextPath}/class/myClass.do">�� ���</a>
                       	</li>
                       	</ul>
                        </c:if>
                        <c:if test="${user_group == 2}">
                        <a href="#">�� ���� ����</a> <!-- �Ϲ�ȸ��(1) : ��������/����, �п�ȸ��(2): �п����/������ -->
                        <ul class="dropdown">
                        <li>
                       		<a href="${pageContext.request.contextPath}/academy/academyInfo.do">�п� ���� ����</a> <!-- �п� ���� ���, ���� -->
                       	</li>
                       	<li>
                       		<a href="${pageContext.request.contextPath}/class/classMain.do">���� ���� ����</a> <!-- ���� ���, ����, ���� -->
                       	</li>
                       	<li>
                       		<a href="${pageContext.request.contextPath}/teacher/teacherMain.do">���� ���� ����</a> <!-- ���� ���, ����, ���� -->
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
                
                <!-- TODO �� �߰��ؾ��� -->
                <div id="map" data-position-latitude="23.858092" data-position-longitude="90.262181"></div>
                
                <!-- script-->
                <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyB3zfTYI_-reir-ZFHjmHPCCFrLfIToQns"></script>
				    <script>
				    var directionsDisplay;
				    var directionsService = new google.maps.DirectionsService();
				    var map;
				    
				    var academyLocation; // �п� ��ġ
				    var currentLocation; // ���� ����� ��ġ
				    
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
				      
				      //Geocoding �ּ� -> ��ǥ
				      var address = '${academy.a_location}';
				      var geocoder = new google.maps.Geocoder();
				      geocoder.geocode({'address': address}, function(results, status){
				    	  if(status == google.maps.GeocoderStatus.OK){
				    		  academyLocation = results[0].geometry.location;
				    		  marker = new google.maps.Marker({
				    			  icon:image, //��Ŀ �̹���
				    			  title:'${academy.a_name}',
				    			  position: academyLocation
				    		  });
				    		  
				    		  //��ǳ�� ���� ����
				    		  var content = '${academy.a_name}' + "<br/><br/>Tel:'${academy.a_phone}'";
				    		  
				    		  var mapOptions = {
								        zoom:18,
								        mapTypeId: google.maps.MapTypeId.ROADMAP,
								        center: academyLocation
								      }
						      map = new google.maps.Map(document.getElementById('map'), mapOptions);
						      marker.setMap(map);
						      
						      //��Ŀ Ŭ���� �̺�Ʈ (��ǳ�� ǥ��)
				    		  var infowindow = new google.maps.InfoWindow({content:content});
				    		  google.maps.event.addListener(marker,"click",function(){infowindow.open(map,marker);});
						      
						      directionsDisplay.setMap(map);
				    		  
				    	  }else{
				    		  alert('�п� ��ġ�� ������ ǥ���� �� �����ϴ�.');
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
				    	  alert('���� ����� ��ġ�� �� �� �����ϴ�.');
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
						</i> <strong>��ġ:</strong> ${academy.a_location}<span style="float:right;"><input type="submit" value="��ã��" class="btn btn-primary" onclick="Javascript:calcRoute();" /></span>
					</li>
					<li><i class="fa fa-envelope-o"></i> <strong>��ȭ��ȣ:</strong> ${academy.a_phone}</li>
					<li><i class="fa fa-mobile"></i> <strong>���ƿ�: </strong> ${academy.a_good}</li>
					<li><strong>������� ����: </strong>
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
				<input type="button" onclick="location.href='${pageContext.request.contextPath}/class/classList.do'"class="btn btn-primary"  value="���� ���� ����">
				
				<!-- End Contact Form -->
            </div>
        </div>
    </div>
    <!-- End Contact Section -->
        
</div>