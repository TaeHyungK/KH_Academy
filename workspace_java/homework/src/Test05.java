
public class Test05 {
	public static void main(String[] args) {
		int payment, price, quantity, total, balance;
		double bugase;
		
		payment = 10000;
		price = 3500;
		quantity = 2;
		bugase = price*quantity*0.1;
		total = price*quantity+(int)bugase;
		balance = payment - total;

		System.out.printf("%s: %d\n", "������ ��", payment);
		System.out.printf("%s: %d\n", "ī�� ��ī �ܰ�", price);
		System.out.printf("%s: %d\n", "����", quantity);
		System.out.printf("%s: %.0f\n", "�ΰ���", bugase);
		System.out.printf("%s: %d\n", "��ǰ �Ѿ�", total);
		System.out.printf("%s: %d\n", "�Ž�����", balance);
		
		
		
	}
}
