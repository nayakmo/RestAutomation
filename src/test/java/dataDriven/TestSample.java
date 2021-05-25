package dataDriven;

import java.io.IOException;
import java.util.ArrayList;

public class TestSample {
	
	public static void main(String[] args) throws IOException {
		 ExcelData ed = new ExcelData();
		 ArrayList<String> a = ed.getData("purchase");
		 System.out.println(a.get(0));
			System.out.println(a.get(1));
			System.out.println(a.get(2));
			System.out.println(a.get(3));
	}
}