package com.awt.s02;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

public class ActionEventEx02 extends Frame implements ActionListener, TextListener {
	Panel p = new Panel();
	TextArea ta = new TextArea();
	TextField tf = new TextField(20);
	Button btn = new Button("출력");
	Button exit = new Button("종료");

	String dan;

	public ActionEventEx02() {
		super("구구단");

		p.add(tf);
		p.add(btn);

		add(p, BorderLayout.NORTH);
		add(ta, BorderLayout.CENTER);
		add(exit, BorderLayout.SOUTH);

		btn.addActionListener(this);
		exit.addActionListener(this);
		tf.addTextListener(this);

		setBounds(300, 300, 300, 500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new ActionEventEx02();
	}

	// ActionListener
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "종료")
			System.exit(0);
		else {
			ta.setText(dan + " 단\n");
			for (int i = 1; i <= 9; i++) {
				ta.append(dan + " * " + i + " = " + (Integer.parseInt(dan) * i + "\n"));
			}
			ta.append("\n");
			tf.setText("");
			tf.requestFocus();
		}
	}

	// TextListener
	@Override
	public void textValueChanged(TextEvent e) {
		dan = tf.getText();
	}
}
