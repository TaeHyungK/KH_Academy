package com.swing.s01;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JPanelMain extends JFrame{
	JButton button = new JButton("�α���");
	JPanel jp = new JPanel();
	
	public JPanelMain() {
		super("JPanel �׽�Ʈ");
		
		jp.add(button);
				
		add(jp);
				
		setBounds(300,300,300,300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	public static void main(String[] args) {
		//����� ������ ����
		JFrame.setDefaultLookAndFeelDecorated(true);
		
		new JPanelMain();
	}
}
