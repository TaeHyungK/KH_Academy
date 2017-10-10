package com.extention.s11;

public class Terran extends Unit {
	boolean fly;

	public Terran(String name, boolean fly) {
		this.name =name;
		energy=100;
		this.fly=fly;
	}

	@Override
	public void decEnergy() {
		energy-=3;
	}
}


