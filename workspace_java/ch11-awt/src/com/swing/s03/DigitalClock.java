package com.swing.s03;

import java.awt.Color;
import java.awt.Font;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DigitalClock extends JFrame implements Runnable {

	private Thread thread;
	private JLabel label;
	private JPanel panel;
	
	public DigitalClock() {
		//제목 설정
		super("디지털 시계");
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		label = new JLabel();
		label.setFont(new Font("Serif", Font.PLAIN, 20));
		
		//JLabel을 JPanel에 등록
		panel.add(label);
		//Jpane을 JFrame에 등록
		add(panel);		
		
		//x,y,width,height
		setBounds(100,100,400,100);
		//JFrame 노출 여부
		setVisible(true);
		//x버튼 종료 처리
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		if(thread == null) {
			//Runnable이 구현된 객체를 Thread에 등록
			thread = new Thread(this);
			
			//start()메소드가 Runnable이 구현된 객체의 run메소드를 호출
			thread.start();
			
		}
	}
	
	@Override
	public void run() {
		while(true) {
			Calendar cal = Calendar.getInstance();
			String now = cal.get(Calendar.YEAR) + "년 " 
					+ (cal.get(Calendar.MONTH)+1) + "월 "
					+ cal.get(Calendar.DATE) + "일 "
					+ cal.get(Calendar.HOUR_OF_DAY)+ "시 "
					+ cal.get(Calendar.MINUTE) + "분 "
					+ cal.get(Calendar.SECOND) + "초";
			
			label.setText(now);
		}
	}
	
	public static void main(String[] args) {
		new DigitalClock();
	}

}
