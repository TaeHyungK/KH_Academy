package com.extention.s11;

abstract public class Unit {
	protected String name;
	protected int energy;
	protected int getEnergy() {
		return energy;
	}
	
	//�߻�޼ҵ�
	abstract public void decEnergy();
}
