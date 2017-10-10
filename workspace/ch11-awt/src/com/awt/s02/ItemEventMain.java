package com.awt.s02;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ItemEventMain extends Frame implements ItemListener,ActionListener{
	Panel p1 = new Panel();
	Panel p2 = new Panel();
	TextArea ta = new TextArea();
	Button exit = new Button("����");
	Checkbox cb1 = new Checkbox("�౸");
	Checkbox cb2 = new Checkbox("�߱�");
	Checkbox cb3 = new Checkbox("��");
	Checkbox cb4 = new Checkbox("�豸");
	
	public ItemEventMain() {
		super("ItemEvent �׽�Ʈ");
		
		//Checkbox Panel�� ���
		p1.add(cb1);
		p1.add(cb2);
		p1.add(cb3);
		p1.add(cb4);
		
		p2.add(exit);
		
		//�̺�Ʈ �ҽ��� �̺�Ʈ �����ʸ� ����
		exit.addActionListener(this);
		cb1.addItemListener(this);
		cb2.addItemListener(this);
		cb3.addItemListener(this);
		cb4.addItemListener(this);
		
		//Panel�� Frame�� ���
		add(p1,BorderLayout.NORTH);
		add(p2,BorderLayout.SOUTH);
		add(ta,BorderLayout.CENTER);
		
		//x,y,width,height ����
		setBounds(300,300,300,300);
		//Frame ���� ����
		setVisible(true);
		
		
	}
	
	public static void main(String[] args) {
		new ItemEventMain();
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getStateChange() == ItemEvent.SELECTED) {
			//������ ���
			ta.append(e.getItem() + "�� ����\n\n");
		}else if(e.getStateChange() == ItemEvent.DESELECTED) {
			//������ ������ ���
			ta.append(e.getItem() + "�� ���\n\n");
		}
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}
}
