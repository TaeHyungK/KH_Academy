
class Music{
	private String category;
	private String name;
	private double price;
	private double discountRate;

	//�����ڸ� �̿��ؼ� �����͸� ������ �� �ֵ��� ������ ���
	public Music(String category, String name, double price, double discountRate) {
		this.category = category;
		this.name = name;
		this.price = price;
		this.discountRate = discountRate;
	}

	//getter, setter �޼ҵ�
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getDiscountRate() {
		return discountRate;
	}
	public void setDiscountRate(double discountRate) {
		this.discountRate = discountRate;
	}
}

public class ArrayEx05 {
	public static void main(String[] args) {
		/*[�ǽ�����]
		 * �迭�� ��ü�� �����ϰ� ������ ȣ��
		 * �迭�� ���̴� 5
		 * �迭�� ��ü�� ������ ���� �����ڸ� �̿��ؼ� ������ ����
		 * ��� ����
		 * �� ��ħ���� 5000 5.0
		 * ��ȭ �������� 4000 10.0
		 */
		
		Music[] arrayMusic = new Music[5];
		
		arrayMusic[0] = new Music("��", "��ħ����", 5000.0, 5.0);
		arrayMusic[1] = new Music("��ȭ", "��������", 4000.0, 10.0);
		arrayMusic[2] = new Music("����", "�ڳ���", 2000, 7.0);
		arrayMusic[3] = new Music("�Ʊ�", "���̺�", 5000.0, 8.0);
		arrayMusic[4] = new Music("����", "�ູ", 10000.0, 9.0);
		
		
		for(Music a : arrayMusic) {
			System.out.printf("%s\t%s\t%.1f\t%.1f%%", a.getCategory(), a.getName(), a.getPrice(), a.getDiscountRate());
			System.out.println();
		}



	}
}
