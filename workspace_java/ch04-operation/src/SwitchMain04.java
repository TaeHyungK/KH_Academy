import java.util.Scanner;

public class SwitchMain04 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int score,score2;
		char grade;
		
		System.out.print("������ ���� �Է�> ");
		score = input.nextInt();
		
		if(score < 0 || score > 100) {
			System.out.println("�߸� �Է��߽��ϴ�.");
			System.exit(0);
		}
		switch(score/10) {
			case 10: case 9: 
				grade = 'A';
				break;
			case 8:
				grade = 'B';
				break;
			case 7:
				grade = 'C';
				break;
			case 6:
				grade = 'D';
				break;
			default :
				grade = 'F';
					
		}
		
		System.out.println("����: " + score + " \n����: " + grade);
		
	}
}
