package array;

import java.util.HashMap;
import java.util.Iterator;

public class Test4 {
	public static void main(String[] args) {
		HashMap<String, Book> map = new HashMap<String, Book>();
		
		String[] key = {"å1", "å2", "å3", "å4", "å5"};
		Book[] book = {new Book("IT", "SQL Plus", 50000, 5),
				new Book("IT", "Java 2.0", 40000, 3),
				new Book("IT", "JSP Servlet", 60000, 6),
				new Book("Nobel", "davincicode", 30000, 10),
				new Book("Nobel", "cloven hoof", 50000, 15)
		};
		
		
		for(int i=0; i<book.length;i++) {
			map.put(key[i], book[i]);
		}
		
		Iterator<String> keys = map.keySet().iterator();
		for(String tempKey : map.keySet()) {
			System.out.println(tempKey + " = " + map.get(tempKey).toString());
		}
		

	}
}
