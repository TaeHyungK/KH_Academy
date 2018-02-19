/* ========================================================================
 * board.list.js
 * ======================================================================== */
$(document).ready(function(){
    var web_url = "http://192.168.10.37:8080/cordovaReBoard";
    /* ========================================================================
	 * 글 목록 처리
	 * ======================================================================== */
	 var currentPage;
	 var count;
	 var rowCount;
	 var pageCount;
	 var searchData = '';
     function selectData(pageNum){
		currentPage = pageNum;

		$('#output').empty();

		var param;
		if(searchData != ''){
			param = searchData+'&pageNum='+pageNum
		}else{
			param = {pageNum:pageNum};
		}

		$('#loading').show();
		$.ajax({
			url:web_url + '/board/listAjax.do',
			type:'post',
			data:param,
			dataType:'json',
			cache:false,
			timeout:30000,
			success:function(data){
				$('#loading').hide();

				createPage(data);
			},
			error:function(){
				$('#loading').hide();
			}
		});
	}
    /* ========================================================================
	 * 사용자 목록 화면 처리
	 * ======================================================================== */
	function createPage(data){
		$('#loading').hide();

		count = data.count;
		rowCount = data.rowCount;
		pageCount = data.pageCount;

		var list = data.list;

		if(count == -1 || list == null){
			alert('목록 호출 오류 발생');
		}else{
			$('#output_first').show();
			$(list).each(function(index,item){
				var output = '';
				output += '<tr>';
				if(item.subfilename != null){
					output += '<td class="board-detail-link" data-link="detail.html#'+ item.num +'"><img src="' + web_url + '/upload/'+item.subfilename + '" style="float:left;"><span style="margin-left:10px">' + item.title + '</span> <span class="badge">' + item.reply_cnt + '</span><br><span style="margin-left:10px">' + item.id + '(' + item.regdate +')</span></td>';
				}else{
					output += '<td class="board-detail-link" data-link="detail.html#'+ item.num +'">' + item.title + ' <span class="badge">' + item.reply_cnt + '</span><br>' + item.id + '(' + item.regdate +')</td>';
				}
				output += '</tr>';

				//문서 객체에 추가
				$('#output').append(output);
			});
			//페이징 처리 함수 호출
			setPaging();
		}
	}
	/* ========================================================================
	 * 페이징 처리
	 * ======================================================================== */
	var totalPage;
	function setPaging(){
		//문서 객체 초기화
		$('.paging_button').empty();
		if(count == 0) return;

		totalPage = Math.ceil(count/rowCount);
		if(currentPage == undefined || currentPage == ''){
			currentPage = 1;
		}

		//현재 페이지가 전체 페이지 수보다 크면 전체 페이지 수로 설정
		if(currentPage > totalPage){
			currentPage = totalPage;
		}

		//시작 페이지와 마지막 페이지 값 구하기
		var startPage = Math.floor((currentPage-1)/pageCount)*pageCount + 1;
		var endPage = startPage + pageCount - 1;

		//마지막 페이지가 전체 페이지 수보다 크면 전체 페이지 수로 설정
		if(endPage > totalPage){
			endPage = totalPage;
		}
		var add;

		if(startPage > pageCount){
			add = $('<li></li>').html('<a>[이전]</a>').css({color:'black',cursor:'pointer'})
											  .attr({'data-page':startPage-1,'data-search':searchData});
			$('.paging_button').append(add);
		}

		for(var i=startPage;i<=endPage;i++){
			if(currentPage == i){
				add = $('<li class="active"></li>').html('<span>'+i+'<span class="sr-only">(current)</span></span>').css({color:'red',cursor:'default'})
												   .attr({'data-page':i,'data-search':searchData});
			}else{
				add = $('<li></li>').html('<a>'+i+'</a>').css({color:'black',cursor:'pointer'})
											.attr({'data-page':i,'data-search':searchData});
			}
			$('.paging_button').append(add);
		}

		if(endPage < totalPage){
			add = $('<li></li>').html('<a>[다음]</a>').css({color:'black',cursor:'pointer'})
											  .attr({'data-page':endPage + 1,'data-search':searchData});
			$('.paging_button').append(add);
		}
	}
	/* ========================================================================
	 * 페이지 버튼 이벤트 연결
	 * ======================================================================== */
	 $(document).on('click','.paging_button li',function(){
		var pageNum = $(this).attr('data-page');
		searchData = $(this).attr('data-search');

		if(currentPage != pageNum){
			selectData(pageNum);
		}
	});
	/* ========================================================================
	 * 작성 글 검색 유효성 체크
	 * ======================================================================== */
	$('#search_form').submit(function(event){
		if($('#keyword').val() == ''){
			alert('검색어를 입력하세요!');
			$('#keyword').focus();
			return false;
		}
		searchData = $('#search_form').serialize();
        selectData(1);
		event.preventDefault();
	});
    /* ========================================================================
     * 글 상세 이벤트
     * ======================================================================== */
    $(document).on('click','.board-detail-link',function(){
        var link = $(this).attr('data-link');
        location.href= link;
    });
	/* ========================================================================
	 * 초기 화면에 데이터(목록) 표시
	 * ======================================================================== */
	selectData(1);
	/* ======================================================================== */
});