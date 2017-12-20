$(document).ready(function(){
	var count = 0;
	
	$('#modify_form').submit(function(){
		if($('#name').val()==''){
			alert('이름을 입력하세요');
			$('#name').focus();
			return false;
		}
		if($('#phone').val()==''){
			alert('전화번호를 입력하세요');
			$('#phone').focus();
			return false;
		}
		if($('#card_num').val()==''){
			alert('카드번호를 입력하세요');
			$('#card_num').focus();
			return false;
		}
		
	});
});