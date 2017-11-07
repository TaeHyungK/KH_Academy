
public class OperatorMain11 {
	public static void main(String[] args) {
		System.out.println("====시프트연산자====");
		
		byte a = 12;
		//128 64 32 16 8 4 2 1 
		// 1   0  0  0 1 1 0 0
		//최상위 비트를 부호 비트라고 함. 0이면 양수 1이면 음수
		
		//비트값을 오른쪽으로 2칸 이동, 빈자리는 부호값으로 대입 -> 값이 작아짐
		byte c = (byte) (a >> 2);
		System.out.println("a>>2 : " + c);
		//128 64 32 16 8 4 2 1
		//  0  0  0  0 0 0 1 1
		
		//비트값을 왼쪽으로 2칸 이동, 빈자리는 0으로 대입 -> 값이 커짐
		byte d = (byte) (a << 2);
		System.out.println("a<<2 : " + d);
		//128 64 32 16 8 4 2 1
		//  0  0  1  1 0 0 0 0
		
		byte e = (byte) (a >>> 2);
		System.out.println("a>>>2 : " + e);
		//128 64 32 16 8 4 2 1
		//  0  0  0  0 0 0 1 1
	
	
	}
}
