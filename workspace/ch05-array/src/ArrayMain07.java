
public class ArrayMain07 {
	/*
	 * 클래스를 실행시키면 main메소드가 동작하고 클래스 외부에서 
	 * 데이터를 전달할 수 있는데 외부에서 전달한 데이터는 배열을 생성해서
	 * 보관하고 생성된 배열은 main메소드의 인자에 전달됨.
	 * 클래스 외부에서 데이터를 전달하지 않아도 비어있는 배열을 생성해서
	 * main메소드의 인자에 전달됨.
	 */
	public static void main(String[] args) {
		if (args.length > 0) { // 데이터가 전달된 경우
			for (int i = 0; i < args.length; i++) {
				System.out.println(args[i]);
			}
		}else { //args.length == 0 즉, 전달된 데이터가 없는 경우
			System.out.println("입력한 내용이 없습니다.");
		}
	}

}
