
public class VariableTypeMain01 {
	public static void main(String[] args) {
		System.out.println("===����===");
		boolean b = true;
		System.out.println("b = " + b);
		
		System.out.println("===������===");
		//������ ũ�� : 2byte ǥ�� ����: 0 ~ 65,535
		//�ٱ��� ó���� ���� �����ڵ�(unicode) ���
		char c1 = 'A'; // �ƽ�Ű�ڵ� 'A' = 65
		char c2 = 65;
		char c3 = '\u0041'; // A�� �����ڵ�� ǥ��
		char c4 = '��';
		char c5 = '\uc790'; // �ڸ� �����ڵ�� ǥ��
		
		System.out.println("c1 = " + c1);
		System.out.println("c2 = " + c2);
		System.out.println("c3 = " + c3);
		System.out.println("c4 = " + c4);
		System.out.println("c5 = " + c5);
		
		
		
		
		
	}
}
