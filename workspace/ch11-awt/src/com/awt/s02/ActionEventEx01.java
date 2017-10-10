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
	Label result = new Label("�����:");
	Button btnAdd = new Button("���ϱ�");
	Button btnSub = new Button("����");
	Button btnMulti = new Button("���ϱ�");
	Button btnDiv = new Button("������");
	Button btnExit = new Button("����");
	Panel p1 = new Panel();
	Panel p2 = new Panel();

	public ActionEventEx01() {
		super("����");

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
		if(e.getActionCommand() == "����") System.exit(0);
		
		int first = Integer.parseInt(text1.getText());
		int second = Integer.parseInt(text2.getText());

		switch (e.getActionCommand()) {
		case "���ϱ�":
			result.setText("�����: " + (first + second));
			break;
		case "����":
			result.setText("�����: " + (first - second));
			break;
		case "���ϱ�":
			result.setText("�����: " + (first * second));
			break;
		case "������":
			if(second == 0) {
				result.setText("0���� ���� �� �����ϴ�.");
				break;
			}
			result.setText("�����: " + (first / second));
			break;
		}

	}

}
