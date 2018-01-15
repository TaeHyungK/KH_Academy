package kr.spring.websocket.ws;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class ChatWebSocketHandler extends TextWebSocketHandler{

	private Map<String,WebSocketSession> users = new ConcurrentHashMap<String, WebSocketSession>();
	
	/*
	 *클라이언트와의 연결이 종료되면, 클라이언트에 해다하는 WebSocketSession을 users 맵에서 제거  
	 */
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		System.out.println(session.getId() + "연결 종료됨");
		//맴에서 연결 종료된  WebSocketSession를 제거
		users.remove(session.getId());
	}
	/*
	 *클라이언트와의 연결되면, 클라이언트에 관련된 WebSocketSession을 users 맵에 저장 
	 *이 users맵은 채팅 메시지를 연결된 전체 클라이언트에 전달할 때 사용
	 */
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.out.println(session.getId() + "연결됨");
		//맵에 WebSocketSession 저장
		users.put(session.getId(), session);
	}
	/*
	 *클라이언트가 전송한 메시지를 users 맴에 보관한 전체  WebSocketSession에 다시 전달.
	 *클라이언트는 메시지를 수신하면 채팅 영역에 보여주도록 구현,특정 클라이언트가 채팅 메시지를 서버에 보내면 전체
	 *클라이언트는 다시 그 메시지르 받아서 화면에 보여줌 
	 */
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		System.out.println(session.getId() + "로부터 메시지 수신 : " + message.getPayload());
		
		//맵에 저장된  WebSocketSession을 이용해 모든 클라이언트에 메시지 전송
		for(WebSocketSession s : users.values()) {
			//메시지 전송
			s.sendMessage(message);
			System.out.println(s.getId() + "에 메시지 발송 : " + message.getPayload());
		}
	}

	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		System.out.println(session.getId() + "예외 발생 : " + exception.getMessage());
	}

}
