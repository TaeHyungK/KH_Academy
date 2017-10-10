
public class BreakMain02 {
	public static void main(String[] args) {
		for(int i=0;i<3;i++) {
			for(int j=0;j<5;j++) {
				//다중반복문에서는 break를 포함한 반복문만 탈출함.
				if(j==3)
					break;
				System.out.println(i +", " + j);
			}
		}
	}
}
