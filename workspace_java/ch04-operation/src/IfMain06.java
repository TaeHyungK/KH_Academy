
public class IfMain06 {
	public static void main(String[] args) {
		int a = 10;
		float b = 10.0f;
		
		if(a == b) { //10 -> 10.0f �ڵ� ����ȯ �Ͼ
			System.out.println("10�� 10.0f�� ����.");
		}
		
		char c = '0';
		int d = 0;
		
		if(c != d) { //'0' -> 48 �ڵ� ����ȯ
			System.out.println("'0'�� 0�� ���� �ʴ�.");
		}
		
		char e = 'A';
		int f = 65;
		if(e == f) { //'A' -> 65 �ڵ� ����ȯ
			System.out.println("'A'�� 65�� ����.");
		}
				
	}
}
