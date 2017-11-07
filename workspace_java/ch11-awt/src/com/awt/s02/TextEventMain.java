package com.awt.s02;

import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.awt.BorderLayout;
import java.awt.Button;

public class TextEventMain extends Frame implements ActionListener, TextListener{
	//				  TextField의 size
	TextField tf = new TextField(30);
	Button input = new Button("입력");
	Button exit = new Button("종료");
	Panel p = new Panel();
	TextArea ta = new TextArea();
	
	
	public TextEventMain() {
		super("TextEvent 테스트");
		
		//TextField에 입력값이 없을 경우 입력 Button 비활성화
		input.setEnabled(false);
		
		//Label을 Panel에 등록
		p.add(new Label("제목: "));
		//TextField를 Panel에 등록
		p.add(tf);
		//Button을 Panel에 등록
		p.add(input);
		
		//Panel을 Frame에 등록
		add(p,BorderLayout.NORTH);
		add(ta, BorderLayout.CENTER);
		add(exit, BorderLayout.SOUTH);
		
		//Listner 연결
		input.addActionListener(this);
		exit.addActionListener(this);
		tf.addTextListener(this);
		
		setBounds(300,300,400,300);
		setVisible(true);
		
	
	}
	
	public static void main(String[] args) {
		new TextEventMain();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("입력")) {
			
			ta.append(tf.getText()+"\n");
			tf.setText("");
			//포커스를 TextField에 줌
			tf.requestFocus();
			
		}else if(e.getActionCommand().equals("종료")) {
			System.exit(0);
		}
		
	}

	@Override
	public void textValueChanged(TextEvent e) {
		//TextField의 값이 빈 문자열이면 입력버튼 비활성화
		if(tf.getText().equals("")) {
			input.setEnabled(false);
		}else {
			input.setEnabled(true);
		}
	}
}
