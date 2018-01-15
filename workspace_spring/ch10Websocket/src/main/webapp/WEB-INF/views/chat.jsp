<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta  content="UTF-8">
<title>채팅</title>
<style type="text/css">
	#chatArea{
		width:300px;
		height:100px;
		overflow-y:auto;
		border:1px solid black;
	}
</style>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	var wsocket;
	//서버와 연결
	function connect(){
		wsocket = new WebSocket("ws://localhost:8080/ch10Websocket/chat-ws.do");
		//서버와 연결
		wsocket.onopen = function(){
			var msg = 'msg:['+$('#nickname').val()+'입장!]';
			wsocket.send(msg);
			
			//입장 버튼 비활성화
			$('#enterBtn').attr('disabled',true);
			//메시지 창 활성화
			$('#message').attr('disabled',false);
		};
		//서버에서 메시지 도착
		wsocket.onmessage = function(evt){
			var data = evt.data;
			if(data.substring(0,4) == 'msg:'){
				//전송된 데이터에 대한 UI처리
				$('#chatMessageArea').append(data.substring(4)+'<br>');
				var chatAreaHeight = $('#chatArea').height();
				var maxScroll = $('#chatMessageArea').height() - chatAreaHeight;
				$('#chatArea').scrollTop(maxScroll);
				
				
				//퇴장메시지이면서 자신이 퇴장하는 경우
				if(data.substring(5,data.lastIndexOf('퇴장!')) == $('#nickname').val() && data.lastIndexOf('퇴장!')!=-1){
					//서버와 연결 해제
					wsocket.close();
				}
			}
		};
		//서버와 연결 해제
		wsocket.onclose = function(evt){
			//퇴장 한 이후 부과적인 작업이 있을 경우 명시
			$('#nickname').val('');
			$('#message').attr('disabled',true);
			$('#enterBtn').attr('disabled',false);
		};
	}
	//채팅 중지 메시지 전송
	function disconnect(){
		var msg = 'msg:['+$('#nickname').val()+'퇴장!]';
		wsocket.send(msg);
	}
	//메시지 전송
	function send(){
		var nickname = $('#nickname').val();
		var msg = $('#message').val();
		wsocket.send('msg:' + nickname + ':' + msg);
		$('#message').val('');
	}
	
	$(document).ready(function(){
		$('#message').keypress(function(event){
			var keycode = (event.keyCode ? event.keyCode : event.which);
			if(keycode == '13'){
				send();
			}
			event.stopPropagation();
		});
		
		$('#sendBtn').click(function(){
			send();
		});
		
		$('#enterBtn').click(function(){
			if($('#nickname').val==''){
				alert('이름을 입력하세요!');
				$('#nickname').focus();
				return;
			}
			connect();
		});
		$('#exitBtn').click(function(){
			if($('#nicname').val()==''){
				alert('이름을 입력하세요!');
				$('#nickname').focus();
				return;
			}
			disconnect();
		});		
	});
	
</script>
</head>
<body>
	이름 : <input type="text" id="nickname">
	<input type="button" id="enterBtn" value="입장">
	<input type="button" id="exitBtn" value="나가기">
	<h1>대화 영역</h1>
	<div id="chatArea"><div id="chatMessageArea"></div></div>
	<br>
	<input type="text" id="message" disabled>
	<input type="button" id="sendBtn" value="전송">
</body>
</html>






