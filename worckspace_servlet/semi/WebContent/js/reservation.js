$(document).ready(function(){
	/*var start_lo = document.getElementById('#start_lo');
	var end_lo = document.getElementById('#end_lo');
	var go_date = document.getElementById('#go_date');
	var return_date = document.getElementById('#return_date');
	var go_time = document.getElementById('#go_time');
	var return_time = document.getElementById('#return_time');
	var take_time = document.getElementById('#take_time');
	var ap_num = document.getElementById('#ap_num');
	var seats = document.getElementById('#seats');
*/	
	var seats = document.getElementById('#seats');
	
	$('.miForm').submit(function(){
	if($('input#start_lo').val()==''){
		alert('출발지를 입력해 주세요.');
		return false;
	}
	if($('#end_lo').val()==''){
		alert('돌아오는 여행지를 입력해 주세요.');
		return false;
	}
	if($('#go_date').val()==''){
		alert('출발 일짜를 입력해 주세요.');
		return false;
	}
	if($('#return_date').val()==''){
		alert('돌아오는 날을 입력해 주세요.');
		return false;
	}
	if($('#go_time').val()==''){
		alert('출발시간을 입력해 주세요.');
		return false;
	}
	if($('#return_time').val()==''){
		alert('돌아오는 시간 입력해 주세요.');
		return false;
	}
	if($('#take_time').val()==''){
		alert('걸릴는 시간을 입력해 주세요.');
		return false;
	}
	if($('#take_time').val()>100){
		alert('비행시간은 100시간보다 많이 걸릴 수 없습니다.');
		return false;
	}
	if($('#ap_num').val()==''){
		alert('비행기 번호를 입력해 주세요.');
		return false;
	}
	if($('#seats').val()==''){
		alert('좌석수를 입력해 주세요.');
		return false;
	}
	if($('#seats').val()<=0){
		alert('정확한 좌석수를 입력해 주세요.');
		return false;
	}
});
});




