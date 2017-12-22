$(document).ready(function(){
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
	function duData(){
		$.ajax({
			type:'post',
			data:{ap_num:$('input#ap_num').val()},
			url:'checkNum.do',
			dataType:'json',
			cache:false,
			timeout:10000,
			success:function(data){
				if(data.result=='numDu'){
					$('#not_pass').text('중복된 비행기명 입니다.');
					document.getElementById('du_submit').disabled=true;
				}else if(data.result=='success'){
					$('#not_pass').text('추가를 눌러주세요.');
					document.getElementById('du_submit').disabled='';
				}else if(data.result=='adminOnly'){
					alert('관리자 전용입니다.');
				}
			},
			error:function(){
				alert('네트워크 오류!');
			}
		});
	};
	$('#ap_num').keyup(function(){
		duData();
	});


});
