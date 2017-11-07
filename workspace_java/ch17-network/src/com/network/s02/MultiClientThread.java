package com.network.s02;

import java.io.IOException;


//서버에서 클라이언트로 전송된 데이터를 UI에 표시하는 작업
public class MultiClientThread extends Thread{
	private MultiClient mc;
	
	public MultiClientThread(MultiClient mc) {
		this.mc = mc;
	}

	@Override
	public void run() {
		String message = null;
		String[] receivedMsg = null;
		boolean isStop = false;
		
		while(!isStop) {
			try {
				message = (String) mc.getOis().readObject();
				receivedMsg = message.split("#");
				
			} catch (Exception e) {
				e.printStackTrace();
				isStop = true;
			}
			
			System.out.println(receivedMsg[0] +", " +receivedMsg[1]);
			
			if(receivedMsg[1].equals("exit")) {//채팅 종료의 경우
				
				if(receivedMsg[0].equals(mc.getId())) {//본인이 종료하는 경우
					mc.exit();
				}else {//타인이 종료하는 경우
					mc.getJta().append(receivedMsg[0] + "님이 종료하셨습니다."+System.getProperty("line.separator"));
					//커서의 위치를 지정
					mc.getJta().setCaretPosition(mc.getJta().getDocument().getLength());
				}
			}else {//채팅 지속의 경우
				mc.getJta().append(receivedMsg[0] + ": " + receivedMsg[1] + System.getProperty("line.separator"));
				//커서의 위치를 지정
				mc.getJta().setCaretPosition(mc.getJta().getDocument().getLength());
			}
		}
	}
	
	
}
