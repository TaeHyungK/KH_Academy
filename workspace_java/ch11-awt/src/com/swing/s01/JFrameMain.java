package com.swing.s01;

import javax.swing.JFrame;

public class JFrameMain extends JFrame{
	public JFrameMain() {
		//���� ����
		super("JFrame �׽�Ʈ");
		
		
		//x,y,width,height ����
		setBounds(100,100,500,200);
		//Frame ���� ���� ����
		setVisible(true);
		//�������� x��ư ���� ó��
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new JFrameMain();
	}
}
