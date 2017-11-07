package com.awt.s02;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseEventmain01 extends Frame implements ActionListener, MouseListener {
	Panel p = new Panel();
	Button test = new Button("Test");
	Button exit = new Button("����");
	TextArea ta = new TextArea();

	public MouseEventmain01() {
		super("MouseEvent �׽�Ʈ");

		p.add(test);
		p.add(exit);

		// TextArea ��Ȱ��ȭ
		ta.setEditable(false);

		add(p, BorderLayout.SOUTH);
		add(ta, BorderLayout.CENTER);

		exit.addActionListener(this);
		test.addMouseListener(this);

		setBounds(300, 300, 300, 300);
		setVisible(true);

	}

	// ActionListener
	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);

	}

	// MouseListner
	
	//���콺�� Ư�� ������Ʈ�� Ŭ���� ��
	@Override
	public void mouseClicked(MouseEvent e) {
		ta.append("Mouse Click Event...\n");

	}

	//���콺�� Ư�� ������Ʈ�� ��~~���� ��
	@Override
	public void mousePressed(MouseEvent e) {
		ta.append("Mouse Press Event...\n");

	}

	//���콺�� Ư�� ������Ʈ�� �����ٰ� �� ��
	@Override
	public void mouseReleased(MouseEvent e) {
		ta.append("Mouse Release Event...\n");
	}

	//���콺�� Ư�� ������Ʈ�� ������ ��
	@Override
	public void mouseEntered(MouseEvent e) {
		ta.append("Mouse Enter Event...\n");
	}

	//���콺�� Ư�� ������Ʈ���� ���� �� ���� ��
	@Override
	public void mouseExited(MouseEvent e) {
		ta.append("Mouse Exit Event...\n");
	}

	public static void main(String[] args) {
		new MouseEventmain01();
	}
}
