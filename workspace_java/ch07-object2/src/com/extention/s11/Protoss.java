package com.extention.s11;

public class Protoss extends Unit{
	boolean fly;
	
	public Protoss(String name, boolean fly) {
		this.name =name;
		energy=100;
		this.fly=fly;
	}
	@Override
	public void decEnergy() {
		energy--;
	}

}
