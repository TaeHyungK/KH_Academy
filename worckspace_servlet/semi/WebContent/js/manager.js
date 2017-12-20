$(document).ready(function(){
	var count = 0;
	
	$('#delete_form').submit(function(){
		if($('#passwd').val()==''){
			alert('비밀번호를 입력하세요');
			$('#passwd').focus();
			return false;
		}
		if($('#cpasswd').val()==''){
			alert('비밀번호 확인을 입력하세요');
			$('#cpasswd').focus();
			return false;
		}
		if($('#passwd').val()!=$('#cpasswd').val()){
			alert('비밀번호와 비밀번호 확인이 불일치합니다.');
			$('#cpasswd').val('').focus();
			return false;
		}
	});
	$('#update_form').submit(function(){
		if($('#passwd').val()==''){
			alert('비밀번호를 입력하세요');
			$('#passwd').focus();
			return false;
		}
		if($('#cpasswd').val()==''){
			alert('비밀번호 확인을 입력하세요');
			$('#cpasswd').focus();
			return false;
		}
		if($('#passwd').val()!=$('#cpasswd').val()){
			alert('비밀번호와 비밀번호 확인이 불일치합니다.');
			$('#cpasswd').val('').focus();
			return false;
		}
	});
});