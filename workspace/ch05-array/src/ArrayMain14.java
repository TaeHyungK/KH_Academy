
public class ArrayMain14 {
	public static void main(String[] args) {
		int[][] array = new int[9][8];
		
		for(int i=0;i<array.length;i++) { //i는 곱해질 숫자: 1~9
			for(int j=0;j<array[i].length;j++) { //j는 단: 2~9
				array[i][j]= (j+2)*(i+1);
				System.out.print((j+2)+"*"+(i+1)+"="+array[i][j]+"\t");
			}
			System.out.println();
		}
	}
}
