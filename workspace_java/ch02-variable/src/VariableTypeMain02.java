
public class VariableTypeMain02 {
	public static void main(String[] args) {
		System.out.println("===������===");
		//byte, ũ�� : 1byte, ǥ�� ����: -128 ~ 127
		byte b1 = 127;
		System.out.println("b1 = " + b1);
		
		//short, ũ��: 2byte, ǥ�� ����: -32,768 ~ 32,767
		short s1 = 32767;
		System.out.println("s1 = " + s1);
		
		//int, ũ��: 4byte, ǥ�� ����: �� -21�� ~ �� 21��
		//���� ǥ���� �⺻
		int i1 =1234567;
		System.out.println("i1 = " + i1);
		
		//long, ũ��: 8byte, ǥ�� ����: �ſ� ŭ
		long lg = 1234567L;
		System.out.println("lg = " + lg);
		
		System.out.println("===�Ǽ���===");
		//float, ũ��: 4byte
		float f1 = 9.1f;
		System.out.println("f1 = " + f1);
		
		//double, ũ��: 8byte
		//�Ǽ� ǥ���� �⺻
		double d1 = 9.8;
		System.out.println("d1 = " + d1);
		
		System.out.println("===���ڿ� ǥ��===");
		//�⺻ �ڷ����� �ƴϰ� ���� �ڷ���
		String str = "Hello World!";
		System.out.println("str = " + str);
		
		
	}
}
