
public class ArrayMain11 {
	public static void main(String[] args) {
		System.out.println("====2���� �迭====");
		
		//2���� �迭 ����
		int test[][];
		//2���� �迭 ����
		test = new int[2][3];
		//2���� �迭 �ʱ�ȭ
		test[0][0] = 100;
		test[0][1] = 200;
		test[0][2] = 300;
		
		test[1][0] = 400;
		test[1][1] = 500;
		test[1][2] = 600;
				
		//���
		System.out.println(test[0][0]);
		System.out.println(test[0][1]);
		System.out.println(test[0][2]);

		System.out.println(test[1][0]);
		System.out.println(test[1][1]);
		System.out.println(test[1][2]);
		
		System.out.println("* �ݺ����̿���� *");
		for(int i=0;i<test.length;i++) {
			for(int j=0;j<test[i].length;j++) {
				System.out.println("test[" + i + "][" + j + "] :" + test[i][j]);
			}
		}
		System.out.println("---------------");
		
		//�迭 ���� �� ����
		int[][] test2 = new int[4][5];
		
		//�迭 ����, ����,�ʱ�ȭ(����� �迭 ����)
		int[][] test3 = new int[][] {{10,20,30},{40,50,60}};
		
		//�迭 ����, ����,�ʱ�ȭ(�Ͻ��� �迭 ����)
		int[][] test4 = {{100,200,300}
						,{400,500,600}};
		
	}
}
