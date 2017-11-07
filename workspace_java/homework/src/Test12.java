
public class Test12 {
	public static void main(String[] args) {
		int sum=1;
		for(int i=1;i<=10;i++) {
			if(i%2 ==0) {
				sum *= i;
			}
		}
		
		System.out.println("1ºÎÅÍ 10±îÁö Â¦¼öÀÇ °ö: " + sum);
	}
}
