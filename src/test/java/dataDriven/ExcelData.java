package dataDriven;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.formula.functions.Rows;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {
	
		
		public ArrayList<String> getData(String getTestCase) throws IOException {
			ArrayList<String> al = new ArrayList<String>();
			
			FileInputStream fis = new FileInputStream("F:\\sdet\\Rest\\TestData.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			int noofsheets = workbook.getNumberOfSheets();
			for(int i=0; i<noofsheets; i++) {
				if(workbook.getSheetName(i).equalsIgnoreCase("data")) {
				XSSFSheet sheet = workbook.getSheetAt(i);
			    Iterator<Row> rows = sheet.iterator();
			    Row firstRow = rows.next();
			    Iterator<Cell> cel = firstRow.cellIterator();
			    int k = 0;
			    int coulumn = 0 ;
			    while(cel.hasNext()) {
			    	Cell value = cel.next();
			    	if(value.getStringCellValue().equalsIgnoreCase("testcase")) {
			    		
			    	}
			    	k++;
			    }
			    System.out.println(coulumn);
			    
			    while(rows.hasNext()) {
			    	Row r = rows.next();
			    	if(r.getCell(coulumn).getStringCellValue().equalsIgnoreCase("purchase")){
			    		Iterator<Cell> cv  = r.cellIterator();
			    		while(cv.hasNext()) {
			    			System.out.println(cv.next().getStringCellValue());
			    			al.add(cv.next().getStringCellValue());
			    			
			    		}
			    	}
			    	
			    	
			    }
			    
			    }
			}
			return al;	
		}
		public static void main(String args[]) {
			
	}

}
