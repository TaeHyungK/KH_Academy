package ncs.test2;

public class Customer {
	int money = 10000;
	int point = 0;

	public void order(Food f) {
		if(money <f.price) {
			System.out.println("�ܾ׺���");
			return;
		}
		money -= f.price;
		point += f.point;

		System.out.println(f.getName()+"�� �ֹ��ϼ̽��ϴ�.");
	}
}
