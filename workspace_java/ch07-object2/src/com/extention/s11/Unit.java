package com.extention.s11;

abstract public class Unit {
	protected String name;
	protected int energy;
	protected int getEnergy() {
		return energy;
	}
	
	//추상메소드
	abstract public void decEnergy();
}
