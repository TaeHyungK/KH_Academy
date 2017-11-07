
public class CastMain01 {
	public static void main(String[] args) {
		//======프로모션=====
		//더 큰 자료형으로 승격이 일어나는 형태
		//정보의 손실이 전혀 없으며 자동적으로 발생
		
		byte b1 = 127;
		byte b2 = 127;
		//32bit 미만의 byte형 데이터를 연산하면 자동으로 자료형이
		//32bit int형으로 자동 형변환이 됨
		int b3 = b1+b2;
		System.out.println("b3 = " + b3);
		
		//32bit 미만의 short형 데이터를 연산하면 자동으로 자료형이
		//32bit int형으로 자동 형변환이 됨
		short s1 = 32767;
		short s2 = 32767;
		int s3 = s1 + s2;
		System.out.println("s3 = " + s3);
		
		int in1 = 12345;
		Long lg = 1234567L;
		            //int->long 자동적으로 형변환
		long result = in1 + lg;
		System.out.println("result = " + result);
		
		int in2 = 12345;
		double db = 356.89;
					//int->double 자동적으로 형변환
		double result2 = in2 + db;//12345.0 + 356.89
		System.out.println("result2 = " + result2);
		
		
	}
}
