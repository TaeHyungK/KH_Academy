package com.instance.s03;

public class AnimalMain {
	private static String printFly(boolean fly) {
		return fly ? "����" : "�Ұ���";
	}
	private static void print(Animal a) {
		System.out.println("�̸�: " + a.getName());
		System.out.printf("����: %d��\n", a.getAge());
		System.out.println("���࿩��: " + printFly(a.isFly()));
	}
	
	public static void main(String[] args) {
		//��ü ����
		Animal a = new Animal();
		//������ ����(�̸�: �ⷯ��, ����:2, ���࿩��: true)
		a.setName("�ⷯ��");
		a.setAge(2);
		a.setFly(true);
		
		//������ ���
		/* -----����-----
		 * �̸�: �ⷯ��
		 * ����: 2��
		 * ���࿩��: ���� 
		 */
//		String fly_state = a.isFly() ? "����" : "�Ұ���";
		
		String fly_state;
		if(a.isFly() == true)
			fly_state = "����";
		else
			fly_state = "�Ұ���";
		
//		System.out.println("�̸�: " + a.getName());
//		System.out.printf("����: %d��\n", a.getAge());
//		System.out.println("���࿩��: " + printFly(a.isFly()));
		
		//static method�� �̿��� ���
		print(a);
		System.out.println("------------");
		//�̸�: �ڳ���, ����: 10, ���࿩��: false
		//���ڰ� �ִ� �����ڸ� �̿��ؼ� ��ü ����
		Animal k = new Animal("�ڳ���", 10, false);
		
		/* -----����-----
		 * �̸�: �ڳ���
		 * ����: 10��
		 * ���࿩��: �Ұ��� 
		 */
//		System.out.println("�̸�: " + k.getName());
//		System.out.printf("����: %d��\n", k.getAge());
//		System.out.println("���࿩��: " + printFly(k.isFly()));
		
		//static method�� �̿��� ���
		print(k);
	}
}
