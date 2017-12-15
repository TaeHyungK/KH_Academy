$(document).ready(function(){
	var count = 0;
	
	//아이디 중복 체크
	$('#id_check').click(function(){
		if($('#id').val()==''){
			alert('아이디를 입력하세요!');
			$('#id').focus();
			return;
		}
		
		$('#message_id').text('');//메시지 초기화
		$('#loading').show();//로딩 이미지 노출
		
		$.ajax({
			url:'checkId.do',
			type:'post',
			data:{id:$('#id').val()},
			dataType:'json',
			cache:false,
			timeout:30000,
			success:function(data){
				//로딩 이미지 감추기
				$('#loading').hide();
				
				if(data.result == 'idNotFound'){
					//id 미중복
					$('#message_id').css('color','#000')
					                .text('등록가능 ID');
					//아이디 중복 체크를 실행해서 중복
					//되지 않으면 count 값을 1로
					count = 1;
				}else if(data.result == 'idDuplicated'){
					$('#message_id').css('color','red')
					                .text('중복된 ID');
					$('#id').val('').focus();
					count = 0;
				}else{
					count = 0;
					alert('아이디 중복 체크 오류 발생');
				}
			},
			error:function(){
				//로딩 이미지 감추기
				$('#loading').hide();
				count = 0;
				alert('네트워크 오류 발생');
			}
		});
		
	});
	
	//아이디 중복 안내 메시지 초기화 및
	//아이디 중복 값 초기화
	$('#register_form #id').keyup(function(){
		count = 0;
		$('#message_id').text('');
	});
	
	//회원정보등록 유효성 체크
	$('#register_form').submit(function(){
		if($('#id').val()==''){
			alert('아이디를 입력하세요!');
			$('#id').focus();
			return false;
		}
		
		//아이디 중복 체크 실행 여부
		if(count==0){
			alert('아이디 중복 체크 필수!');
			$('#id_check').focus();
			return false;
		}
		
		if($('#name').val()==''){
			alert('이름을 입력하세요!');
			$('#name').focus();
			return false;
		}
		if($('#passwd').val()==''){
			alert('비밀번호를 입력하세요!');
			$('#passwd').focus();
			return false;
		}
		if($('#phone').val()==''){
			alert('전화번호를 입력하세요!');
			$('#phone').focus();
			return false;
		}
		if($('#email').val()==''){
			alert('이메일을 입력하세요!');
			$('#email').focus();
			return false;
		}
		if($('#zipcode').val()==''){
			alert('우편번호를 입력하세요!');
			$('#zipcode').focus();
			return false;
		}
		if($('#address1').val()==''){
			alert('주소를 입력하세요!');
			$('#address1').focus();
			return false;
		}
		
	});
	
});