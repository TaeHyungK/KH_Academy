$(document).ready(function(){
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
	

});