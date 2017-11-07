package com.awt.s01;

import java.awt.Frame;

public class FrameMain02 extends Frame{
	public FrameMain02() {
		//title
		super("Frame 테스트");
		//크기
		setSize(500,300);
		//노출 여부
		setVisible(true);
	}
	
	public static void main(String[] args) {
		FrameMain02 fm = new FrameMain02();
	}
}
