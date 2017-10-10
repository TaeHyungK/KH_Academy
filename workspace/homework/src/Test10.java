
public class Test10 {
	public static void main(String[] args) {
//		1)
		for(int i=10;i>=0;i--) {
			System.out.printf("%d", i);
		}
		
		System.out.println("\n----------");
		
//		2)
		for(int i=0; i<=10;i+=3) {
			if(i%5==0) {
				System.out.printf("%5d",i);
			}
		}
		
	}
}
