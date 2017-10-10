package com.awt.s02;

import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyEventMain extends Frame implements KeyListener{
	TextArea ta = new TextArea();
	
	public KeyEventMain() {
		super("KeyEvent 테스트");
		
		add(ta);
		
		ta.addKeyListener(this);
		
		//x,y,width,height 지정
		setBounds(300,300,300,300);
		setVisible(true);
		
	}
	
	
	public static void main(String[] args) {
		new KeyEventMain();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			ta.append("Down Key\n");
		}else if(e.getKeyCode() == KeyEvent.VK_UP) {
			ta.append("Up Key\n");
		}else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			ta.append("Left Key\n");
		}else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			ta.append("Right Key\n");
		}else if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			ta.append("Enter Key\n");
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}
}
