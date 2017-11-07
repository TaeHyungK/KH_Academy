package com.swing.s01;

import javax.swing.JFrame;

public class JFrameMain extends JFrame{
	public JFrameMain() {
		//제목 설정
		super("JFrame 테스트");
		
		
		//x,y,width,height 지정
		setBounds(100,100,500,200);
		//Frame 노출 여부 지정
		setVisible(true);
		//윈도우의 x버튼 종료 처리
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new JFrameMain();
	}
}
