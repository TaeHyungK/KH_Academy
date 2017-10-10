package com.awt.s01;

import java.awt.Frame;
import java.awt.Button;
import java.awt.Color;
import java.awt.Panel;

public class PanelMain extends Frame{
	public PanelMain() {
		super("Panel 테스트");
		
		Panel p = new Panel();
		Button okBtn = new Button("OK");

		//Button을 panel에 등록
		p.add(okBtn);
		//panel을 Frame에 등록
		add(p);
		

		setSize(300, 200);
		setVisible(true);
		
		
		
	}
	
	public static void main(String[] args) {
		new PanelMain();
	}
}
