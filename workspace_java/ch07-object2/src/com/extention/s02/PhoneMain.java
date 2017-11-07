package com.extention.s02;

public class PhoneMain {
	public static void main(String[] args) {
		SmartPhone sp = new SmartPhone("A1001", "010-123", "white", "안드로이드");
		FeaturePhone fp = new FeaturePhone("B1001", "010-124", "black", 800);
		
		System.out.println("=======================================");
		System.out.println("모델\t번호\t색상\t옵션(OS/화소수)");
		System.out.println("=======================================");

		System.out.print(sp.getModel()+"\t");
		System.out.print(sp.getNumber()+"\t");
		System.out.print(sp.getColor()+"\t");
		System.out.print(sp.getOs()+"\n");
		
		System.out.print(fp.getModel()+"\t");
		System.out.print(fp.getNumber()+"\t");
		System.out.print(fp.getColor()+"\t");
		System.out.print(fp.getPixel()+"\n");
	}
}
