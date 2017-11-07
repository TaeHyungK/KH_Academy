package com.network.s02;

import java.io.IOException;


//�������� Ŭ���̾�Ʈ�� ���۵� �����͸� UI�� ǥ���ϴ� �۾�
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
			
			if(receivedMsg[1].equals("exit")) {//ä�� ������ ���
				
				if(receivedMsg[0].equals(mc.getId())) {//������ �����ϴ� ���
					mc.exit();
				}else {//Ÿ���� �����ϴ� ���
					mc.getJta().append(receivedMsg[0] + "���� �����ϼ̽��ϴ�."+System.getProperty("line.separator"));
					//Ŀ���� ��ġ�� ����
					mc.getJta().setCaretPosition(mc.getJta().getDocument().getLength());
				}
			}else {//ä�� ������ ���
				mc.getJta().append(receivedMsg[0] + ": " + receivedMsg[1] + System.getProperty("line.separator"));
				//Ŀ���� ��ġ�� ����
				mc.getJta().setCaretPosition(mc.getJta().getDocument().getLength());
			}
		}
	}
	
	
}
