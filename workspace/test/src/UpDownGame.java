import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UpDownGame {
	public static void main(String[] ar) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int random = 0;
		int usersel;
		int score = 0;
		while (true) {
			System.out.println(" === UP & DOWN ���� ===");
			System.out.println("1. Game Start");
			System.out.println("2. Game Score");
			System.out.println("3. End Game");
			System.out.print(">");
			int SSG = System.in.read() - 48;
			System.in.read();
			System.in.read();
			random = (int) (Math.random() * 99 + 1);

			switch (SSG) {
			case 1:
				System.out.println("<<  Game Start >>");
				while (true) {
					System.out.print("Input Number : ");
					usersel = Integer.parseInt(in.readLine());
					if (usersel < random) {
						System.out.println("<<   UP   >>");
					} else if (usersel > random) {
						System.out.println("<<   DOWN   >>");
					} else {
						System.out.println("<<   ����     >>");
						++score;
						break;
					}
				}
				break;
			case 2:
				System.out.println("<<  Game Score >>");
				System.out.println("<<���� �� �¸� : " + score + " �Դϴ�>>");
				break;
			case 3:
				System.out.println("������ �����ϰڽ��ϴ�.");
				System.exit(0);
			}

		}

	}
}