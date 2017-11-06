
import java.util.ArrayList;
import java.util.Scanner;

public class Imji {
	public static void main(String[] args) {
		int a;
		int b;
		int c;
		int cnt_0 = 0;
		int cnt_1 = 0;
		int cnt_2 = 0;
		int cnt_3 = 0;
		int cnt_4 = 0;
		int cnt_5 = 0;
		int cnt_6 = 0;
		int cnt_7 = 0;
		int cnt_8 = 0;
		int cnt_9 = 0;

		Scanner sc = new Scanner(System.in);

		a = sc.nextInt();

		b = sc.nextInt();

		c = sc.nextInt();

		int result = a*b*c;
		int result_Num;

		for (int i = 0; i < String.valueOf(result).length(); i++) {
			result_Num = String.valueOf(result).charAt(i);
			if(result_Num == '0') {
				cnt_0++;
			}else if(result_Num == '1') {
				cnt_1++;
			}else if(result_Num == '2') {
				cnt_2++;
			}else if(result_Num == '3') {
				cnt_3++;
			}else if(result_Num == '4') {
				cnt_4++;
			}else if(result_Num == '5') {
				cnt_5++;
			}else if(result_Num == '6') {
				cnt_6++;
			}else if(result_Num == '7') {
				cnt_7++;
			}else if(result_Num == '8') {
				cnt_8++;
			}else if(result_Num == '9') {
				cnt_9++;
			}         
		}
		System.out.println(cnt_0);
		System.out.println(cnt_1);
		System.out.println(cnt_2);
		System.out.println(cnt_3);
		System.out.println(cnt_4);
		System.out.println(cnt_5);
		System.out.println(cnt_6);
		System.out.println(cnt_7);
		System.out.println(cnt_8);
		System.out.println(cnt_9);
	}   
}
