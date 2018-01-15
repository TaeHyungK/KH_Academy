package kr.spring.websocket.ws;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class EchoHandler extends TextWebSocketHandler{

	//웹소켓 클라이언트와 연결이 종료되면 호출
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		System.out.println(session.getId() + "연결 끊김");
	}
	//웹소켓 클라이어트와 연결되면 호출
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.out.println(session.getId() + "연결 됨");
	}
	//웹소켓 클라이언트가 데이터를 전송
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		System.out.println(session.getId() + "로부터 " + message.getPayload() + " 받음");
		//클라이언트에 메시지 전송
		session.sendMessage(new TextMessage("echo : " + message.getPayload()));
	}
	
}
