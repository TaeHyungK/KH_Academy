
public class ArrayMain10 {
	public static void main(String[] args) {
		//�迭 ����,����,�ʱ�ȭ
		int[] array = {10,20,30,40,50};
		
		for(int i=0;i<array.length;i++) {
			System.out.println("array[" + i + "]: " + array[i]);
		}
		System.out.println("------------");
		
		//Ȯ��� for��(������ ����)
		//JDK5.0�̻���� ����
		//  �迭�ǿ��     �迭��
		for(int a : array) {
			System.out.println(a);
		}
	}
}
