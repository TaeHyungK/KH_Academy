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
		//���� ����
		super("������ �ð�");
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		label = new JLabel();
		label.setFont(new Font("Serif", Font.PLAIN, 20));
		
		//JLabel�� JPanel�� ���
		panel.add(label);
		//Jpane�� JFrame�� ���
		add(panel);		
		
		//x,y,width,height
		setBounds(100,100,400,100);
		//JFrame ���� ����
		setVisible(true);
		//x��ư ���� ó��
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		if(thread == null) {
			//Runnable�� ������ ��ü�� Thread�� ���
			thread = new Thread(this);
			
			//start()�޼ҵ尡 Runnable�� ������ ��ü�� run�޼ҵ带 ȣ��
			thread.start();
			
		}
	}
	
	@Override
	public void run() {
		while(true) {
			Calendar cal = Calendar.getInstance();
			String now = cal.get(Calendar.YEAR) + "�� " 
					+ (cal.get(Calendar.MONTH)+1) + "�� "
					+ cal.get(Calendar.DATE) + "�� "
					+ cal.get(Calendar.HOUR_OF_DAY)+ "�� "
					+ cal.get(Calendar.MINUTE) + "�� "
					+ cal.get(Calendar.SECOND) + "��";
			
			label.setText(now);
		}
	}
	
	public static void main(String[] args) {
		new DigitalClock();
	}

}
