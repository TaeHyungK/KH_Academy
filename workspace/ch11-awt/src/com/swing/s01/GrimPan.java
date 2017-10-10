package com.swing.s01;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GrimPan extends JFrame implements MouseMotionListener{
	int x= 0;
	int y= 0;
	DrawPanel dp;
	
	public GrimPan() {
		super("그림판");
		
		//DrawPanel객체 생성
		dp = new DrawPanel();
		
		//DrawPanel을 JFrame에 등록
		
		add(dp);
		dp.addMouseMotionListener(this);
		
		
		//JFrame에 배경색 지정
		setBackground(Color.WHITE);
		
		setBounds(100,100,500,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	//그림을 그릴 수 있는 Container 정의
	class DrawPanel extends JPanel{

		@Override
		public void paint(Graphics g) {
			g.drawString("*", x, y);
		}
		
	}
	
	public static void main(String[] args) {
		new GrimPan();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		//마우스 커서의 좌표
		x=e.getX()-3;
		y=e.getY()+8;
		//해당 좌표에 그림 그리기
		dp.repaint();
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
