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
	var count = 0;
	function sumData(a_ticket,as_ticket,c_ticket){
	$.ajax({
		type:'post',
		url:'people.do',
		data:{a_ticket:a_ticket,as_ticket:as_ticket,c_ticket:c_ticket},
		dataType:'json',
		cache:false,
		timeout:10000,
		success:function(data){
			if(data.result =='idNotFound'){
				alert('로그인 해야 예약이 가능합니다.');
			}else if(data.result=='success'){
				$('.iNum').html('예약인원을 입력해 주세요.');
				count = 0;
			}else if(data.result=='exist'){
				$('.iNum').html('예약버튼을 눌러 주세요.');
				count = 1;
			}
		},error:function(){
			alert('네트워크 오류 발생');
		}
	});
	};
	a_ticket = $('.a_ticket').val();
	as_ticket = $('.as_ticket').val();
	c_ticket = $('.c_ticket').val();
	if(a_ticket==''){
		a_ticket=0;
	}
	if(as_ticket==''){
		as_ticket=0;
	}
	if(c_ticket==''){
		c_ticket=0;
	}

	sumData(a_ticket,as_ticket,c_ticket);
	$('input.a_ticket, input.as_ticket, input.c_ticket').on('keyup click',function(){
		$('.iNum').html('');
		a_ticket = $('.a_ticket').val();
		as_ticket = $('.as_ticket').val();
		c_ticket = $('.c_ticket').val();
		if(a_ticket==''){
			a_ticket=0;
		}
		if(as_ticket==''){
			as_ticket=0;
		}
		if(c_ticket==''){
			c_ticket=0;
		}
		sumData(a_ticket,as_ticket,c_ticket);
	});
	$(document).submit(function(){
		if(count<=0){
			alert('0명은 가입이 불가능 합니다');
			return false;
		}
	});
});




