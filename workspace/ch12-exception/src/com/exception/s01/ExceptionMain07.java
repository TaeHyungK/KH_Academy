package com.exception.s01;

public class ExceptionMain07 {
	public static void main(String[] args) {
		ExceptionMain07 em = new ExceptionMain07();
		try {
			em.methodA(args);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void methodA(String[] n) throws Exception{
		if (n.length > 0) {
			// Ȯ�� for��
			for (String s : n)
				System.out.println(s);

		}else {
			//���� ���� �߻�
			throw new Exception("�迭�� ��Ұ� �����ϴ�.");
		}

	}
}
