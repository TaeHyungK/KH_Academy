$(document).ready(function(){
   var currentPage;
   var count;
   var rowCount;
      
   //댓글 목록
   function selectData(pageNum,q_num){
      currentPage = pageNum;
      if(pageNum == 1){
         //처음 호출시는 해당 id의 div의 내부 내용물을 제거
         $('#output').empty();
      }
      
      $.ajax({
         type:'post',
         data:{pageNum:pageNum,q_num:q_num},
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
                  output += '<hr size="5" width="75%" color="white" noshade>';
                  output += '<h4>'+item.q_id+'</h4>';
                  output += '<div class="sub-item">';
                  output += '<p>' + item.re_content + '</p>';
                  output += item.re_date;
                  
                     output += '<c:if test="${user_id!=null}">'
                     output += '  <input type="button" value="삭제" data-num="'+item.re_qnum+'" data-id="'+item.q_id+'" class="delete-btn">';
                      output += '</c:if>'
                     
                  output += '<hr size="5" width="75%" color="white" noshade>';
                  output += '</div>';
                  output += '</div>';
                  
                  //문서객체에 추가
                  $('#output').append(output);
               });
               
            }
         },
         error:function(){
            alert('로그인 오류');
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
               selectData(1,$('#q_num').val());
               
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
   }
   
   
   //댓글 수정 버튼 클릭시 수정 폼 노출
   $(document).on('click','.modify-btn',function(){
      //댓글 글번호 
      var num = $(this).attr('data-num');
      //작성자 아이디
      var id = $(this).attr('data-id');
      //댓글 내용
      var content = $(this).parent().find('p').html();
      //댓글 수정 폼 UI
      var modifyUI = '<form id="mre_form">';
         modifyUI += '  <input type="hidden" name="re_num" id="mre_num" value="'+num+'">';
         modifyUI += '  <input type="hidden" name="id" id="muser_id" value="'+id+'">';
         modifyUI += '  <textarea rows="3" cols="50" name="re_content" id="mre_content" style="resize:none;" class="rep-content">'+content+'</textarea>';
         modifyUI += '  <div id="mre_second" class="align-right">';
         modifyUI += '    <input type="submit" value="수정">';
         modifyUI += '    <input type="button" value="취소" class="re-reset">';
         modifyUI += '  </div>';
         modifyUI += '   <hr size="1" noshade width="90%">';   
         modifyUI += '</form>';
         
         //이전에 이미 수정하는 댓글이 있을 경우 수정버튼을 클릭하면 sub-item을 화원시키고
         //수정폼을 초기화함
         initModifyForm();
         
         //지금 클릭해서 수정하고자 하는 데이터는 감추기
         //수정 버튼을 감싸고 있는 div
         $(this).parent().hide();
         
         //수정 폼을 수정하고자 하는 데이터가 있는 div에 노출
         $(this).parents('.item').append(modifyUI);
        
         
         
   });
   //수정폼에서 취소 버튼 글릭시 수정폼 초기화
   $(document).on('click','.re-reset',function(){
      initModifyForm();
   });
   //댓글 수정 폼 초기화
   function initModifyForm(){
      $('.sub-item').show();
      $('#mre_form').remove();
   }
   //댓글 수정
   $(document).on('submit','#mre_form',function(event){
      if($('#mre_content').val()==''){
         alert('내용을 입력하세요');
         $('#mre_content').focus();
         return false;
      }
      
      //폼에 입력한 데이터를 반환
      var data = $(this).serialize();
      //수정
      $.ajax({
         type:'post',
         data:data,
         url:'qupdateReply.do',
         dataType:'json',
         cache:false,
         timeout:30000,
         success:function(data){
            if(data.result=='logout'){
               alert('로그인해야 수정할수 있음');
            }else if(data.result=='success'){
               $('#mre_form').parent().find('p').html($('#mre_content').val());
               //수정폼 초기화
               initModifyForm();
            }else if(data.result == 'wrongAccess'){
               alert('타인의 글을 수정할수 없습니다');
            }else{
               alert('수정시 오류발생');
            }
         },
         error:function(){
            alert('댓글 수정시 네트워크 오류');
         }
      });
      //기본 이벤트 제거
      event.preventDefault();
   });
   //댓글 삭제
   $(document).on('click','.delete-btn',function(){
      //댓글 번호
      var data_num = $(this).attr('data-num');
      //작성자 id
      var id = $(this).attr('data-id');
      
      $.ajax({
         type:'post',
         data:{re_qnum:data_num,id:id},
         url:'qdeleteReply.do',
         dataType:'json',
         cache:false,
         timeout:30000,
         success:function(data){
            if(data.result =='logout'){
               alert('로그인해야 삭제 가능');
            }else if(data.result =='success'){
               alert('삭제 완료');
               //목록 갱신
               selectData(1,$('#q_num').val());
            }else if(data.result == 'wrongAccess'){
               alert('타인의 글을 삭제 할수 없습니다')
            }else{
               alert('삭제 오류')
            }
         },
         error:function(){
            alert('삭제시 네트워크오류 발생')
         }
      })
      
   })
   
   //초기 데이터(목록) 호출
   selectData(1,$('#q_num').val());
});