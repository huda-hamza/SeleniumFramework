package data;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	static String  path = System.getProperty("user.dir");

	public Object[][] getExcelData() throws IOException 
	{

		XSSFWorkbook workbook;


		workbook = new XSSFWorkbook( path+"\\src\\test\\java\\data\\Book1.xlsx");
		XSSFSheet sheet = workbook.getSheetAt(0);
		int Totalnumberofrow=(sheet.getLastRowNum()+1);
		int Totalnumberofcolom =4;

		String[][] ArrayExcelData = new String[Totalnumberofrow][Totalnumberofcolom];

		for (int i = 0; i < Totalnumberofrow; i++) {
			for (int j = 0; j <Totalnumberofcolom ; j++) {

				ArrayExcelData[i][j]=sheet.getRow(i).getCell(j).toString();
			}

		}
		workbook.close();
		return ArrayExcelData;

	}





}


