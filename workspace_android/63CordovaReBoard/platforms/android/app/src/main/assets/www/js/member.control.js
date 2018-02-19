/* ========================================================
 * member.control.js
 * ======================================================== */
$(document).ready(function(){
	var web_url = "http://192.168.10.37:8080/cordovaReBoard";
	var checkIdDuplicated=0;
	/* ========================================================================
	 * 아이디 중복 체크
	 * ======================================================================== */
	$('#id_check').click(function(){
		if($('#id').val()==''){
			alert('아이디를 입력하세요!');
			$('#id').focus();
			return;
		}
		
		$('#message_id').html('');
		$('#loading').show();
		
		$.ajax({
			url:web_url + '/member/confirmId.do',
			type:'post',
			data:{id:$('#id').val()},
			dataType:'json',
			cache:false,
			timeout:30000,
			success:function(data){
				$('#loading').hide();		
				
				if(data.result == 'idNotFound'){
					$('#message_id').css('color','#000000').text('등록 가능 ID');
					checkIdDuplicated = 1;
				}else if(data.result == 'idDuplicated'){
					$('#message_id').css('color','red').text('중복된 ID');
					$('#id').val('').focus();
					checkIdDuplicated = 0;
				}else{
					alert('아이디 중복 체크 오류 발생!');
				}
			},
			error:function(){
				$('#loading').hide();
				alert('네트워크 연결이 원할하지 않습니다!');
			}
		});
	});
	/* ========================================================================
	 * 아이디 중복 안내 메시지 초기화 및 아이디 중복 값 초기화
	 * ======================================================================== */
	$('#register_form #id').keyup(function(){
		checkIdDuplicated=0;
		$('#message_id').text('');
			
	});
	/* ========================================================================
	 * 회원 등록 유효성 체크
	 * ======================================================================== */
	$('#register_form').submit(function(event){
		if($('#id').val() == ''){
			alert('아이디를 입력하세요!');
			$('#id').focus();
			return false;
		}
		if($('#name').val() == ''){
			alert('이름을 입력하세요!');
			$('#name').focus();
			return false;
		}
		if($('#passwd').val() == ''){
			alert('비밀번호를 입력하세요!');
			$('#passwd').focus();
			return false;
		}
		if($('#phone').val() == ''){
			alert('전화번호를 입력하세요!');
			$('#phone').focus();
			return false;
		}
		if($('#email').val() == ''){
			alert('이메일을 입력하세요!');
			$('#email').focus();
			return false;
		}
		if($('#zipcode').val() == ''){
			alert('우편번호를 입력하세요!');
			$('#zipcode').focus();
			return false;
		}
		if($('#address1').val() == ''){
			alert('주소 입력하세요!');
			$('#address1').focus();
			return false;
		}
		
		if(checkIdDuplicated==0){
			alert('아이디 중복 체크 필수!');
			if($('#id').val()==''){				
				$('#id').focus();
			}else{
				$('#id_check').focus();
			}
			return false;
		}

		$.ajax({
			url:web_url + '/member/registerUserAjax.do',
			type:'post',
			data:$(this).serialize(),
			dataType:'json',
			cache:false,
			timeout:30000,
			success:function(data){
				alert('회원 등록을 완료했습니다!');
				location.href='../main/main.html';
			},
			error:function(){
				alert('네트워크 연결이 원할하지 않습니다!');
			}
		});
		event.preventDefault();
	});
	/* ======================================================================== */
});