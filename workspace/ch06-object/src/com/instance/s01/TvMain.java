package com.instance.s01;
class Tv{
	//��� ����
	boolean power; //���� ���� üũ
	int channel; //ä��
	
	//��� �޼ҵ�(���)
	public void power() { //���� �Ѱ� ���� ���
		power = !power;
	}
	public void channelUp() { //ä�� ����
		++channel;
	}
	public void channelDown() { //ä�� ����
		--channel;
	}
}


public class TvMain {
	public static void main(String[] args) {
		Tv t = new Tv();
		t.power(); // power: false -> true;
		System.out.println("TV ���� ����: "+t.power);
		t.channel=7; //ä�� �Է�
		System.out.println("���� ä��: "+t.channel);
		t.channelDown();
		System.out.println("����� ä��: "+t.channel);
		
		t.power(); // Ƽ�� ���� , power: true -> false
		System.out.println("TV ���� ����: "+t.power);
	}
}


