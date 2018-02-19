/*=======================
* member.login.js
*========================*/
$(document).ready(function(){
    var web_url = "http://192.168.10.37:8080/cordovaReBoard";
    /*=======================
    * 로그인 여부 체크
    *========================*/
    $.ajax({
        url:web_url + '/member/loginCheckAjax.do',
        type:'post',
        dataType:'json',
        cache:false,
        timeout:30000,
        success:function(data){
            $('#main_menu').empty();
            $('#main_menu').append('<li><a href="../board/list.html">게시판</a></li>');
            if(data.result == 'success'){
                $('#main_menu').append('<li><a href="../member/modifyUserForm.html">회원정보수정</a></li>');
                $('#main_menu').append('<li><a href="../member/modifyPasswordForm.html">비밀번호수정</a></li>');
                $('#main_menu').append('<li><a href="../member/deleteUserForm.html">회원탈퇴</a></li>');
                $('#main_menu').append('<li><a href="#" id="log_out">로그아웃('+ data.id +'님 로그인 중)</a></li>');

                //게시판 글쓰기가 로그인되면 활성화 처리
                if($('#list_write') != 'undefined'){
                    $('#list_write').attr('disabled',false);
                }
                //게시판 상세글 수정, 삭제 로그인되면 활성화 처리
                if($('#board_modify_btn') != 'undefined'){
                    $('#board_modify_btn').attr('disabled',false);
                }
                if($('#board_delete_btn') != 'undefined'){
                    $('#board_delete_btn').attr('disabled',false);
                }
                //게시판 댓글 작성 로그인되면 활성화 처리
                if($('#userid') != 'undefined'){
                    $('#userid').val(data.id);
                }
                if($('#reply_content') != 'undefined'){
                    $('#reply_content').attr('readonly',false);
                    $('#reply_content').val('');
                }
                if($('#board_reply_notice') != 'undefined'){
                    $('#board_reply_notice').show();
                }

            }else if(data.result == 'failure'){
                $('#main_menu').append('<li><a href="../member/loginForm.html">로그인</a></li>');
                $('#main_menu').append('<li><a href="../member/registerUserForm.html">회원가입</a></li>');
            }else{
                $('#main_menu').append('<li><a href="../member/loginForm.html">로그인</a></li>');
                $('#main_menu').append('<li><a href="../member/registerUserForm.html">회원가입</a></li>');
                alert('로그인 체크 오류!');
            }
        },
        error:function(){
            alert('네트워크 연결이 원할하지 않습니다.');
        }
    });

    /*=======================
    * 로그인 체크
    *========================*/
    $('#login_form').submit(function(event){
        if($('#id').val() == ''){
            alert('아이디를 입력하세요.');
            $('#id').focus();
            return false;
        }
        if($('#passwd').val() == ''){
            alert('비밀번호를 입력하세요.');
            $('#passwd').focus();
            return false;
        }

        $.ajax({
            url:web_url + '/member/loginAjax.do',
            type:'post',
            data:$('#login_form').serialize(),
            dataType:'json',
            cache:false,
            timeout:30000,
            success:function(data){
                if(data.result == 'success'){
                    location.href='../main/main.html';
                }else if(data.result == 'failure'){
                    alert('아이디 혹은 패스워드가 일치하지 않습니다.');
                }
            },
            error:function(){
                alert('네트워크 연결이 원할하지 않습니다.')
            }
        });
        //기본 이벤트 제거
        event.preventDefault();
    });

    /*=======================
    * 로그아웃
    *========================*/
    $(document).on('click', '#log_out',function(event){
        $.ajax({
            url:web_url+'/member/logoutAjax.do',
            type:'post',
            dataType:'json',
            cache:false,
            timeout:30000,
            success:function(data){
                location.href='../main/main.html';
            },
            error:function(){
                alert('네트워크 연결이 원할하지 않습니다.')
            }
        });
    });
});






