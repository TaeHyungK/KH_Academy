$(document).ready(function(){
   //글 등록, 수정 유효성 체크
   $('#qboard_form,#qupdate_form').submit(function(){
      if($('#title').val()==''){
         alert('제목을 입력하세요');
         $('#title').focus();
         return false;
      }
      if($('#content').val()==''){
         alert('내용을 입력하세요');
         $('#content').focus();
         return false;
      }
   });
});   
   