package com.exception.s01;

public class ExceptionMain02 {
	public static void main(String[] args) {
		int[] array = {100,200,300};
		
		//����ó��
		//���ܰ� �߻��ص� ���������� ���ᰡ �� �� �ֵ���
		for(int i=0;i<=array.length;i++) {
			try {
				//���ܰ� �߻��� ���ɼ��� �ִ� �ڵ带 ���
				//���� ���ܰ� �߻��ϸ� ���ܰ� �߻��� �ڵ��� ������ ���߰�
				//catch������ �̵�
				System.out.println("array["+i+"]: "+array[i]);
				//�� �ڵ忡�� ���ܰ� �߻��ϸ� ������� ����
				System.out.println("~~~~~");
			}catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("�迭�� �ε����� �����ϴ�.");
			}
		}//end of for
		
		System.out.println("���α׷� ��");
		
		
	}
}
