
public class OperatorEx01 {
	public static void main(String[] args) {
		/*
		 * [�ǽ�]���� ó�� 
		 * ����(korean) 87 ����(english) 98 ����(math) 92
		 * ����, ��� ���ϱ�
		 * 
		 * ��� ����
		 * -------
		 * 
		 * ���� = 87
		 * ���� = 98
		 * ���� = 92
		 * ���� = 
		 * ��� = (�Ҽ��� ��°�ڸ�����)
		 */
		int korean = 87, english = 98, math = 92;
		int sum = korean + english + math;
		double avg = (double)sum/3;
		//double avg = sum / 3.0; <- �ڵ� ĳ����

		System.out.printf("%s = %d\n", "����", korean);
		System.out.printf("%s = %d\n", "����", english);
		System.out.printf("%s = %d\n", "����", math);
		System.out.printf("%s = %d\n", "����", sum);
		System.out.printf("%s = %.2f\n", "���", avg);
		
	}
}
