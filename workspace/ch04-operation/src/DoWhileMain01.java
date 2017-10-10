
public class DoWhileMain01 {
	public static void main(String[] args) {
		int su=0;
		String str = "Hello World!";
		
		do {
			System.out.println(str);
		}while(su++ < 5);
		
		System.out.println("----------");
		su = 0;
		while(su++ < 5) {
			System.out.println(str);
		}
	}
}
