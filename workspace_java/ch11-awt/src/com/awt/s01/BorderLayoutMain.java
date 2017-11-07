package com.awt.s01;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;

public class BorderLayoutMain extends Frame {
	public BorderLayoutMain() {
		super("BorderLayout 테스트");
		
		//Panel 생성
		Panel p = new Panel();
		
		//버튼 생성
		Button north = new Button("North");
		Button south = new Button("south");
		Button east = new Button("east");
		Button west = new Button("west");
		Button center = new Button("center");
		
		//Button을 Panel에 등록
		p.add(center);
		
		//Button을 Frame에 등록
		add(north, BorderLayout.NORTH);
		add(south, BorderLayout.SOUTH);
		add(east, BorderLayout.EAST);
		add(west, BorderLayout.WEST);
		//Panel을 Frame에 등록
		add(p, BorderLayout.CENTER);
		
		//크기 지정
		setSize(200,200);
		//
		setVisible(true);
		
		
	}
	
	public static void main(String[] args) {
		new BorderLayoutMain();
	}
}
