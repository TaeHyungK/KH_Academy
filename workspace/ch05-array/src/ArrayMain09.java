import java.util.Arrays;

public class ArrayMain09 {
	public static void main(String[] args) {
		
		//문자 사전순으로 정렬
		char[] a= {'z','c','e','a','q'};
		Arrays.sort(a);
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println("\n---------");
		
		int[] a2= {89,39,5,2,1,6,0};
		//정수 오름차순 정렬
		Arrays.sort(a2);
		for(int i=0;i<a2.length;i++) {
			System.out.print(a2[i] + " ");
		}
		System.out.println("\n---------");
		
		String[] a3 = {"java","jsp","spring","android","html"};
		//문자열 사전순 정렬
		Arrays.sort(a3);
		for(int i=0;i<a3.length;i++) {
			System.out.print(a3[i] + " ");
		}
		System.out.println("\n---------");
		
		
	}
}
