$(document).ready(function(){
	var currentPage;
	var count;
	var rowCount;
	//댓글 목록
	function selectData(pageNum,re_qnum){
		currentPage = pageNum;
		if(pageNum == 1){
			//처음 호출시는 해당 id의 div의 내부 내용물을 제거
			$('#output').empty();
		}
		
		$.ajax({
			type:'post',
			data:{pageNum:pageNum,re_qnum:re_qnum},
			url:'qlistReply.do',
			dataType:'json',
			cache:false,
			timeout:30000,
			success:function(data){
				
				count = data.count;
				rowCount = data.rowCount;
				var list = data.list;
				if(count<0 || list ==null){
					alert('목록호출시 오류발생');
				}else{
					$(list).each(function(index,item){
						var output = '<div class="item">';
						output += '<h4>'+item.id+'</h4>';
						output += '<div class="sub-item">';
						output += '<p>' + item.re_content + '</p>';
						output += item.re_date;
						//if($('#user_id').val() && $('#user_id').val()==item.id){
							//로그인한 아이디와 댓글 작성자 id 와 같은 경우
							output += '  <input type="button" value="수정" data-num="'+item.re_qnum+'" data-id="'+item.id+'" class="modify-btn">';
							output += '  <input type="button" value="삭제" data-num="'+item.re_qnum+'" data-id="'+item.id+'" class="delete-btn">';
						//}else{
							//로그인한 아이디와 댓글 작성자 id 와 다른경우
							//output += '  <input type="button" value="수정" disabled="disabled">';
							//output += '  <input type="button" value="삭제" disabled="disabled">';
						//}
						output += '<hr size="1" noshade>';
						output += '</div>';
						output += '</div>';
						
						//문서객체에 추가
						$('#output').append(output);
					});
					
				}
			},
			error:function(){
				alert('목록 호출시 네트워크 오류');
			}
		})
	}
	
	//댓글 등록
	$('#re_qform').submit(function(){
		if($('#re_content').val()==''){
			alert('내용을 입력하세요');
			$('#re_content').focus();
			return false;
		}
		
		//폼에 입력한 데이터를 key=value 형태로 반환
		var data = $(this).serialize();
		
		//등록
		$.ajax({
			type: 'post',
			data:data,
			url:'qwriteReply.do',
			dataType:'json',
			cache:false,
			timeout:3000,
			success:function(data){
				if(data.result=='logout'){
					alert('로그인해야 작성 가능');
				}else if(data.result=='success'){
					alert('등록 성공');
					//폼 초기화
					initForm();
					//댓글 작성이 성공하면 새로 삽입한 글을 포함해서 첫번째 페이지의 게시글을 다시 호출함
					selectData(1,$('#re_qnum').val());
					
				}else{
					alert('등록시 오류 발생');
				}
			},
			error:function(){
				alert('등록시 네트워크 오류 발생!');
			}
		});
		
		//기본 이벤트 제거
		event.preventDefault();
	});
	//댓글 작성 폼 초기화
	function initForm(){
		$('textarea').val('');
		$('#qre_first .letter-count').text('300/300');
	}
	
	
	//초기 데이터(목록) 호출
	selectData(1,$('#re_qnum').val());
});