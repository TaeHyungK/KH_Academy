
public class VariableTypeMain02 {
	public static void main(String[] args) {
		System.out.println("===정수형===");
		//byte, 크기 : 1byte, 표현 범위: -128 ~ 127
		byte b1 = 127;
		System.out.println("b1 = " + b1);
		
		//short, 크기: 2byte, 표현 범위: -32,768 ~ 32,767
		short s1 = 32767;
		System.out.println("s1 = " + s1);
		
		//int, 크기: 4byte, 표현 범위: 약 -21억 ~ 약 21억
		//정수 표현의 기본
		int i1 =1234567;
		System.out.println("i1 = " + i1);
		
		//long, 크기: 8byte, 표현 범위: 매우 큼
		long lg = 1234567L;
		System.out.println("lg = " + lg);
		
		System.out.println("===실수형===");
		//float, 크기: 4byte
		float f1 = 9.1f;
		System.out.println("f1 = " + f1);
		
		//double, 크기: 8byte
		//실수 표현의 기본
		double d1 = 9.8;
		System.out.println("d1 = " + d1);
		
		System.out.println("===문자열 표시===");
		//기본 자료형이 아니고 참조 자료형
		String str = "Hello World!";
		System.out.println("str = " + str);
		
		
	}
}
