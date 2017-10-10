import java.util.Scanner;

public class Manhyuk {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		String n = scan.nextLine();

		int N = Integer.parseInt(n);
		int[][] arr = new int[N][N];


		StringBuffer sb = new StringBuffer();
		for (int i =0 ; i< N; i++){
			String s = scan.nextLine();
			sb.append(s);
			sb.append(' ');
		}

		String[] input = sb.toString().split(" ");

		int count =0;

		for (int i =0 ; i<N;i++){
			for(int j =0 ; j<N;j++) {
				arr[i][j] = Integer.parseInt(input[count]);
				count++;

				System.out.print(arr[i][j]+ " ");
			}
		} // 배열에 값넣기
		System.out.println();


		int[][] transp = new int[N][N];
		for (int i = 0; i<N;i++){ // i=0
			for (int j =0 ; j < N ; j++){ // i=0 j=1;
				transp[i][j]=arr[j][i];

				if(j==N-1) {
					System.out.print(transp[i][j]);
					System.out.println();
				}else {
					System.out.print(transp[i][j]+ " ");
				}
				
			}
		}


	}
}

