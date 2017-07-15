package excel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class WriteExcel {

	@Test
	public void readExcel() throws InvalidFormatException, IOException{

		File src = new File("./data/login.xlsx");

		//Create a blank WorkBook
		XSSFWorkbook workbook = new XSSFWorkbook();

		//Go to Sheet
		XSSFSheet sheet = workbook.createSheet("Report");


		XSSFRow row = sheet.createRow(0);

		XSSFCell cell = row.createCell(0);

		cell.setCellValue("Testcase Id");

		XSSFCell cell1 = row.createCell(1);

		cell1.setCellValue("Testcase Name");

		XSSFCell cell2 = row.createCell(2);

		cell2.setCellValue("Testcase Desc");

		XSSFCell cell3 = row.createCell(3);

		cell3.setCellValue("Status");

		
		FileOutputStream fos = new FileOutputStream(new File("./reports/report.xlsx"));
		workbook.write(fos);
		
		// 
		fos.close();
		workbook.close();
		
		LearnEnum val = LearnEnum.PASS;
		

	}

}


























