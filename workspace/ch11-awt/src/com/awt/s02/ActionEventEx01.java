package com.awt.s02;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionEventEx01 extends Frame implements ActionListener {
	TextField text1 = new TextField(10);
	TextField text2 = new TextField(10);
	Label result = new Label("결과값:");
	Button btnAdd = new Button("더하기");
	Button btnSub = new Button("빼기");
	Button btnMulti = new Button("곱하기");
	Button btnDiv = new Button("나누기");
	Button btnExit = new Button("종료");
	Panel p1 = new Panel();
	Panel p2 = new Panel();

	public ActionEventEx01() {
		super("계산기");

		p1.add(text1);
		p1.add(text2);

		p2.add(btnAdd);
		p2.add(btnSub);
		p2.add(btnMulti);
		p2.add(btnDiv);
		p2.add(btnExit);

		add(p1, BorderLayout.NORTH);
		add(p2, BorderLayout.SOUTH);
		add(result, BorderLayout.CENTER);
		
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});

		btnAdd.addActionListener(this);
		btnSub.addActionListener(this);
		btnMulti.addActionListener(this);
		btnDiv.addActionListener(this);
		btnExit.addActionListener(this);

		setBounds(300, 300, 400, 200);
		setVisible(true);

	}

	public static void main(String[] args) {
		new ActionEventEx01();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "종료") System.exit(0);
		
		int first = Integer.parseInt(text1.getText());
		int second = Integer.parseInt(text2.getText());

		switch (e.getActionCommand()) {
		case "더하기":
			result.setText("결과값: " + (first + second));
			break;
		case "빼기":
			result.setText("결과값: " + (first - second));
			break;
		case "곱하기":
			result.setText("결과값: " + (first * second));
			break;
		case "나누기":
			if(second == 0) {
				result.setText("0으로 나눌 수 없습니다.");
				break;
			}
			result.setText("결과값: " + (first / second));
			break;
		}

	}

}
