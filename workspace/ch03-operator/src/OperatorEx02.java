
public class OperatorEx02 {
	public static void main(String[] args) {
		/*
		 * [�ǽ�]534�ڷ��� ������ 30���� �л��鿡�� �Ȱ��� ������ ������ �� ��
		 * �л��� �� ���� ���� �� �ְ�, ���������� �� ���� �������� ���Ͻÿ�
		 *
		 * ���� = pencils, �л��� = students
		 * �л� �� ��� ������ ���� �� = qauntity
		 * ���� ���� �� = rest
		 * 
		 * ��� ����
		 * -------
		 * �л� �� ���� ������ ���� �� :
		 * ���� ���� �� :
		 */
		
		int pencils = 534, students = 30;
		int qauntity = pencils / students;
		int rest = pencils % students;
		
		System.out.println("�л� �� ���� ������ ���� ��: " + qauntity);
		System.out.println("���� ���� ��: " + rest);
		
		
	}
}
