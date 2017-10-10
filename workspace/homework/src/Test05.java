
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

		System.out.printf("%s: %d\n", "지불한 돈", payment);
		System.out.printf("%s: %d\n", "카페 모카 단가", price);
		System.out.printf("%s: %d\n", "수량", quantity);
		System.out.printf("%s: %.0f\n", "부가세", bugase);
		System.out.printf("%s: %d\n", "상품 총액", total);
		System.out.printf("%s: %d\n", "거스름돈", balance);
		
		
		
	}
}
