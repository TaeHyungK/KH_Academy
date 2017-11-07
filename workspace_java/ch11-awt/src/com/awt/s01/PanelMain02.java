package com.awt.s01;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;

public class PanelMain02 extends Frame {
	public PanelMain02() {
		super("Panel 테스트2");
		
		//Frame에 기본적으로 적용되어있는 BorderLayout을 사용하지 않으면
		//Panel의 넓이와 높이를 지정하고 위치를 지정해서 배치하는 것이 가능해짐
		setLayout(null);
		
		
		Panel p = new Panel();
		//배경색 지정
		p.setBackground(Color.GREEN);
		//사이즈 지정
		p.setSize(100,100);
		//위치 지정
		p.setLocation(50, 50);
		
		Button okBtn = new Button("OK");
		//Button을 panel에 등록
		p.add(okBtn);
		//panel을 Frame에 등록
		add(p);
		
		setSize(300, 200);
		setVisible(true);
	
	}
	
	
	public static void main(String[] args) {
		new PanelMain02();
	}
}
