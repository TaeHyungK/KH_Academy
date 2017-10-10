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
		super("�׸���");
		
		//DrawPanel��ü ����
		dp = new DrawPanel();
		
		//DrawPanel�� JFrame�� ���
		
		add(dp);
		dp.addMouseMotionListener(this);
		
		
		//JFrame�� ���� ����
		setBackground(Color.WHITE);
		
		setBounds(100,100,500,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	//�׸��� �׸� �� �ִ� Container ����
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
		//���콺 Ŀ���� ��ǥ
		x=e.getX()-3;
		y=e.getY()+8;
		//�ش� ��ǥ�� �׸� �׸���
		dp.repaint();
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
