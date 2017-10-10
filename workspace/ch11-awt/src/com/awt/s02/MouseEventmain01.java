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
	Button exit = new Button("종료");
	TextArea ta = new TextArea();

	public MouseEventmain01() {
		super("MouseEvent 테스트");

		p.add(test);
		p.add(exit);

		// TextArea 비활성화
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
	
	//마우스가 특정 컨포넌트를 클릭할 때
	@Override
	public void mouseClicked(MouseEvent e) {
		ta.append("Mouse Click Event...\n");

	}

	//마우스가 특정 컨포넌트를 꾹~~누를 때
	@Override
	public void mousePressed(MouseEvent e) {
		ta.append("Mouse Press Event...\n");

	}

	//마우스가 특정 컨포넌트를 눌렀다가 뗄 때
	@Override
	public void mouseReleased(MouseEvent e) {
		ta.append("Mouse Release Event...\n");
	}

	//마우스가 특정 컨포넌트에 진입할 때
	@Override
	public void mouseEntered(MouseEvent e) {
		ta.append("Mouse Enter Event...\n");
	}

	//마우스가 특정 컨포넌트에서 진입 후 빠질 때
	@Override
	public void mouseExited(MouseEvent e) {
		ta.append("Mouse Exit Event...\n");
	}

	public static void main(String[] args) {
		new MouseEventmain01();
	}
}
