import java.util.Scanner;

public class ArrayEx03 {
	public static void main(String[] args) {
		/*
		 * [실습]학생의 성적을 입력한 후 
		 * 최고 점수와 평균 점수를 구하는 프로그램을 작성하시오.
		 * 
		 */
		
		Scanner input = new Scanner(System.in);
		
		int[] scores = new int[3];
		
		while(true) {
			System.out.println("----------------------------------");
			System.out.println("1.점수입력 | 2.점수리스트 | 3.분석 | 4.종료");
			System.out.println("----------------------------------");
			
			System.out.print("번호 입력> ");
			int mode = input.nextInt();
			
			if(mode==1) {
				for(int i=0;i<scores.length;i++) {
					System.out.print((i+1)+"번 학생 점수 입력: ");
					scores[i] = input.nextInt();
				}
			}else if(mode==2) {
				for(int i=0;i<scores.length;i++) {
					System.out.println((i+1)+"번 학생 점수: "+scores[i]);
				}
				
//				System.out.println("학생 점수 : " + scores[0]);
//				System.out.println("학생 점수 : " + scores[1]);
//				System.out.println("학생 점수 : " + scores[2]);
			}else if(mode==3) {
				int max = scores[0];
				int sum = 0;
				double avg = 0;
				//최고 점수 구하기
				for(int i=1;i<scores.length;i++) {
					if(scores[i] > max)
						max = scores[i];
				}
				//평균 점수 구하기
				for(int i=0;i<scores.length;i++) {
					sum += scores[i];
				}
				avg = sum/(double)scores.length;
				//최고 점수, 평균 점수 출력
				System.out.println("최고 점수: " +max);
				System.out.printf("평균 점수: %.2f\n",avg);
			}else if(mode==4) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}else {
				System.out.println("1~4를 입력하시오.");
			}
		}
		
	}
}
