$(document).ready(function(){
   var currentPage;
   var count;
   var rowCount;
   
   //댓글 목록
   function selectData(pageNum,ib_num){
      currentPage = pageNum;
      
      if(pageNum==1){
         //처음 호출시는 해당 ID의 div의 내부 내용물을 제거
         $('#output').empty();
      }
   
   //로딩 이미지 노출
   $('#loading').show();
   
   $.ajax({
      type:'post',
      data:{pageNum:pageNum,ib_num:ib_num},
      dataType:'json',
      url:'listReply.do',
      cache:false,
      timeout:10000,
      success:function(data){
         
         $('#loading').hide();
         
         count = data.count;
         rowCount = data.rowCount;
         var list = data.list;
         
         if(count<0 || list==null){
            alert('목록 호출 오류 발생');
         }else{
            $(list).each(function(index,item){
               var output = '<div class="item">';
               output += ' <h4>'+item.m_id+'</h4>';
               output += '    <div class="sub-item" align="right">';
               
               //하나만 바꿔주는데 /값/g를 사용하면 전체 검색을 하고 i는 대소문자 구분 안함
               output += '   <p align="left">' + item.ic_content.replace(/</gi,'&lt;').replace(/>/gi,'&gt;') + '</p>';
               output += '   <div align="left">' + item.ic_regdate + '</div>';
               if($('#user_id').val()==item.m_id){
                  output += ' <input type="button" data-num="'+item.if_num+'" data-id="'+item.m_id+'" value="수정" class="btn btn-primary modify-btn">';
                  output += ' <input type="button" data-num="'+item.if_num+'" data-id="'+item.m_id+'" value="삭제" class="btn btn-primary delete-btn">';
               }
               output += '     <hr size="1" noshade>';
               output += '  </div>';
               output += '</div>';
               
               //문서 객체에 추가
               $('#output').append(output);
            });
               //paging button 처리
               if(currentPage >=Math.ceil(count/rowCount)){
                  //다음 페이지가 없음
                  $('.paging-button').hide();
               }else{
                  //다음 페이지가 존재
                  $('.paging-button').show();
               }
         }
      },
      error:function(){
         //로딩 이미지 감추기
         $('#loading').hide();
         alert('네트워크 오류');
      }
   });
   }
   //다음 댓글 보기 버튼 클릭시 데이터 추가
   $('.paging-button input').click(function(){
      var pageNum = currentPage + 1;
      selectData(pageNum,$('#ib_num').val());
   });
   
   //댓글 등록
   $('#re_form').submit(function(event){
      if($('#ic_content').val()==''){
         alert('내용 입력 해주세요');
         $('#ic_content').focus();
         return false;
      }
      
      var data = $(this).serialize();
      
      //등록
      $.ajax({
         type:'post',
         data:data,
         url:'writeReply.do',
         dataType:'json',
         cache:false,
         timeout:10000,
         success:function(data){
            if(data.result=='logout'){
               alert('로그인 시에만 작성 가능 합니다.');
            }else if(data.result=='success'){
               //폼초기화
               initForm();
               //댓글 작성이 성공하면 새로 삽입한 글을 포함해서 첫번째 페이지의 게시글들을 다시 호출
               selectData(1,$('#ib_num').val());
            }else{
               alert('등록시 오류 발생');
            }
         },
         error:function(){
            alert('네트워크 오류');
         }
      });
      //기본 이벤트 제거
      event.preventDefault();
   });
   //댓글 작성 폼 초기화
   function initForm(){
      $('textarea').val('');
      $('#re_first .letter-count').text('300/300');
   }
   
   //textarea에 내용 입력시 글자수 체크
   $(document).on('keyup','textarea',function(){
      //남은 글자수를 구함
      var inputLength = $(this).val().length;
      
      if(inputLength>300){
         $(this).val($(this).val().substring(0,300));
      }else{
         //300자 이하인 경우
         var remain = 300 - inputLength;
         remain += '/300';
         if($(this).attr('m_id')=='ic_content'){
            //등록 폼 글자수
            $('#re_first .letter-count').text(remain);
         }else{
            //수정 폼 글자수
            $('#mre_first .letter-count').text(remain);
         }
      }
   });
   
   //댓글 수정 버튼 클릭시 수정폼 노출
   $(document).on('click','.modify-btn',function(){
      //댓글 번호
      var if_num = $(this).attr('data-num');
      //회원 아이디
      var m_id = $(this).attr('data-id');
      //댓글 내용
      var ic_content = $(this).parent().find('p').html();
      
      //댓글 수정폼 UI
      var modifyUI = '<form id="mre_form">';
      modifyUI += '<input type="hidden" name="if_num" id="if_num" value="'+if_num+'">';
      modifyUI += '<input type="hidden" name="m_id" id="m_id" value="'+m_id+'">';
      modifyUI += '<textarea rows="3" cols="106" name="ic_content" id="mre_content" class="rep-content">'+ic_content+'</textarea>';
      modifyUI += '<div id="mre_first"><span class="letter-count">300/300</span></div>';
      modifyUI += '<div id="mre_second" class="align-right">';
      modifyUI += '<p align="right"><input type="submit" value="확인" class="btn btn-primary">      ';
      modifyUI += '<input type="button" value="취소" class="btn btn-primary re-reset"></p>';
      modifyUI += '</div>';
      modifyUI += '</form>';
      
      //이전에 이미 수정하는 댓글이 있을 경우 수정 버튼을 클릭하면  숨김 sub-item을 환원시키고  수정폼을 초기화
      initModifyForm();
      
      //지금 클릭해서 수정하고자 하는 데이터는 감추기
      $(this).parent().hide();
      
      //수정폼을 수정하고자 하는 데이터가 있는 div에 노출
      $(this).parents('.item').append(modifyUI);
      
      //입력한 글자수 셋팅
      var inputLength = $('#ic_content').val().length;
      var remain = 300 - inputLength;
      remain += '/300';
      
      //문서 객체에 반영
      $('#mre_first .letter-count').text(remain);
   });
   
   //수정 폼에서 취소 버튼 클릭시 수정폼 초기화
   $(document).on('click','.re-reset',function(){
      initModifyForm();
   });
   
   //댓글 수정 폼 초기화
   function initModifyForm(){
      $('.sub-item').show();
      $('#mre_form').remove();//empty -> 자신의 하위 영역을 지움
   }
   
   //댓글 수정
   $(document).on('submit','#mre_form',function(event){
      if($('#mre_content').val()==''){
         alert('내용을 입력하세요');
         $('#mre_content').focus();
         return false;
      }
      //폼에 입력한 데이터 반환
      var data = $(this).serialize();
      
      $.ajax({
         type:'post',
         dataType:'json',
         url:'updateReply.do',
         data:data,
         cache:false,
         timeout:10000,
         success:function(data){
            if(data.result == 'logout'){
               alert('로그인이 필요한 서비스입니다.');
            }else if(data.result == 'success'){
               $('#mre_form').parent().find('p').html($('#mre_content').val().replace(/</gi,'&lt;').replace(/>/gi,'&gt;'));
               initModifyForm();
            }else if(data.result=='wrongAccess'){
               alert('타인의 글은 수정 불가능 합니다.');
            }else{
               alert('오류 발생');
            }
         },
         error:function(){
            alert('네트워크 오류!');
         }
      });
      //기본 이벤트 제거
      event.preventDefault();
   });

   //댓글 삭제
   $(document).on('click','.delete-btn',function(){
      //댓글 번호
      var if_num = $(this).attr('data-num');
      //작성자 아이디
      var m_id = $(this).attr('data-id');
      
      $.ajax({
         type:'post',
         data:{if_num:if_num,m_id:m_id},
         dataType:'json',
         url:'deleteReply.do',
         cache:false,
         timeout:10000,
         success:function(data){
            if(data.result=='logout'){
               alert('로그인을 먼저 실행해 주세요');
            }else if(data.result=='success'){
               alert('삭제 되었습니다.');
               selectData(1,$('#ib_num').val());
            }else if(data.result=='wrongAccess'){
               alert('타인의 글을 삭제할 수 없습니다.');
            }else{
               alert('에러 발생');
            }
         },
         error:function(){
            alert('네트워크 오류');
         }
      });
   });
   
   //초기 데이터(목록)호출
   selectData(1,$('#ib_num').val());
});





















