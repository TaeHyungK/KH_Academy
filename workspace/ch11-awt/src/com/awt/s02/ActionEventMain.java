package com.awt.s02;

import java.awt.Frame;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionEventMain extends Frame implements ActionListener{
	/*
	 * 이벤트 연결 순서
	 * 1. 이벤트 리스너(interface) 구현
	 * 2. 이벤트 핸들러(interface의 추상메소드) 구현
	 * 3. 이벤트 소스와 이벤트 리스너 연결
	 */
	
	Panel p;
	Button input, exit;
	TextArea ta;
	
	public ActionEventMain(){
		super("ActionEvent 테스트");
		
		p = new Panel();
		input = new Button("입력");
		exit = new Button("종료");
		ta = new TextArea();
		
		//이벤트 소스와 이벤트 리스너 등록
		input.addActionListener(this);
		exit.addActionListener(this);
				
		p.add(input);
		p.add(exit);
		
		//Panel을 Frame에 등록
		add(p,BorderLayout.NORTH);
		//TextArea를 Frame에 등록
		add(ta,BorderLayout.CENTER);
		
		//x,y,width,height 지정
		setBounds(300,300,300,200);
		//노출 여부
		setVisible(true);
	}
	
	//EventHandler 구현
	@Override
	public void actionPerformed(ActionEvent e) {
		//이벤트가 발생한 객체의 텍스트를 반환
		String name = e.getActionCommand();
		if(name.equals("입력")) {
			ta.append("버튼을 눌렀군요!\n");
		}else { // 종료
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		new ActionEventMain();
	}

	
}
