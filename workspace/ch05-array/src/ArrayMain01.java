
public class ArrayMain01 {
	public static void main(String[] args) {
		System.out.println("====�迭===="); //�迭 : ��������, ���� ���� �� ���� �Ұ���
		
		//�迭 ����
		char[] ch;
		//�迭 ���� -> �޸� �Ҵ�
		ch = new char[4];
		//�迭 �ʱ�ȭ
		ch[0] = 'J';
		ch[1] = 'a';
		ch[2] = 'V';
		ch[3] = 'a';
		
		//���
		System.out.println(ch[0]);
		System.out.println(ch[1]);
		System.out.println(ch[2]);
		System.out.println(ch[3]);
		System.out.println("----");
		
		//�ݺ��� �̿� ���
		for(int i=0;i<ch.length;i++) {
			System.out.println("ch["+i+"]:"+ch[i]);
		}
		
		//�迭 ����, ����
		int[] it = new int[6];

		//�迭 ����, ����, �ʱ�ȭ(����� �迭 ����)
		char[] ch2 = new char[]{'J','a','V','a'};

		//�迭 ����, ����, �ʱ�ȭ(�Ͻ��� �迭 ����)
		char[] ch3 = {'��', '��'};
		
	}
}
