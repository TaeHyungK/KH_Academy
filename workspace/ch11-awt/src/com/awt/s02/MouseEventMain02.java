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
	Label move = new Label("���콺 ���� �ٴϱ�",Label.CENTER);
	Button exit = new Button("����");
	
	public MouseEventMain02() {
		super("MouseMotionListener �׽�Ʈ");
		
		//Borderlayout �̻��
		setLayout(null);
		
		//x,y,width,height ����
		move.setBounds(100, 50, 150, 20);
		exit.setBounds(250, 500, 50, 30);
		
		//Label�� ������ ���ڻ��� ����
		move.setForeground(Color.WHITE);
		move.setBackground(Color.RED);
		
		//Label, Button�� Frame�� ���
		add(move);
		add(exit);
		
		exit.addActionListener(this);
		//Frame��ü�� �����ʸ� �޾���.
		addMouseMotionListener(this);
		
		//x,y,width,height ����
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
		//���콺 Ŀ���� ��ǥ
		Point p = e.getPoint();
		//���콺 Ŀ���� ��ǥ�� Label�� ����
		move.setLocation(p);
		
	}
}
