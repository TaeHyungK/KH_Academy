$(document).ready(function(){
	var checkId = 0;
	//아이디 중복 체크
	$('#confirmId').click(function(){
		if($('#id').val()==''){
			alert('아이디를 입력하세요.');
			$('#id').focus();
			return;
		}
		$('#message_id').text();//메시지 초기화
		$('#loading').show();//로딩 이미지 노출
		
		$.ajax({
			url:'confirmId.do',
			type:'post',
			data:{id:$('#id').val()},
			dataType:'json',
			cache:false,
			timeout:30000,
			success:function(data){
				$('#loading').hide();
				if(data.result=='idNotFound'){
					$('#message_id').css('color','#000').text('등록가능 ID');
					checkId = 1;
				}else if(data.result=='idDuplicated'){
					$('#message_id').css('color','red').text('중복된 ID');
					$('#id').val('').focus();
					checkId = 0;
				}else{
					alert('ID 중복체크 오류');
				}
			},
			error:function(){
				$('#loading').hide();
				alert('네트워크 오류 발생');
				checkId = 0;
			}
		});
	});
	//아이디 중복 안내 메시지 초기화 및 아이디 중복 값 초기화
	$('#register_form #id').keyup(function(){
		checkId = 0;
		$('#message_id').text('');
	});
	//submit이벤트 발생시 아이디 중복 체크 여부 확인
	$('#register_form').submit(function(){
		if(checkId==0){
			alert('아이디 중복체크를 해주세요');
			if($('#id').val()==''){
				$('#id').focus();
				alert('아이디를 입력해 주세요');
			}else{
				$('#confirmId').focus();
			}
			return false;
		}
	});
});
























