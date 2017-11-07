
public class ArrayMain11 {
	public static void main(String[] args) {
		System.out.println("====2차원 배열====");
		
		//2차원 배열 선언
		int test[][];
		//2차원 배열 생성
		test = new int[2][3];
		//2차원 배열 초기화
		test[0][0] = 100;
		test[0][1] = 200;
		test[0][2] = 300;
		
		test[1][0] = 400;
		test[1][1] = 500;
		test[1][2] = 600;
				
		//출력
		System.out.println(test[0][0]);
		System.out.println(test[0][1]);
		System.out.println(test[0][2]);

		System.out.println(test[1][0]);
		System.out.println(test[1][1]);
		System.out.println(test[1][2]);
		
		System.out.println("* 반복문이용출력 *");
		for(int i=0;i<test.length;i++) {
			for(int j=0;j<test[i].length;j++) {
				System.out.println("test[" + i + "][" + j + "] :" + test[i][j]);
			}
		}
		System.out.println("---------------");
		
		//배열 선언 및 생성
		int[][] test2 = new int[4][5];
		
		//배열 선언, 생성,초기화(명시적 배열 생성)
		int[][] test3 = new int[][] {{10,20,30},{40,50,60}};
		
		//배열 선언, 생성,초기화(암시적 배열 생성)
		int[][] test4 = {{100,200,300}
						,{400,500,600}};
		
	}
}
