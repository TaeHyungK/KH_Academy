
public class PrintMain02 {
	public static void main(String[] args) {
		/*
		 * System.out.printf()를 이용한 출력
		 * 데이터의 종류를 표시할 수 있는 포맷 문자 지원
		 * JDK5.0 이상 부터 사용 가능
		 * 
		 * System.out.printf(포맷문자, 데이터)
		 */
		
		//문자
		//               포맷문자, 데이터
		System.out.printf("%c\n", 'A');
		//☆6자리 확보 오른쪽에 정렬
		System.out.printf("%6c\n", 'B');
		//☆6자리 확보 왼쪽에 정렬
		System.out.printf("%-6c\n", 'C');
		
		System.out.println("------------");
		
		//정수
		System.out.printf("%d\n", 67);
		//☆3자리 단위로 쉼표 표시
		System.out.printf("%,d원\n", 10000000);
		//5자리를 잡고 오른쪽부터 표시
		System.out.printf("%5d\n", 20);
		//5자리를 잡고 왼쪽부터 표시
		System.out.printf("%-5d\n", 20);
		//5자리를 잡고 오른쪽부터 빈칸을 0으로 채우기
		System.out.printf("%05d\n", 20);
		
		System.out.println("------------");
		
		//8진수
		System.out.printf("%o\n", 17);
		//16진수
		System.out.printf("%x\n", 20);

		System.out.println("------------");
		
		//실수
		//기본 소숫점 자리: 6자리, 빈칸은 0으로 표시
		System.out.printf("%f%n", 35.896);
		//☆소숫점 둘째자리까지 출력 , 소숫점 기준 이하 자리는 반올림
		System.out.printf("%.2f%n", 23000.879);

		System.out.println("------------");
		
		//문자열
		System.out.printf("%s%n", "우주");
	
		//문자열과 숫자
		System.out.printf("%s는 %d점입니다.%n", "점수", 98);

		System.out.println("------------");
	
		//논리값
		System.out.printf("%b%n", true);
		System.out.printf("%b%n", false);
		
		
	}
}
