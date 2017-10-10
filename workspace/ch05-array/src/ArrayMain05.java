
public class ArrayMain05 {
	public static void main(String[] args) {
		
		//배열 선언과 생성
		String[] array = new String[3];
		
		//배열 초기화
		array[0]= "Java";
		array[1]= "Jsp";
		array[2]= "Android";
		
		for(int i=0;i<array.length;i++) {
			System.out.println(array[i]);
		}
				
	}
}
