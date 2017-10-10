package com.awt.s02;

import java.awt.Frame;
import java.awt.Label;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowEventMain extends Frame implements WindowListener{
	Label exit;

	public WindowEventMain() {
		super("WindowEvent �׽�Ʈ");

		exit = new Label("�������� ���� ��ư�� �����ּ���!");

		add(exit);

		setBounds(300,300,300,300);
		setVisible(true);

		addWindowListener(this);
	}

	public static void main(String[] args) {
		new WindowEventMain();
	}

	//���� ��
	@Override
	public void windowOpened(WindowEvent e) {
	}
	//���� ��
	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);

	}

	//���� ��
	@Override
	public void windowClosed(WindowEvent e) {

	}

	//������ȭ �Ǿ��� ��
	@Override
	public void windowIconified(WindowEvent e) {

	}

	//������ȭ�� �����Ǿ��� ��
	@Override
	public void windowDeiconified(WindowEvent e) {

	}

	//Ȱ��ȭ �Ǿ��� ��
	@Override
	public void windowActivated(WindowEvent e) {

	}

	//��Ȱ��ȭ �Ǿ��� ��
	@Override
	public void windowDeactivated(WindowEvent e) {

	}
}
