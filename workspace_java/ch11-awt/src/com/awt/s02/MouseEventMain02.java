package com.awt.s02;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseEventMain02 extends Frame implements ActionListener, MouseMotionListener{
	Label move = new Label("마우스 따라 다니기",Label.CENTER);
	Button exit = new Button("종료");
	
	public MouseEventMain02() {
		super("MouseMotionListener 테스트");
		
		//Borderlayout 미사용
		setLayout(null);
		
		//x,y,width,height 지정
		move.setBounds(100, 50, 150, 20);
		exit.setBounds(250, 500, 50, 30);
		
		//Label의 배경색과 글자색을 지정
		move.setForeground(Color.WHITE);
		move.setBackground(Color.RED);
		
		//Label, Button을 Frame에 등록
		add(move);
		add(exit);
		
		exit.addActionListener(this);
		//Frame전체에 리스너를 달아줌.
		addMouseMotionListener(this);
		
		//x,y,width,height 지정
		setBounds(300, 100, 500, 600);
		setVisible(true);
		
		
	}
	
	//Main
	public static void main(String[] args) {
		new MouseEventMain02();
	}

	//ActionListner
	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
		
	}


	//MouseMotionListner
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		//마우스 커서의 좌표
		Point p = e.getPoint();
		//마우스 커서의 좌표를 Label에 적용
		move.setLocation(p);
		
	}
}
