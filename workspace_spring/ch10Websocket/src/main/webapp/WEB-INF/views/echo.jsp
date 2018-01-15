<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta  content="UTF-8">
<title>에코</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$('#sendBtn').click(function(){
			sendMessage();
		});
	});
	var wsocket;
	function sendMessage(){
		wsocket = new WebSocket("ws://localhost:8080/ch10Websocket/echo-ws.do");
		wsocket.onmessage = function(evt){
			//서버에서 전송된 데이터를 받음
			var data = evt.data;
			alert('서버에서 데이터 받음 : ' + data);
			//서버와의 연결 해제
			wsocket.close();
		};
		wsocket.onclose = function(evt){
			alert("연결 끊김");
		};
		wsocket.onopen = function(){
			//서버에 메시지 전송
			wsocket.send($("#message").val());
		};
	}
	
</script>
</head>
<body>
	<input type="text" id="message">
	<input type="button" id="sendBtn" value="전송">
</body>
</html>