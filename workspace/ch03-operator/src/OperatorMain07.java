
public class OperatorMain07 {
	public static void main(String[] args) {
		System.out.println("====숏컷연산====");
		//증감연산자, 비교연산자, 논리연산자
		
		int a,b;
		a = b = 10;
		
		boolean c = a++ >= ++b && ++a > b++;
		System.out.println(a + ", " + b + " : " + c);
		
		int d,e;
		d = e = 10;
		
		boolean f = ++d < e++ || d++ >= ++e;
		System.out.println(d + ", " + e + " : " + f);
		
		
	}
}
