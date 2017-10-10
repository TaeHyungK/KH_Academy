package com.collection.s02;

import java.util.LinkedList;

public class LinkedListMain {
	public static void main(String[] args) {
		String[] array = {"���޷�", "����", "������", "����", "���"};
		
		//ť(Queue): ���Լ��� (FIFO, First In First Out) ���
		LinkedList<String> list = new LinkedList<String>();
		
		for(int i=0;i<array.length;i++) {
			list.offer(array[i]);
		}
		
		//����� ����� ���
		System.out.println(list);
		System.out.println("-----------");
		
		while(list.peek() != null) { //������ ����
			//�����͸� ��ȯ�ϰ� ��ȯ�� ������ ����
			System.out.println(list.poll());
		}
		
		System.out.println("-----------");
		System.out.println(list);
		
		
	}
}