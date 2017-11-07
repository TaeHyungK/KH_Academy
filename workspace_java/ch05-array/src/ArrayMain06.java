import java.util.Scanner;

public class ArrayMain06 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		String[] subName = { "±¹¾î", "¿µ¾î", "¼öÇÐ" };
		int[] sub = new int[subName.length];
		int sum = 0;
		float avg = 0.0f;

		for (int i = 0; i < sub.length; i++) {
			do {
				System.out.print(subName[i] + ": ");
				sub[i] = input.nextInt();
			} while (sub[i] > 100 || sub[i] < 0);

			sum += sub[i];
		}
		avg = (float) sum / sub.length;
		System.out.println();
		for (int i = 0; i < sub.length; i++) {
			System.out.printf("%s= %d\n", subName[i], sub[i]);
		}
		System.out.println("--------");
		System.out.printf("ÃÑÁ¡= %d\n", sum);
		System.out.printf("Æò±Õ= %.2f\n", avg);

	}
}
