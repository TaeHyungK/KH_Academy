package com.extention.s11;

public class UnitTest {
	public static void main(String[] args) {
		Protoss p1 = new Protoss("�ູ",true);
		p1.decEnergy();
		
		Terran t1 = new Terran("�ĵ�", false);
		t1.decEnergy();
		
		Zerg z1 = new Zerg("�¸�", false);
		z1.decEnergy();
		
		System.out.println("p1�� Energy: " + p1.getEnergy());
		System.out.println("t1�� Energy: " + t1.getEnergy());
		System.out.println("z1�� Energy: " + z1.getEnergy());
		
	}
}
