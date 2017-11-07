
public class BreakMain03 {
	public static void main(String[] args) {
		
		exit_for: //레이블 설정
		for(int i=0;i<3;i++) {
			for(int j=0;j<5;j++) {
				if(j==3)
					//레이블을 지정한 for문을 빠져나감
					break exit_for;
				System.out.println(i +", " + j);
			}
		}
	}
}
