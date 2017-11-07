package com.awt.s02;

import java.awt.Frame;
import java.awt.Label;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowEventMain extends Frame implements WindowListener{
	Label exit;

	public WindowEventMain() {
		super("WindowEvent 테스트");

		exit = new Label("프레임의 종료 버튼을 눌러주세요!");

		add(exit);

		setBounds(300,300,300,300);
		setVisible(true);

		addWindowListener(this);
	}

	public static void main(String[] args) {
		new WindowEventMain();
	}

	//열릴 때
	@Override
	public void windowOpened(WindowEvent e) {
	}
	//닫을 때
	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);

	}

	//닫힐 때
	@Override
	public void windowClosed(WindowEvent e) {

	}

	//아이콘화 되었을 때
	@Override
	public void windowIconified(WindowEvent e) {

	}

	//아이콘화가 해제되었을 때
	@Override
	public void windowDeiconified(WindowEvent e) {

	}

	//활성화 되었을 때
	@Override
	public void windowActivated(WindowEvent e) {

	}

	//비활성화 되었을 때
	@Override
	public void windowDeactivated(WindowEvent e) {

	}
}
