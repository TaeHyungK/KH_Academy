
public class CastMain01 {
	public static void main(String[] args) {
		//======���θ��=====
		//�� ū �ڷ������� �°��� �Ͼ�� ����
		//������ �ս��� ���� ������ �ڵ������� �߻�
		
		byte b1 = 127;
		byte b2 = 127;
		//32bit �̸��� byte�� �����͸� �����ϸ� �ڵ����� �ڷ�����
		//32bit int������ �ڵ� ����ȯ�� ��
		int b3 = b1+b2;
		System.out.println("b3 = " + b3);
		
		//32bit �̸��� short�� �����͸� �����ϸ� �ڵ����� �ڷ�����
		//32bit int������ �ڵ� ����ȯ�� ��
		short s1 = 32767;
		short s2 = 32767;
		int s3 = s1 + s2;
		System.out.println("s3 = " + s3);
		
		int in1 = 12345;
		Long lg = 1234567L;
		            //int->long �ڵ������� ����ȯ
		long result = in1 + lg;
		System.out.println("result = " + result);
		
		int in2 = 12345;
		double db = 356.89;
					//int->double �ڵ������� ����ȯ
		double result2 = in2 + db;//12345.0 + 356.89
		System.out.println("result2 = " + result2);
		
		
	}
}
