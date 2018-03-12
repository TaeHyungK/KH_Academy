$(document).ready(function(){
	function likedClick(a_num){
    	
        alert(a_num);
        
		$.ajax({
			type:'post',
			data:{a_num:a_num},
			url:'likedAcademy.do',
			dataType:'json',
			cache:false,
			timeout:30000,
			success:function(data){
				if(data.result == 'success'){
					if($('#liked_icon').attr('class') == 'far fa-thumbs-up'){
						$('#liked_icon').attr('class', 'fas fa-thumbs-up');
					}else{
						$('#liked_icon').attr('class', 'far fa-thumbs-up');
					}
					
					$('#a_good').val(data.likedCount);
				}
			},
			error:function(){
				alert('네트워크 통신 오류!');
			}
		});
    	
	}
});
