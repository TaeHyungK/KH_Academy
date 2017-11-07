package com.extention.s11;

public class UnitTest {
	public static void main(String[] args) {
		Protoss p1 = new Protoss("행복",true);
		p1.decEnergy();
		
		Terran t1 = new Terran("파도", false);
		t1.decEnergy();
		
		Zerg z1 = new Zerg("승리", false);
		z1.decEnergy();
		
		System.out.println("p1의 Energy: " + p1.getEnergy());
		System.out.println("t1의 Energy: " + t1.getEnergy());
		System.out.println("z1의 Energy: " + z1.getEnergy());
		
	}
}
