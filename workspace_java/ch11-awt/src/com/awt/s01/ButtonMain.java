package com.awt.s01;

import java.awt.Button;
import java.awt.Frame;

public class ButtonMain extends Frame{
	public ButtonMain() {
		super("Button 테스트");
		setSize(300,300);
		setVisible(true);
		
		//Button 지정
		//버튼 내용
		Button b = new Button("확인");
		
		//Button을 Frame에 등록
		add(b);
	}
	
	public static void main(String[] args) {
		new ButtonMain();
	}
}
