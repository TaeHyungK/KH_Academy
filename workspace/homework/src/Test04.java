
public class Test04 {
	public static void main(String[] args) {
		int java=80, jsp=85, android=90, oracle=70;
		int sum;
		double avg;
		
		sum = java+jsp+android+oracle;
		avg = sum/4.0;
		
		System.out.println("����: " + sum);
		System.out.printf("���: %.2f\n", avg);
	}
}
