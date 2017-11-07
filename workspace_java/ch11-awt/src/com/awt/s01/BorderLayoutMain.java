package com.awt.s01;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;

public class BorderLayoutMain extends Frame {
	public BorderLayoutMain() {
		super("BorderLayout �׽�Ʈ");
		
		//Panel ����
		Panel p = new Panel();
		
		//��ư ����
		Button north = new Button("North");
		Button south = new Button("south");
		Button east = new Button("east");
		Button west = new Button("west");
		Button center = new Button("center");
		
		//Button�� Panel�� ���
		p.add(center);
		
		//Button�� Frame�� ���
		add(north, BorderLayout.NORTH);
		add(south, BorderLayout.SOUTH);
		add(east, BorderLayout.EAST);
		add(west, BorderLayout.WEST);
		//Panel�� Frame�� ���
		add(p, BorderLayout.CENTER);
		
		//ũ�� ����
		setSize(200,200);
		//
		setVisible(true);
		
		
	}
	
	public static void main(String[] args) {
		new BorderLayoutMain();
	}
}
