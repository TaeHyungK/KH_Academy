
public class IfEx01 {
	public static void main(String[] args) {
		char ch = 'Y';
		
		/*
		 * [�ǽ�]ch�� �빮���̸� "�빮���Դϴ�."
		 * ch�� �ҹ����̸� "�ҹ����Դϴ�."
		 * ch�� �빮�ڵ� �ƴϰ� �ҹ��ڵ� �ƴϸ�
		 * "��Ÿ�����Դϴ�." ���
		 */
		
		if(ch>= 65 && ch<=90) {
			System.out.println("�빮�� �Դϴ�.");
		}else if(ch >=97 && ch<= 122) {
			System.out.println("�ҹ��� �Դϴ�.");
		}else {
			System.out.println("��Ÿ�����Դϴ�.");
		}
	}
}
