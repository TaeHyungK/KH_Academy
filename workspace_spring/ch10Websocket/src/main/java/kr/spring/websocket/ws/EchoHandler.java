package kr.spring.websocket.ws;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class EchoHandler extends TextWebSocketHandler{

	//������ Ŭ���̾�Ʈ�� ������ ����Ǹ� ȣ��
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		System.out.println(session.getId() + "���� ����");
	}
	//������ Ŭ���̾�Ʈ�� ����Ǹ� ȣ��
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.out.println(session.getId() + "���� ��");
	}
	//������ Ŭ���̾�Ʈ�� �����͸� ����
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		System.out.println(session.getId() + "�κ��� " + message.getPayload() + " ����");
		//Ŭ���̾�Ʈ�� �޽��� ����
		session.sendMessage(new TextMessage("echo : " + message.getPayload()));
	}
	
}
