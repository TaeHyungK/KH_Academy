
public class OperatorMain10 {
	public static void main(String[] args) {
		System.out.println("====��Ʈ������====");
		
		byte a = 12;
		//128 64 32 16 8 4 2 1 
		// 0   0  0  0 1 1 0 0
		byte b = 20;
		// 0  0   0  1 0 1 0 0
		
		//��Ʈ������ AND
		byte c = (byte)(a & b);
		// 0 0 0 0 0 1 0 0 
		System.out.println("a & b : "+c);
		
		//��Ʈ������ OR
		byte d = (byte)(a | b);
		// 0 0 0 1 1 1 0 0 
		System.out.println("a | b : "+d);
		
		//��Ʈ������ XOR
		byte e = (byte)(a ^ b);
		// 0 0 0 1 1 0 0 0 
		System.out.println("a ^ b : "+e);
		
		//��Ʈ������ ����
		//1 1 1 1 0 0 1 1
		System.out.println("~a : "+~a);
		
	}
}
