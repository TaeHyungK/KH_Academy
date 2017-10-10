package com.extention.s11;

public class Zerg extends Unit{
	boolean fly;

	public Zerg(String name, boolean fly) {
		this.name =name;
		energy=100;
		this.fly=fly;
	}

	@Override
	public void decEnergy() {
		energy-=6;
	}
}
