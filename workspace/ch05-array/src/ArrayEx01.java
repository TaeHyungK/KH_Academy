
public class ArrayEx01 {
	public static void main(String[] args) {
		/*
		 * [�ǽ�] 1. 10,20,30,40,50�� �ʱⰪ���� ���� 1���� �迭 test �̸����� ����, ����, �ʱ�ȭ 2. test �迭�� ��Ҹ�
		 * ����Ͻÿ�. (�ݺ��� �̿�) 3. �ε��� 3�� �����͸� 100���� �����Ͻÿ�. 4. ������ ����� ���� 200���� �����Ͻÿ�. 5.
		 * �ݺ����� ����Ͽ� ��� ����� ���� 0���� �ʱ�ȭ�Ͻÿ�. 6. Ȧ�� �ε����� 10�� ����, ¦�� �ε����� 20�� ����
		 */

		int[] test = { 10, 20, 30, 40, 50 };
		for (int i = 0; i < test.length; i++) {
			System.out.println("test[" + i + "]: " + test[i]);
		}

		System.out.println("----------");

		test[3] = 100;
		test[test.length - 1] = 200;
		for (int i = 0; i < test.length; i++) {
			System.out.println("test[" + i + "]: " + test[i]);
		}

		System.out.println("----------");

		for (int i = 0; i < test.length; i++) {
			test[i] = 0;
			System.out.println("test[" + i + "]: " + test[i]);
		}

		for (int i = 0; i < test.length; i++) {
			if (i % 2 == 1)
				test[i] = 10;
			
			else
				test[i] = 20;
			System.out.println("test[" + i + "]: " + test[i]);
		}

	}
}
