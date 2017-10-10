
public class OperatorMain06 {
	public static void main(String[] args) {
		System.out.println("====논리연산자====");
		
		boolean a,b,result;
		a = true;
		b = false;
		
		//논리곱
		result = a && b;
		System.out.println("a && b : "+ result);
		
		//논리합
		result = a || b;
		System.out.println("a || b : " + result);
		
		//부정
		result = !a;
		System.out.println("!a : " + result);
		
		
	}
}
