import java.util.Scanner;

public class IfMain05 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int score;
		char grade;
		
		System.out.print("己利 涝仿> ");
		score = input.nextInt();
		
		if(score >=90 && score <= 100) {
			grade = 'A';
		}else if(score >=80 && score <= 89) {
			grade = 'B';
		}else if(score >=70 && score <= 79) {
			grade = 'C';
		}else if(score >=60 && score <= 69) {
			grade = 'D';
		}else if(score >=0 && score <= 59) {
			grade = 'F';
		}else {
			grade = '?';
		}
		
		System.out.println("己利: " + score + "\n" + "切痢: " + grade);
	}
}
