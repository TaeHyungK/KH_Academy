package com.awt.s01;

import java.awt.Button;
import java.awt.Frame;

public class ButtonMain extends Frame{
	public ButtonMain() {
		super("Button �׽�Ʈ");
		setSize(300,300);
		setVisible(true);
		
		//Button ����
		//��ư ����
		Button b = new Button("Ȯ��");
		
		//Button�� Frame�� ���
		add(b);
	}
	
	public static void main(String[] args) {
		new ButtonMain();
	}
}
