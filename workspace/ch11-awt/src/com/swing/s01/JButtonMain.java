package com.swing.s01;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JButtonMain extends JFrame {
	JButton button = new JButton("�α���");
	
	public JButtonMain() {
		super("JButton �׽�Ʈ");
		
		add(button);
		
		setBounds(100,100,500,200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new JButtonMain();
	}
}
