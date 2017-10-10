
public class OperatorMain08 {
	public static void main(String[] args) {
		System.out.println("====삼항연산자====");
		
		int x =10, y=-10;
		
				    //조건식 ? 참일 때 : 거짓일 때
		int absX = (x>= 0) ? x : -x;
		int absY = (y>= 0) ? y : -y;
		
		System.out.println("x의 절대값: " + absX);
		System.out.println("y의 절대값: " + absY);
		
		
	}
}
