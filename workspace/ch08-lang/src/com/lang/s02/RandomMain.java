package com.lang.s02;

import java.util.Random;

public class RandomMain {
	public static void main(String[] args) {
		String[] gift = {"����Ʈ��", "TV", "�����", "��"};
		
		int ran = (int) ((Math.random()*4));
		System.out.println("������ ����: " + gift[ran]);
		
		System.out.println("-----------");
		
		String[] luck = {"�ζǴ�÷", "������ ��������", "����� �Ϸ�", "�ǰ���~~~"};
		Random r1 = new Random();
		
		//0���� ���ڷ� ���޵� ���� "��"���� ������ ���� �߻�
		//ex) 0 ~ 3 ������ ���� �߻�
		int index = r1.nextInt(4);
		System.out.println("�߻� ����: " + index);
		System.out.println("������ �: " + luck[index]);
	}
}
