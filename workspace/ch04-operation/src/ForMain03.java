
public class ForMain03 {
	public static void main(String[] args) {
		int sum =0;
		for(int i=0;i<=100;i++) {
//			if(i%2==0)//짝수의 합
				sum += i; //누적, sum = sum + i
		}
		System.out.println("1부터 100까지의 합 : "+sum);
		
	}
}
