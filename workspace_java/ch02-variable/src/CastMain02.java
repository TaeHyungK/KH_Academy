
public class CastMain02 {
	public static void main(String[] args) {
		//======디모션======
		//더 작은 자료형으로 강등이 일어나는 형태
		//정보의 손실이 있을 수 있고 명시적 형변환(강제 형변환)이라고 함
		byte b1 = 127;
		byte b2 = 127;
		//자동적으로 int로 승격된 것을 byte로 강등
		byte b3 = (byte) (b1 + b2);
		System.out.println("b3 = " + b3);
		
		short s1 = 32767;
		short s2 = 32767;
		//자동적으로 int로 승격된 것을 short로 강등
		short s3 = (short) (s1 + s2);
		System.out.println("s3 = " + s3);
		
		int in1 = 1234;
		double db = 1234.578;
		//데이터의 손실 발생
		int result = in1 + (int)db;//double -> int
		System.out.println("result = " + result);
		
		int in2 = 1234;
		long lg = 1234L;
		//데이터의 손실 발생X
		int result2 = in2 + (int)lg;//long -> int
		System.out.println("result2 = " + result2);
		
		
		
	}
}
