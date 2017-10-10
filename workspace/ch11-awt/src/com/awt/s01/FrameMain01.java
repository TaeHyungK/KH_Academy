package com.awt.s01;

import java.awt.Frame;

public class FrameMain01 extends Frame{
	
	public FrameMain01() {
		//제목 설정
		super("Frame 테스트");
		//넓이, 높이 설정
		setSize(300,300);
		//Frame 노출 여부 지정
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new FrameMain01();
	}
}
