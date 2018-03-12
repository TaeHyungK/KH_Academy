$(document).ready(function(){
	var checkId = 0;
	//아이디 중복 체크
	$('#confirmId').click(function(){
		if($('#m_id').val()==''){
			alert('아이디를 입력하세요.');
			$('#m_id').focus();
			return;
		}
		$('#message_id').text();//메시지 초기화
		$('#loading').show();//로딩 이미지 노출
		$.ajax({
			url:'confirmId.do',
			type:'post',
			data:{m_id:$('#m_id').val()},
			dataType:'json',
			cache:false,
			timeout:30000,
			success:function(data){
				console.log('retrn string : ' + data);
				$('#loading').hide();
				if(data.result=='idNotFound'){
					$('#message_id').css('color','#000').text('등록가능 ID');
					checkId = 1;
				}else if(data.result=='idDuplicated'){
					$('#message_id').css('color','red').text('중복된 ID');
					$('#m_id').val('').focus();
					checkId = 0;
				}else{
					alert('ID 중복체크 오류');
				}
			},
			error:function(){
				$('#loading').hide();
				alert('네트워크 오류 발생!@#');
				checkId = 0;
			}
		});
	});
	//아이디 중복 안내 메시지 초기화 및 아이디 중복 값 초기화
	$('#cform #m_id').keyup(function(){
		checkId = 0;
		$('#message_id').text('');
	});
	//submit이벤트 발생시 아이디 중복 체크 여부 확인
	$('#cform').submit(function(){
		if(checkId==0){
			alert('아이디 중복체크를 해주세요');
			if($('#m_id').val()==''){
				$('#m_id').focus();
			}else{
				$('#confirmId').focus();
			}
			return false;
		}
	});
});