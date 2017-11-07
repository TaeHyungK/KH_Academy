package com.instance.s01;
class Tv{
	//멤버 변수
	boolean power; //전원 상태 체크
	int channel; //채널
	
	//멤버 메소드(기능)
	public void power() { //전원 켜고 끄는 기능
		power = !power;
	}
	public void channelUp() { //채널 증가
		++channel;
	}
	public void channelDown() { //채널 감소
		--channel;
	}
}


public class TvMain {
	public static void main(String[] args) {
		Tv t = new Tv();
		t.power(); // power: false -> true;
		System.out.println("TV 실행 여부: "+t.power);
		t.channel=7; //채널 입력
		System.out.println("현재 채널: "+t.channel);
		t.channelDown();
		System.out.println("변경된 채널: "+t.channel);
		
		t.power(); // 티비 종료 , power: true -> false
		System.out.println("TV 실행 여부: "+t.power);
	}
}


