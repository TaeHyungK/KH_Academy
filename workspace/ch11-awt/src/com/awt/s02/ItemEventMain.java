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
	Button exit = new Button("종료");
	Checkbox cb1 = new Checkbox("축구");
	Checkbox cb2 = new Checkbox("야구");
	Checkbox cb3 = new Checkbox("농구");
	Checkbox cb4 = new Checkbox("배구");
	
	public ItemEventMain() {
		super("ItemEvent 테스트");
		
		//Checkbox Panel에 등록
		p1.add(cb1);
		p1.add(cb2);
		p1.add(cb3);
		p1.add(cb4);
		
		p2.add(exit);
		
		//이벤트 소스와 이벤트 리스너를 연결
		exit.addActionListener(this);
		cb1.addItemListener(this);
		cb2.addItemListener(this);
		cb3.addItemListener(this);
		cb4.addItemListener(this);
		
		//Panel을 Frame에 등록
		add(p1,BorderLayout.NORTH);
		add(p2,BorderLayout.SOUTH);
		add(ta,BorderLayout.CENTER);
		
		//x,y,width,height 지정
		setBounds(300,300,300,300);
		//Frame 노출 여부
		setVisible(true);
		
		
	}
	
	public static void main(String[] args) {
		new ItemEventMain();
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getStateChange() == ItemEvent.SELECTED) {
			//선택한 경우
			ta.append(e.getItem() + "을 선택\n\n");
		}else if(e.getStateChange() == ItemEvent.DESELECTED) {
			//선택을 해제한 경우
			ta.append(e.getItem() + "을 취소\n\n");
		}
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}
}
