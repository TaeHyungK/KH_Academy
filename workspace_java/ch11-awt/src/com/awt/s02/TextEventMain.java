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
	//				  TextField�� size
	TextField tf = new TextField(30);
	Button input = new Button("�Է�");
	Button exit = new Button("����");
	Panel p = new Panel();
	TextArea ta = new TextArea();
	
	
	public TextEventMain() {
		super("TextEvent �׽�Ʈ");
		
		//TextField�� �Է°��� ���� ��� �Է� Button ��Ȱ��ȭ
		input.setEnabled(false);
		
		//Label�� Panel�� ���
		p.add(new Label("����: "));
		//TextField�� Panel�� ���
		p.add(tf);
		//Button�� Panel�� ���
		p.add(input);
		
		//Panel�� Frame�� ���
		add(p,BorderLayout.NORTH);
		add(ta, BorderLayout.CENTER);
		add(exit, BorderLayout.SOUTH);
		
		//Listner ����
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
		if(e.getActionCommand().equals("�Է�")) {
			
			ta.append(tf.getText()+"\n");
			tf.setText("");
			//��Ŀ���� TextField�� ��
			tf.requestFocus();
			
		}else if(e.getActionCommand().equals("����")) {
			System.exit(0);
		}
		
	}

	@Override
	public void textValueChanged(TextEvent e) {
		//TextField�� ���� �� ���ڿ��̸� �Է¹�ư ��Ȱ��ȭ
		if(tf.getText().equals("")) {
			input.setEnabled(false);
		}else {
			input.setEnabled(true);
		}
	}
}
