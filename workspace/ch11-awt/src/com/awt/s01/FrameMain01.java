package com.awt.s01;

import java.awt.Frame;

public class FrameMain01 extends Frame{
	
	public FrameMain01() {
		//���� ����
		super("Frame �׽�Ʈ");
		//����, ���� ����
		setSize(300,300);
		//Frame ���� ���� ����
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new FrameMain01();
	}
}
