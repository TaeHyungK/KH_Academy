
class Music{
	private String category;
	private String name;
	private double price;
	private double discountRate;

	//생성자를 이용해서 데이터를 셋팅할 수 있도록 생성자 명시
	public Music(String category, String name, double price, double discountRate) {
		this.category = category;
		this.name = name;
		this.price = price;
		this.discountRate = discountRate;
	}

	//getter, setter 메소드
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
		/*[실습문제]
		 * 배열에 객체를 저장하고 정보를 호출
		 * 배열의 길이는 5
		 * 배열에 객체를 저장할 때는 생성자를 이용해서 데이터 셋팅
		 * 출력 예시
		 * 댄스 아침부터 5000 5.0
		 * 영화 가을여행 4000 10.0
		 */
		
		Music[] arrayMusic = new Music[5];
		
		arrayMusic[0] = new Music("댄스", "아침부터", 5000.0, 5.0);
		arrayMusic[1] = new Music("영화", "가을여행", 4000.0, 10.0);
		arrayMusic[2] = new Music("동물", "코끼리", 2000, 7.0);
		arrayMusic[3] = new Music("아기", "베이비", 5000.0, 8.0);
		arrayMusic[4] = new Music("가족", "행복", 10000.0, 9.0);
		
		
		for(Music a : arrayMusic) {
			System.out.printf("%s\t%s\t%.1f\t%.1f%%", a.getCategory(), a.getName(), a.getPrice(), a.getDiscountRate());
			System.out.println();
		}



	}
}
