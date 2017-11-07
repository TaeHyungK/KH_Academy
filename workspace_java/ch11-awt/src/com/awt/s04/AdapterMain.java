package com.awt.s04;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AdapterMain extends Frame implements ActionListener{
	Panel p1,p2,p3;
	
	TextField tf;
	TextArea ta;
	
	Button b1,b2;
	
	public AdapterMain() {
		super("Adapter 테스트");
		
		//각종 컴포넌트 객체 생성
		p1 = new Panel();
		p2 = new Panel();
		p3 = new Panel();
		
		tf = new TextField(35);
		//				 높이, 넓이
		ta = new TextArea(10,35);
		
		b1 = new Button("Clear");
		b2 = new Button("Exit");
		
		p1.add(tf);
		p2.add(ta);
		p3.add(b1);
		p3.add(b2);

		add(p1,BorderLayout.NORTH);
		add(p2,BorderLayout.CENTER);
		add(p3,BorderLayout.SOUTH);		
		
		setBounds(300,200,300,300);
		setVisible(true);
		
		addWindowListener(new WindowEventHandler());
		b1.addActionListener(this);
		b2.addActionListener(this);
		tf.addKeyListener(new KeyEventHandler());
	}
	
	public static void main(String[] args) {
		new AdapterMain();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand()=="Exit") {
			System.exit(0);
		}else if(e.getActionCommand() =="Clear") {
			//데이터가 한 줄 일 경우 초기화되지 않는 현상 해결
			ta.setText(" ");
			ta.setText("");
			//TextField에 입력하고 enter를 치지 않고 초기화 하려고할 때 초기화
			//되지 않는 현상을 해결
			tf.setText(" ");
			tf.setText("");
			
			tf.requestFocus();
		}
	}
	
	//멤버 내부 클래스
	class WindowEventHandler extends WindowAdapter{
		//WindowAdapter의 메소드 재정의
		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	}
	
	//멤버 내부 클래스
	class KeyEventHandler extends KeyAdapter{
		@Override
		public void keyTyped(KeyEvent e) {
			if(e.getKeyChar() == KeyEvent.VK_ENTER) {
				String str = tf.getText();
				ta.append(str + "\n");
				tf.setText("");
			}
		}		
	}
}


