
public class OperatorEx03 {
	public static void main(String[] args) {
		/*
		 * [�ǽ�]���� ������ ���
		 * int�� ���� a�� 10�� �����ϰ� 
		 * int�� ���� b�� 20�� ������ ��
		 * int�� ���� max, min �� �����ϰ�
		 * �ִ밪�� max�� �ּҰ��� min�� �����ϰ�
		 * �ִ밪�� �ּҰ��� ����Ͻÿ�.
		 */
		
		int a = 10, b= 20;
		int max, min;
		
		max = (a > b) ? a : b;
		min = (a < b) ? a : b;
		
		System.out.println("max: " + max);
		System.out.println("min: " + min);
	}
}
