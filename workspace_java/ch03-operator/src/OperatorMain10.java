
public class OperatorMain10 {
	public static void main(String[] args) {
		System.out.println("====비트연산자====");
		
		byte a = 12;
		//128 64 32 16 8 4 2 1 
		// 0   0  0  0 1 1 0 0
		byte b = 20;
		// 0  0   0  1 0 1 0 0
		
		//비트단위의 AND
		byte c = (byte)(a & b);
		// 0 0 0 0 0 1 0 0 
		System.out.println("a & b : "+c);
		
		//비트단위의 OR
		byte d = (byte)(a | b);
		// 0 0 0 1 1 1 0 0 
		System.out.println("a | b : "+d);
		
		//비트단위의 XOR
		byte e = (byte)(a ^ b);
		// 0 0 0 1 1 0 0 0 
		System.out.println("a ^ b : "+e);
		
		//비트단위의 반전
		//1 1 1 1 0 0 1 1
		System.out.println("~a : "+~a);
		
	}
}
