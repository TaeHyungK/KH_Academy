package com.awt.s01;

import java.awt.Frame;
import java.awt.Button;
import java.awt.Color;
import java.awt.Panel;

public class PanelMain extends Frame{
	public PanelMain() {
		super("Panel �׽�Ʈ");
		
		Panel p = new Panel();
		Button okBtn = new Button("OK");

		//Button�� panel�� ���
		p.add(okBtn);
		//panel�� Frame�� ���
		add(p);
		

		setSize(300, 200);
		setVisible(true);
		
		
		
	}
	
	public static void main(String[] args) {
		new PanelMain();
	}
}
