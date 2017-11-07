package com.extention.s12;

interface I{
	public abstract void play();
}

class B implements I{
	@Override
	public void play() {
		System.out.println("play in B class");
	}
}

class C implements I{
	@Override
	public void play() {
		System.out.println("play in C class");
	}
}

class A{
	public void autoPlay(I i) {
		i.play();
	}
}

public class InterMain06 {
	public static void main(String[] args) {
		A ap = new A();
		ap.autoPlay(new B());//B -> I
		ap.autoPlay(new C());//B -> I
		
	}
}
