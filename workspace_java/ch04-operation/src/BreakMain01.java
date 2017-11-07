
public class BreakMain01 {
	public static void main(String[] args) {
		int n=1;
		while(n<=10) {
			System.out.println(n);
			n++;
			if(n==8)
				//특정 조건일때 반복문을 빠져나가는 제어문
				break;
		}
	}
}
