package ncs.test2;

public class CustomerMain {
	public static void main(String[] args) {
		Customer customer = new Customer();
		Noodle noodle = new Noodle();
		Rice rice = new Rice();
		//Customer�� order �޼��带 �̿��� ���� �ֹ�
		//Customer�� order �޼��带 �̿��� ���̽� �ֹ�

		customer.order(noodle);
		customer.order(rice);
		//Customer�� ���� ������ ���
		//Customer�� ���ʽ����� ���

		System.out.println("���� ���� ���� " + customer.money+"�����Դϴ�.");
		System.out.println("���� ���ʽ� ������" + customer.point+"���Դϴ�.");

	}
}