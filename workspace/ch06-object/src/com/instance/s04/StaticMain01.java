package com.instance.s04;

public class StaticMain01 {
	public static void main(String[] args) {
		StaticCount sc1 = new StaticCount();
		System.out.println("c: " + sc1.c + ", count: " + StaticCount.count + ", sc1.count: " + sc1.count);
		
		StaticCount sc2 = new StaticCount();
		System.out.println("c: " + sc2.c + ", count: " + StaticCount.count + ", sc2.count: " + sc2.count);
		
		StaticCount sc3 = new StaticCount();
		System.out.println("c: " + sc3.c + ", count: " + StaticCount.count + ", sc3.count: " + sc3.count);
		
	}
}
