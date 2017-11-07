package com.instance.s03;

public class AnimalMain {
	private static String printFly(boolean fly) {
		return fly ? "가능" : "불가능";
	}
	private static void print(Animal a) {
		System.out.println("이름: " + a.getName());
		System.out.printf("나이: %d살\n", a.getAge());
		System.out.println("비행여부: " + printFly(a.isFly()));
	}
	
	public static void main(String[] args) {
		//객체 생성
		Animal a = new Animal();
		//데이터 셋팅(이름: 기러기, 나이:2, 비행여부: true)
		a.setName("기러기");
		a.setAge(2);
		a.setFly(true);
		
		//데이터 출력
		/* -----예시-----
		 * 이름: 기러기
		 * 나이: 2살
		 * 비행여부: 가능 
		 */
//		String fly_state = a.isFly() ? "가능" : "불가능";
		
		String fly_state;
		if(a.isFly() == true)
			fly_state = "가능";
		else
			fly_state = "불가능";
		
//		System.out.println("이름: " + a.getName());
//		System.out.printf("나이: %d살\n", a.getAge());
//		System.out.println("비행여부: " + printFly(a.isFly()));
		
		//static method를 이용한 출력
		print(a);
		System.out.println("------------");
		//이름: 코끼리, 나이: 10, 비행여부: false
		//인자가 있는 생성자를 이용해서 객체 생성
		Animal k = new Animal("코끼리", 10, false);
		
		/* -----예시-----
		 * 이름: 코끼리
		 * 나이: 10살
		 * 비행여부: 불가능 
		 */
//		System.out.println("이름: " + k.getName());
//		System.out.printf("나이: %d살\n", k.getAge());
//		System.out.println("비행여부: " + printFly(k.isFly()));
		
		//static method를 이용한 출력
		print(k);
	}
}
