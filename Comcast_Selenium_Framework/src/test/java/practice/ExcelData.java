package practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelData {

	public static void main(String[] args) throws EncryptedDocumentException, IOException, InvalidFormatException {
		// TODO Auto-generated method stub

		FileInputStream fise=new FileInputStream("./data/testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fise);
		String orgName = wb.getSheet("sheet1").getRow(0).getCell(0).getStringCellValue();
		System.out.println(orgName);
	}

}
