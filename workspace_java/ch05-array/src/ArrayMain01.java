
public class ArrayMain01 {
	public static void main(String[] args) {
		System.out.println("====배열===="); //배열 : 고정길이, 길이 선택 후 수정 불가능
		
		//배열 선언
		char[] ch;
		//배열 생성 -> 메모리 할당
		ch = new char[4];
		//배열 초기화
		ch[0] = 'J';
		ch[1] = 'a';
		ch[2] = 'V';
		ch[3] = 'a';
		
		//출력
		System.out.println(ch[0]);
		System.out.println(ch[1]);
		System.out.println(ch[2]);
		System.out.println(ch[3]);
		System.out.println("----");
		
		//반복문 이용 출력
		for(int i=0;i<ch.length;i++) {
			System.out.println("ch["+i+"]:"+ch[i]);
		}
		
		//배열 선언, 생성
		int[] it = new int[6];

		//배열 선언, 생성, 초기화(명시적 배열 생성)
		char[] ch2 = new char[]{'J','a','V','a'};

		//배열 선언, 생성, 초기화(암시적 배열 생성)
		char[] ch3 = {'자', '바'};
		
	}
}
