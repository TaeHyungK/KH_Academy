
public class BreakMain03 {
	public static void main(String[] args) {
		
		exit_for: //���̺� ����
		for(int i=0;i<3;i++) {
			for(int j=0;j<5;j++) {
				if(j==3)
					//���̺��� ������ for���� ��������
					break exit_for;
				System.out.println(i +", " + j);
			}
		}
	}
}
