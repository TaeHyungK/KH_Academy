package com.awt.s02;

import java.awt.Frame;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionEventMain extends Frame implements ActionListener{
	/*
	 * �̺�Ʈ ���� ����
	 * 1. �̺�Ʈ ������(interface) ����
	 * 2. �̺�Ʈ �ڵ鷯(interface�� �߻�޼ҵ�) ����
	 * 3. �̺�Ʈ �ҽ��� �̺�Ʈ ������ ����
	 */
	
	Panel p;
	Button input, exit;
	TextArea ta;
	
	public ActionEventMain(){
		super("ActionEvent �׽�Ʈ");
		
		p = new Panel();
		input = new Button("�Է�");
		exit = new Button("����");
		ta = new TextArea();
		
		//�̺�Ʈ �ҽ��� �̺�Ʈ ������ ���
		input.addActionListener(this);
		exit.addActionListener(this);
				
		p.add(input);
		p.add(exit);
		
		//Panel�� Frame�� ���
		add(p,BorderLayout.NORTH);
		//TextArea�� Frame�� ���
		add(ta,BorderLayout.CENTER);
		
		//x,y,width,height ����
		setBounds(300,300,300,200);
		//���� ����
		setVisible(true);
	}
	
	//EventHandler ����
	@Override
	public void actionPerformed(ActionEvent e) {
		//�̺�Ʈ�� �߻��� ��ü�� �ؽ�Ʈ�� ��ȯ
		String name = e.getActionCommand();
		if(name.equals("�Է�")) {
			ta.append("��ư�� ��������!\n");
		}else { // ����
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		new ActionEventMain();
	}

	
}
