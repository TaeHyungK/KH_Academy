
public class CastMain02 {
	public static void main(String[] args) {
		//======����======
		//�� ���� �ڷ������� ������ �Ͼ�� ����
		//������ �ս��� ���� �� �ְ� ����� ����ȯ(���� ����ȯ)�̶�� ��
		byte b1 = 127;
		byte b2 = 127;
		//�ڵ������� int�� �°ݵ� ���� byte�� ����
		byte b3 = (byte) (b1 + b2);
		System.out.println("b3 = " + b3);
		
		short s1 = 32767;
		short s2 = 32767;
		//�ڵ������� int�� �°ݵ� ���� short�� ����
		short s3 = (short) (s1 + s2);
		System.out.println("s3 = " + s3);
		
		int in1 = 1234;
		double db = 1234.578;
		//�������� �ս� �߻�
		int result = in1 + (int)db;//double -> int
		System.out.println("result = " + result);
		
		int in2 = 1234;
		long lg = 1234L;
		//�������� �ս� �߻�X
		int result2 = in2 + (int)lg;//long -> int
		System.out.println("result2 = " + result2);
		
		
		
	}
}
