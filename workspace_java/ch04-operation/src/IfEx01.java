
public class IfEx01 {
	public static void main(String[] args) {
		char ch = 'Y';
		
		/*
		 * [실습]ch가 대문자이면 "대문자입니다."
		 * ch가 소문자이면 "소문자입니다."
		 * ch가 대문자도 아니고 소문자도 아니면
		 * "기타문자입니다." 출력
		 */
		
		if(ch>= 65 && ch<=90) {
			System.out.println("대문자 입니다.");
		}else if(ch >=97 && ch<= 122) {
			System.out.println("소문자 입니다.");
		}else {
			System.out.println("기타문자입니다.");
		}
	}
}
