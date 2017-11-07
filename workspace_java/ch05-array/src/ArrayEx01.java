
public class ArrayEx01 {
	public static void main(String[] args) {
		/*
		 * [실습] 1. 10,20,30,40,50을 초기값으로 갖는 1차원 배열 test 이름으로 선언, 생성, 초기화 2. test 배열의 요소를
		 * 출력하시오. (반복문 이용) 3. 인덱스 3의 데이터를 100으로 변경하시오. 4. 마지막 요소의 값을 200으로 변경하시오. 5.
		 * 반복문을 사용하여 모든 요소의 값을 0으로 초기화하시오. 6. 홀수 인덱스에 10을 저장, 짝수 인덱스에 20을 저장
		 */

		int[] test = { 10, 20, 30, 40, 50 };
		for (int i = 0; i < test.length; i++) {
			System.out.println("test[" + i + "]: " + test[i]);
		}

		System.out.println("----------");

		test[3] = 100;
		test[test.length - 1] = 200;
		for (int i = 0; i < test.length; i++) {
			System.out.println("test[" + i + "]: " + test[i]);
		}

		System.out.println("----------");

		for (int i = 0; i < test.length; i++) {
			test[i] = 0;
			System.out.println("test[" + i + "]: " + test[i]);
		}

		for (int i = 0; i < test.length; i++) {
			if (i % 2 == 1)
				test[i] = 10;
			
			else
				test[i] = 20;
			System.out.println("test[" + i + "]: " + test[i]);
		}

	}
}
