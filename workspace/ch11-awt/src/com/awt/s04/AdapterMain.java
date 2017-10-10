package com.awt.s04;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AdapterMain extends Frame implements ActionListener{
	Panel p1,p2,p3;
	
	TextField tf;
	TextArea ta;
	
	Button b1,b2;
	
	public AdapterMain() {
		super("Adapter �׽�Ʈ");
		
		//���� ������Ʈ ��ü ����
		p1 = new Panel();
		p2 = new Panel();
		p3 = new Panel();
		
		tf = new TextField(35);
		//				 ����, ����
		ta = new TextArea(10,35);
		
		b1 = new Button("Clear");
		b2 = new Button("Exit");
		
		p1.add(tf);
		p2.add(ta);
		p3.add(b1);
		p3.add(b2);

		add(p1,BorderLayout.NORTH);
		add(p2,BorderLayout.CENTER);
		add(p3,BorderLayout.SOUTH);		
		
		setBounds(300,200,300,300);
		setVisible(true);
		
		addWindowListener(new WindowEventHandler());
		b1.addActionListener(this);
		b2.addActionListener(this);
		tf.addKeyListener(new KeyEventHandler());
	}
	
	public static void main(String[] args) {
		new AdapterMain();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand()=="Exit") {
			System.exit(0);
		}else if(e.getActionCommand() =="Clear") {
			//�����Ͱ� �� �� �� ��� �ʱ�ȭ���� �ʴ� ���� �ذ�
			ta.setText(" ");
			ta.setText("");
			//TextField�� �Է��ϰ� enter�� ġ�� �ʰ� �ʱ�ȭ �Ϸ����� �� �ʱ�ȭ
			//���� �ʴ� ������ �ذ�
			tf.setText(" ");
			tf.setText("");
			
			tf.requestFocus();
		}
	}
	
	//��� ���� Ŭ����
	class WindowEventHandler extends WindowAdapter{
		//WindowAdapter�� �޼ҵ� ������
		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	}
	
	//��� ���� Ŭ����
	class KeyEventHandler extends KeyAdapter{
		@Override
		public void keyTyped(KeyEvent e) {
			if(e.getKeyChar() == KeyEvent.VK_ENTER) {
				String str = tf.getText();
				ta.append(str + "\n");
				tf.setText("");
			}
		}		
	}
}


