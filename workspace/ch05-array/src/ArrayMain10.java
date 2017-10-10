
public class ArrayMain10 {
	public static void main(String[] args) {
		//배열 선언,생성,초기화
		int[] array = {10,20,30,40,50};
		
		for(int i=0;i<array.length;i++) {
			System.out.println("array[" + i + "]: " + array[i]);
		}
		System.out.println("------------");
		
		//확장된 for문(개선된 루프)
		//JDK5.0이상부터 지원
		//  배열의요소     배열명
		for(int a : array) {
			System.out.println(a);
		}
	}
}
