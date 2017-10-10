package com.collection.s02;

import java.util.Stack;

public class StackMain {
	public static void main(String[] args) {
		String[] array = {"���޷�", "����", "������", "����", "���"};
		
		//stack : ���Լ���(LIFO, Last In First Out) ���
		Stack<String> stk = new Stack<String>();
		
		for(int i=0;i<array.length;i++) {
			stk.push(array[i]);//����� ����
		}
		//����� �������� ���
		System.out.println(stk);
		System.out.println("----------------------------");
		
		while(!stk.isEmpty()) {
			//���� ������ ������� �ʴٸ�
			
			//���ÿ� ����� ��ü(������ ���� �����ִ� ��ü, Top)�� �����ͼ� ���
			System.out.println(stk.pop());
		}
		System.out.println("--------------------");
		System.out.println(stk);
		
	}
}
