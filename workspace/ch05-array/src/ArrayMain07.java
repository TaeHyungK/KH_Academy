
public class ArrayMain07 {
	/*
	 * Ŭ������ �����Ű�� main�޼ҵ尡 �����ϰ� Ŭ���� �ܺο��� 
	 * �����͸� ������ �� �ִµ� �ܺο��� ������ �����ʹ� �迭�� �����ؼ�
	 * �����ϰ� ������ �迭�� main�޼ҵ��� ���ڿ� ���޵�.
	 * Ŭ���� �ܺο��� �����͸� �������� �ʾƵ� ����ִ� �迭�� �����ؼ�
	 * main�޼ҵ��� ���ڿ� ���޵�.
	 */
	public static void main(String[] args) {
		if (args.length > 0) { // �����Ͱ� ���޵� ���
			for (int i = 0; i < args.length; i++) {
				System.out.println(args[i]);
			}
		}else { //args.length == 0 ��, ���޵� �����Ͱ� ���� ���
			System.out.println("�Է��� ������ �����ϴ�.");
		}
	}

}
