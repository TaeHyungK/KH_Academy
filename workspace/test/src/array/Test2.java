package array;

class Book {
   private String category;
   private String name;
   private double price;
   private double discountRate;

   public Book(String category, String name, double price, double discountRate) {
      this.category = category;
      this.name = name;
      this.price = price;
      this.discountRate = discountRate;
   }

   public Book() {}

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

public class Test2 {
   public static void main(String[] args) {
      Book[] bookArray = new Book[5];
      double sum = 0;

      bookArray[0] = new Book("IT", "SQL Plus", 50000, 5);
      bookArray[1] = new Book("IT", "Java 2.0", 40000, 3);
      bookArray[2] = new Book("IT", "JSP Servlet", 60000, 6);
      bookArray[3] = new Book("Nobel", "davincicode", 30000, 10);
      bookArray[4] = new Book("Nobel", "cloven hoof", 50000, 15);      
            
      for(Book b : bookArray) {
    	  System.out.printf("%s\t%s\t%.0f\t%.1f%%\n", b.getCategory(), b.getName(), b.getPrice(),b.getDiscountRate());
          sum += b.getPrice();
      }
      System.out.printf("\n책 가격의 합: %.1f원", sum);
      
      
   }
}