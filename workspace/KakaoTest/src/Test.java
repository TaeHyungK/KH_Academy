import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Scanner;

/*
 * ���ڸ� 1 2 3 ���·� �Է¹޾�
 * �Է� ���� ���ڸ� ���� ū ���� ����, ���� ���� ���� �����Ͽ� �� ���� ���
 */
public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<Integer>();

		String input = sc.nextLine();

		String[] sp = input.split(" ");
		for (int i = 0; i < sp.length; i++) {
			list.add(Integer.parseInt(sp[i]));
		}
		
		Ascending ascending = new Ascending();
		list.sort(ascending);
		
		//��������
		StringBuffer as = new StringBuffer("");
		for(int i=0;i<list.size();i++) {
			as.append(list.get(i).toString());
		}
		
		int a = Integer.parseInt(as.toString());
		
		//��������
		Descending descending = new Descending();
		list.sort(descending);
		
		StringBuffer ds = new StringBuffer("");
		for(int i=0;i<list.size();i++) {
			ds.append(list.get(i).toString());
		}
		
		int b = Integer.parseInt(ds.toString());
		
		System.out.println(a+b);
		
	}

}

// ��������
class Ascending implements Comparator<Integer> {
	@Override
	public int compare(Integer o1, Integer o2) {
		return o1.compareTo(o2);
	}

}

//��������
class Descending implements Comparator<Integer> {
 @Override
 public int compare(Integer o1, Integer o2) {
     return o2.compareTo(o1);
 }

}

