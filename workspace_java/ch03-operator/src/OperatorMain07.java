
public class OperatorMain07 {
	public static void main(String[] args) {
		System.out.println("====���ƿ���====");
		//����������, �񱳿�����, ��������
		
		int a,b;
		a = b = 10;
		
		boolean c = a++ >= ++b && ++a > b++;
		System.out.println(a + ", " + b + " : " + c);
		
		int d,e;
		d = e = 10;
		
		boolean f = ++d < e++ || d++ >= ++e;
		System.out.println(d + ", " + e + " : " + f);
		
		
	}
}
