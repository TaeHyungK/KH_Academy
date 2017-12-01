$(document).ready(function(){
	var cound = 0;
	//아이디 중복 체크
	$('#id_check').click(function(){
		if($('#id').val()==''){
			alert('아이디를 입력하세요');
			$('#id').focus();
			return;
		}
		
		$('#message_id').text('');//메세지 초기화
		$('#loading').show();//로딩 이미지 노출
		
		$.ajax({
			url:'checkId.do',
			type:'post',
			data:{id:$('#id').val()},
			dataType:'json',
			cache:false,
			timeout:30000,
			success:function(data){
				$('#loading').hide();
				
				if(data.result == 'idNotFound'){
					//id미중복
					$('#message_id').css('color','#000')
									.text('등록가능 ID');
					//id 중복 체크를 실행해서 중복되지 않으면 count값을 1로 변경
					count = 1;
				}else if(data.result == 'idDuplicated'){
					$('#message_id').css('color', 'red')
									.text('중복된 ID');
					$('#id').val('').focus();
					count = 0;
				}else{
					count = 0;
					alert('아이디 중복 체크 오류 발생');
				}
			},
			error:function(){
				$('#loading').hide();
				count = 0;
				alert('네트워크 오류 발생');
			}
		});
	});
	
	//회원정보등록 유효성 체크
	$('#register_form').submit(function(){
		
		if($('#id').val()==''){
			alert('아이디를 입력하세요');
			$('#id').focus();
			return false;
		}
		if($('#name').val()==''){
			alert('이름을 입력하세요');
			$('#name').focus();
			return false;
		}
		if($('#passwd').val()==''){
			alert('비밀번호를 입력하세요');
			$('#passwd').focus();
			return false;
		}
		if($('#email').val()==''){
			alert('이메일를 입력하세요');
			$('#email').focus();
			return false;
		}
		if($('#zipcode').val()==''){
			alert('우편번호를 입력하세요');
			$('#zipcode').focus();
			return false;
		}
		if($('#address1').val()==''){
			alert('주소를 입력하세요');
			$('#address1').focus();
			return false;
		}
	});
	
	//로그인 유효성 체크
	$('#login_form').submit(function(){
		if($('#id').val()==''){
			alert('아이디를 입력하세요!');
			$('#id').focus();
			return false;
		}
		if($('#passwd').val()==''){
			alert('비밀번호를 입력하세요!');
			$('#passwd').focus();
			return false;
		}
	});
	
	//글 수정 유효성 체크
	$('#modify_form').submit(function(){
		if($('#name').val()==''){
			alert('이름을 입력하세요');
			$('#name').focus();
			return false;
		}
		if($('#passwd').val()==''){
			alert('비밀번호를 입력하세요!');
			$('#passwd').focus();
			return false;
		}
		if($('#passwd').val()==''){
			alert('비밀번호를 입력하세요');
			$('#passwd').focus();
			return false;
		}
		if($('#email').val()==''){
			alert('이메일를 입력하세요');
			$('#email').focus();
			return false;
		}
		if($('#zipcode').val()==''){
			alert('우편번호를 입력하세요');
			$('#zipcode').focus();
			return false;
		}
		if($('#address1').val()==''){
			alert('주소를 입력하세요');
			$('#address1').focus();
			return false;
		}		
	});
	
	//회원탈퇴 유효성 체크
	$('#delete_form').submit(function(){
		if($('#passwd').val()==''){
			alert('비밀번호를 입력하세요');
			$('#passwd').focus();
			return false;
		}
		if($('#cpasswd').val()==''){
			alert('비밀번호확인을 입력하세요');
			$('#cpasswd').focus();
			return false;
		}
		if($('#passwd').val() != $('#cpasswd').val()){
			alert('비밀번호와 비밀번호확인이 일치하지 않습니다');
			$('#cpasswd').val('').focus();
			return false;
		}
		
	});
});