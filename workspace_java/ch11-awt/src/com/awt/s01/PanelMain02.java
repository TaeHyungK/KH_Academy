package com.awt.s01;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;

public class PanelMain02 extends Frame {
	public PanelMain02() {
		super("Panel �׽�Ʈ2");
		
		//Frame�� �⺻������ ����Ǿ��ִ� BorderLayout�� ������� ������
		//Panel�� ���̿� ���̸� �����ϰ� ��ġ�� �����ؼ� ��ġ�ϴ� ���� ��������
		setLayout(null);
		
		
		Panel p = new Panel();
		//���� ����
		p.setBackground(Color.GREEN);
		//������ ����
		p.setSize(100,100);
		//��ġ ����
		p.setLocation(50, 50);
		
		Button okBtn = new Button("OK");
		//Button�� panel�� ���
		p.add(okBtn);
		//panel�� Frame�� ���
		add(p);
		
		setSize(300, 200);
		setVisible(true);
	
	}
	
	
	public static void main(String[] args) {
		new PanelMain02();
	}
}
