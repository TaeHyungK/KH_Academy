import java.util.*;

public class KaKao01 {
	public static void main(String[] args) {
		int[] arr = {4,1,3,1};
		
		solution(arr);
		System.out.println(solution(arr));
		
	}

	public static boolean solution(int[] arr) {
        boolean answer = true;
        Arrays.sort(arr); 
        System.out.println(Arrays.toString(arr));
        
        for(int i=0; i<arr.length; i++) {
        	for(int j=0; j<arr.length; j++) {
        		if(i==j) continue;
        		if(arr[i] == arr[j]) {
        			answer = false;
        		}
        	}
        }
       
        return answer;
    }

	
}
