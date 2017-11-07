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
		super("계산기");
		
		p1 = new JPanel();
		p2 = new JPanel();

		text1 = new JTextField(5);
		text2 = new JTextField(5);
		text3 = new JTextField(5);
		
		//JComboBox 객체 생성
		String[] op = {"+","-","*","/"};
		combo = new JComboBox<String>(op);
		
		//JPanel에 JTextField, JComboBox 추가
		p1.add(text1);
		p1.add(combo);
		
		p1.add(text2);
		p1.add(new JLabel("="));
		p1.add(text3);
		
		text3.setEditable(false);
		
		button1 = new JButton("확인");
		button2 = new JButton("취소");
		
		p2.add(button1);
		p2.add(button2);
		
		add(p1, BorderLayout.NORTH);
		add(p2, BorderLayout.CENTER);
		
		button1.addActionListener(this);
		button2.addActionListener(this);
		
		
		//x,y 지정
		setLocation(500,400);
		//사이즈를 명시하지 않을 경우 컴포넌트의 크키를 인식해서
		//자동으로 윈도우 사이즈 변경
		pack();
		//JFrame노출 여부 지정
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		new Calculator();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "확인") {
			t1 = text1.getText();
			t2 = text2.getText();
			//연산자 받아오기
			com = (String)combo.getSelectedItem();
			
			//조건 체크
			if(!isDigit(t1)) { //문자 포함인 경우
				showErrMsg(text1, "숫자를 입력하세요.");
				return;
			}
			if(!isDigit(t2)) {
				showErrMsg(text2, "숫자를 입력하세요.");
				return;
			}
			
			//String -> int
			num1 = Integer.parseInt(t1);
			num2 = Integer.parseInt(t2);
			
			//연산하기 위한 메소드 호출
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
			showErrMsg(text2, "0으로 나눌순 없죠!!");
		}
	}
	
	//0으로 나누는지 확인하는 메소드
	public void showErrMsg(JTextField text, String str) {
		//전달된 JTextField에 포커스
		text.requestFocus();
		//전달된 JTextField를 초기화
		text.setText("");
		//에러 발생시 합계를 초기화
		text3.setText("");
		
		//경고창 표시
		//							 (부모 컴포넌트, 표시할 메세지, 메세지 타이틀, 메세지 타입(아이콘표시를 위해))
		JOptionPane.showMessageDialog(this,str,"에러메세지", JOptionPane.ERROR_MESSAGE);
	}
	
	//문자 포함 여부 확인하는 메소드
	private boolean isDigit(String value) {
		if("".equals(value)) return false;
		
		for(int i=0;i<value.length();i++) {
			char result = value.charAt(i);
			if(i == 0 && result == '-') { 
				//첫번째 문자가 -이면 체크하지 않음
				continue;
			}
			if(result < 48 || result > 57) {
				return false;
			}
		}
		return true;
	}
	
}
