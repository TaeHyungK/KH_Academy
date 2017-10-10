
public class ArrayMain12 {
	public static void main(String[] args) {
		int[][] array = {{10,20,30,40}
						,{50,60,70,80}};
		
		for(int i=0;i<array.length;i++) {
			for(int j=0;j<array[i].length;j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
		
	}
}
