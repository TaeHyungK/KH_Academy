
public class OperatorMain11 {
	public static void main(String[] args) {
		System.out.println("====����Ʈ������====");
		
		byte a = 12;
		//128 64 32 16 8 4 2 1 
		// 1   0  0  0 1 1 0 0
		//�ֻ��� ��Ʈ�� ��ȣ ��Ʈ��� ��. 0�̸� ��� 1�̸� ����
		
		//��Ʈ���� ���������� 2ĭ �̵�, ���ڸ��� ��ȣ������ ���� -> ���� �۾���
		byte c = (byte) (a >> 2);
		System.out.println("a>>2 : " + c);
		//128 64 32 16 8 4 2 1
		//  0  0  0  0 0 0 1 1
		
		//��Ʈ���� �������� 2ĭ �̵�, ���ڸ��� 0���� ���� -> ���� Ŀ��
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
