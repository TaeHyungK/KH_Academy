package com.lang.s02;

import java.util.Random;

public class RandomMain {
	public static void main(String[] args) {
		String[] gift = {"스마트폰", "TV", "냉장고", "꽝"};
		
		int ran = (int) ((Math.random()*4));
		System.out.println("오늘의 선물: " + gift[ran]);
		
		System.out.println("-----------");
		
		String[] luck = {"로또당첨", "달콤한 프로포즈", "행운의 하루", "피곤해~~~"};
		Random r1 = new Random();
		
		//0부터 인자로 전달된 값의 "전"까지 범위로 난수 발생
		//ex) 0 ~ 3 까지의 난수 발생
		int index = r1.nextInt(4);
		System.out.println("발생 난수: " + index);
		System.out.println("오늘의 운세: " + luck[index]);
	}
}
