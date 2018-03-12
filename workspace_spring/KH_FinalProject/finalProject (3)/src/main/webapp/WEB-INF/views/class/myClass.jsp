<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<head> 
 <link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">
</head>

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
                        <a href="#">소개</a> <!-- 학원소개/강사진소개 -->
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
                        <a href="#">내 정보 관리</a> <!-- 일반회원(1) : 정보보기/찜목록, 학원회원(2): 학원등록/강사등록 -->
                        
                        <c:if test="${user_group == 1}">
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
	<script type="text/javascript">
/*  	if($("input[name=check1]").is(":checked")==true) {
		 
		var cArray = new Array();
		$("input[name=check1]:checked").each(function(){
			cArray.push($(this).val());
		}); 
		var length = $("input[name=check1]:checked").length;
		alert(length);
		alert(cArray);
	}else{ 
		alert('aa');
	}  */  
/* 	$(document).ready(function(){
	var Check ="";
	$("#check1").change(function(){
		if($(this).is(':checked'))
			 Check += ($(this).val());
		alert(Check);

	}); 
	}); 
	 */
/* 	
function insert_Ck(){
		var chklen = document.form.check.length;
		for(int i=0;i<chklen; i++){
			if(document.form.check[i].checked == true){
				alert(document.form.check[i].value);
			}
		}
	} */

	   /*   $(".check").change(function(){
	    	 var gg = new Array();
	    	 var gg2 = new Array();
	    	 var gg3 = new Array();
         	   var val = $(this).val();
	           var start = $(this).attr('data-start');
	           var end = $(this).attr('data-end');
				var my_num = $(this).attr('data-num');

            
	    	 $("input[name=check]:checked").each(function(){
           //alert(val); 
	    			gg.push(start); 
	               	gg2.push(end);
	               //	gg3.push(my_num);
	    	});
	    	 var s = $("input:checkbox[name=check]").length
			 var a = $("input:checkbox[name=check]:checked").length 
			 alert("전체" + s + "선택" + a);
	    
	    	for(var i = 1; i<gg.length; i++){ 
	    		 if(a==1){
		    		 continue;
		    	 }else{
        		alert("시작"+gg[i]);  
        		alert("종료"+gg2[i]);
        		//alert("번호"+gg3[i]);
        		  
       		 	if(end >= gg[i] && start <= gg2[i]){
           			alert("end : "+end+"gg[i] : " + gg[i] + " 중복");
           			
           			//$(".check").disabled ='true';
           			break; 
           		} 
        	}
	    	 }
	  	 });
         	
  	}); */
  	$(document).ready(function(){ 
  		var total = 0;
  		$(".check").change(function(){ 
  			//$('#list'+'data-num').on('click',function(){
	        //if($("input:checkbox[id='list"+'data-num'+"']").prop("checked", true)){
	        	//if($('.check').is(':checked')){
	        	var c = $(this).attr('data-num');
	        	
	        	if($("input:checkbox[id='list"+c+"']").is(':checked')){

		            var start = $(this).attr('data-start');
		            var end = $(this).attr('data-end');
					var my_num = $(this).attr('data-num');
					var price = Number($(this).attr('data-price'));
					total += price;
					showTotal();
					
		            var list1 = new Array(); 
		            <c:forEach var="list1" items="${list}">
		            	list1.push("${list1.c_start}");
		            </c:forEach>
		            
		            var list2 = new Array(); 
		            <c:forEach var="list2" items="${list}">
		            	list2.push("${list2.c_end}");
		            </c:forEach>
		            
		            var list3 = new Array();
		            <c:forEach var="list3" items="${list}">
	            		list3.push("${list3.my_num}");
	            	</c:forEach> 
	
	            	 for(var i = 0; i<list1.length; i++){
							            		 
	            		if(my_num != list3[i]){
	            			if(end >= list1[i] && start <= list2[i]){
	            			
	                			//for(var j=0; j<list3[i].length; j++){
	                				$('#list'+list3[i]).attr("disabled",true);
	                			//	alert(list3[i].length); 
	                			//}
	                		}
	 	            	}
	            	 }
	            	 
	            	 
	        }else{ 
	        	//if($("input:checkbox[id='list"+'data-num'+"']").prop("checked", false)) {
	              
	            var start = $(this).attr('data-start');
	            var end = $(this).attr('data-end');
				var my_num = $(this).attr('data-num');
				var price = Number($(this).attr('data-price'));
				total -= price;
				showTotal();
				
	            var list1 = new Array(); 
	            <c:forEach var="list1" items="${list}">
	            	list1.push("${list1.c_start}");
	            </c:forEach>
	            
	            var list2 = new Array(); 
	            <c:forEach var="list2" items="${list}">
	            	list2.push("${list2.c_end}");
	            </c:forEach>
	            
	            var list3 = new Array();
	            <c:forEach var="list3" items="${list}">
            		list3.push("${list3.my_num}");
            	</c:forEach> 
            	
	            for(var i = 0; i<list2.length; i++){
            		if(my_num != list3[i]){
            			if(end >= list1[i] && start <= list2[i]){
            				alert(list3[i]);
                			//$("input:checkbox[name=check]").disabled;
                				$('#list'+list3[i]).removeAttr('disabled');
                		}
 	            	} 
            	 } 
	        } 
	        });
	  		function showTotal(){
	  	 	   $('#total').html(total.toLocaleString());
	  	 	   document.getElementById("total_price").value=total;
	  	  	}
 	    });   

  		 
 		function complete() {
 			var param="";
 			
 			$("input[name=check]:checked").each(function(){
	 			var my = $(this).val();
	 		 	var m = ${user_num}
	 			var c = $(this).data('c'); 
	 			var total_price = $('#total_price').val();
	 			if(param==""){
	 				param = "my_num="+ my + "&m_num="+m+"&c_num="+c+"&total_price="+total_price;
	 			}else{
					param += "&my_num="+my+ "&m_num="+m+"&c_num="+c+"&total_price="+total_price;
	 			}
 	   		});	
 			 
 			$.ajax({
 				url:'classComplete.do',
 				type:'post',
 				data:param,
 				dataType:'text',
 				success:function(data){
 					console.log('retrn string : ' + data);
 					window.location.replace("classCompleteList.do");
 				},   
 				error:function(){
 					console.log('error');	
 				} 
 			});
 			
 	   };  
 	//강의 삭제
 	   $(document).on('click','.cart_quantity_delete',function(){
 	      //내가찜한 번호
 	      var my_num = $(this).attr('data-num');
 	      
 	      $.ajax({
 	         type:'post',
 	         data:{my_num:my_num},
 	         dataType:'json',
 	         url:'classDelete.do',
 	         cache:false,
 	         timeout:10000,
 	         success:function(data){
 	            if(data.result=='logout'){
 	               alert('로그인을 먼저 실행해 주세요');
 	            }else if(data.result=='success'){
 	               alert('삭제 되었습니다.');
 	              window.location.reload();
 	            }else{
 	               alert('에러 발생');
 	            }
 	         },
 	         error:function(){
 	            alert('네트워크 오류');
 	         }
 	      });
 	   });
 	  

</script>    
           
	<div class="row">
		<div class="sidebar right-sidebar">
			<div class="col-md-8">
            	<div class="contact-section">
            	
 
            	
					<table class="table table-condensed">
						<thead>
							<tr class="cart_menu" align="center">
								<td class="image">선택</td>
								<td class="description">강의 명</td>
								<td class="price">개강/종강</td>
								<td class="quantity">현재인원/총인원</td>
								<td class="total">수강료</td>
								<td></td>
							</tr>
						</thead>

						 
						<tbody>		
						
						<c:forEach var="list" items="${list}">
							<tr align="center" id="one${list.my_num}" data-num="${list.my_num}">
								<td class="cart_product">
									
									<input id="list${list.my_num}" type="checkbox" class="check" name="check" value="${list.my_num}"
									 data-num="${list.my_num}" data-c="${list.c_num}"data-start="${list.c_start}" data-end="${list.c_end}"
									  data-price="${list.c_tuition}">
									${list.my_num}  
								</td>
								<td class="cart_description">
									<h4><a href="">${list.c_name}</a></h4>
									<p>학원 이름 : ${academy.a_name}</p>
								</td>
								<td class="cart_price">
									<p>${list.c_start} ~ ${list.c_end}</p>
								</td>
								<td class="cart_quantity">
								${list.c_count}/${list.c_max_count}
								</td> 
								<td class="cart_total">
									<p class="cart_total_price"><fmt:formatNumber value="${list.c_tuition}" pattern="#,###원"/></p>
			 					</td>
								
								<td class="cart_delete"> 
									<a class="cart_quantity_delete" 
									href="${pageContext.request.contextPath}/class/classDelete.do?my_num=${list.my_num}" 
									data-num="${list.my_num}"><i class="fa fa-times"></i></a>
								</td>
								
							</tr>
							</c:forEach>
						</tbody>

					</table>
					총 수강료 :  <span id="total">0</span>&nbsp;원
					<input type="hidden" name="total_price" id="total_price">
					<p align="center"><a class="btn btn-primary" id="submit_btn" href="#" onclick="complete();">수강신청</a></p>
				</div>
        	</div>
			<div class="col-md-4">
				<!-- Categories Widget -->
				<div class="widget widget-categories">
					<h3 class="section-title">Categories</h3>
					<ul>
						<li><a href="${pageContext.request.contextPath}/class/myClass.do">내가 찜한 강의</a></li>
						<li><a href="${pageContext.request.contextPath}/class/classCompleteList.do">수강 신청 완료 목록</a></li>
						<li><a href="${pageContext.request.contextPath}/member/delete.do">회원 탈퇴</a></li>
						<li><a href="${pageContext.request.contextPath}/main/main.do">홈으로</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</div>
