package ncs.test2;

public class CustomerMain {
	public static void main(String[] args) {
		Customer customer = new Customer();
		Noodle noodle = new Noodle();
		Rice rice = new Rice();
		//Customer의 order 메서드를 이용해 누들 주문
		//Customer의 order 메서드를 이용해 라이스 주문

		customer.order(noodle);
		customer.order(rice);
		//Customer의 현재 남은돈 출력
		//Customer의 보너스점수 출력

		System.out.println("현재 남은 돈은 " + customer.money+"만원입니다.");
		System.out.println("현재 보너스 점수는" + customer.point+"점입니다.");

	}
}