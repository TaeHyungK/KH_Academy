package array;

import java.io.BufferedReader;
import java.io.FileReader;

public class Test3 {
	public void fileOpen(String fileName) {
		try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			String line= "";
			
			while((line=br.readLine()) != null) {
				System.out.println(line);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Test3 test = new Test3();
		test.fileOpen("text2.txt");
	}
	
	
}
