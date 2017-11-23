package my.product.domain;

import java.sql.Date;

public class ProductDto {
	private int num;
	private String name;
	private int price;
	private int stock;
	private String content; //상품 설명
	private Date reg_date;
	
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	@Override
	public String toString() {
		return "ProductDto [num=" + num + ", name=" + name + ", price=" + price + ", stock=" + stock + ", content="
				+ content + ", reg_date=" + reg_date + "]";
	}
	
	
}
