package com.swing.s02;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator extends JFrame implements ActionListener{
	JButton button1,button2;
	JTextField text1, text2, text3;
	JComboBox<String> combo;
	JPanel p1,p2;
	int num1,num2,res;
	String t1,t2,com;
	
	public Calculator() {
		super("����");
		
		p1 = new JPanel();
		p2 = new JPanel();

		text1 = new JTextField(5);
		text2 = new JTextField(5);
		text3 = new JTextField(5);
		
		//JComboBox ��ü ����
		String[] op = {"+","-","*","/"};
		combo = new JComboBox<String>(op);
		
		//JPanel�� JTextField, JComboBox �߰�
		p1.add(text1);
		p1.add(combo);
		
		p1.add(text2);
		p1.add(new JLabel("="));
		p1.add(text3);
		
		text3.setEditable(false);
		
		button1 = new JButton("Ȯ��");
		button2 = new JButton("���");
		
		p2.add(button1);
		p2.add(button2);
		
		add(p1, BorderLayout.NORTH);
		add(p2, BorderLayout.CENTER);
		
		button1.addActionListener(this);
		button2.addActionListener(this);
		
		
		//x,y ����
		setLocation(500,400);
		//����� ������� ���� ��� ������Ʈ�� ũŰ�� �ν��ؼ�
		//�ڵ����� ������ ������ ����
		pack();
		//JFrame���� ���� ����
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		new Calculator();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "Ȯ��") {
			t1 = text1.getText();
			t2 = text2.getText();
			//������ �޾ƿ���
			com = (String)combo.getSelectedItem();
			
			//���� üũ
			if(!isDigit(t1)) { //���� ������ ���
				showErrMsg(text1, "���ڸ� �Է��ϼ���.");
				return;
			}
			if(!isDigit(t2)) {
				showErrMsg(text2, "���ڸ� �Է��ϼ���.");
				return;
			}
			
			//String -> int
			num1 = Integer.parseInt(t1);
			num2 = Integer.parseInt(t2);
			
			//�����ϱ� ���� �޼ҵ� ȣ��
			doCalc();
			
		}else {
			text1.setText("");
			text2.setText("");
			text3.setText("");
		}
	}
	
	public void doCalc() {
		try {
			switch(com) {
			case "+":
				res = num1+num2;
				break;
			case "-":
				res = num1-num2;
				break;
			case "*":
				res = num1*num2;
				break;
			case "/":
				res = num1/num2;
				break;
			}
			
			text3.setText(String.valueOf(res));
		}catch(ArithmeticException e) {
			showErrMsg(text2, "0���� ������ ����!!");
		}
	}
	
	//0���� �������� Ȯ���ϴ� �޼ҵ�
	public void showErrMsg(JTextField text, String str) {
		//���޵� JTextField�� ��Ŀ��
		text.requestFocus();
		//���޵� JTextField�� �ʱ�ȭ
		text.setText("");
		//���� �߻��� �հ踦 �ʱ�ȭ
		text3.setText("");
		
		//���â ǥ��
		//							 (�θ� ������Ʈ, ǥ���� �޼���, �޼��� Ÿ��Ʋ, �޼��� Ÿ��(������ǥ�ø� ����))
		JOptionPane.showMessageDialog(this,str,"�����޼���", JOptionPane.ERROR_MESSAGE);
	}
	
	//���� ���� ���� Ȯ���ϴ� �޼ҵ�
	private boolean isDigit(String value) {
		if("".equals(value)) return false;
		
		for(int i=0;i<value.length();i++) {
			char result = value.charAt(i);
			if(i == 0 && result == '-') { 
				//ù��° ���ڰ� -�̸� üũ���� ����
				continue;
			}
			if(result < 48 || result > 57) {
				return false;
			}
		}
		return true;
	}
	
}
