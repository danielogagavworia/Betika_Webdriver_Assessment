package step_definition;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import pageObject.Login_pom;



public class Login_sd extends Login_pom{
	
	public void navigate_to_login_page_and_enter_details(String phoneNumber, String passWord) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		click_On_Home_Page_Register_Button();
		enter_PhoneNumber(phoneNumber);
		enter_Password(passWord);
		click_On_login_Button();
		}
	
	
	
	@DataProvider(name="logintestdata")
	public String[][] getLoginDetails() throws EncryptedDocumentException, IOException {
		File excelfile = new File(
				System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\logintestdata.xlsx");
		FileInputStream fileInputStream= new FileInputStream(excelfile);
		Workbook wb = WorkbookFactory.create(fileInputStream);
		Sheet sheetName = wb.getSheet("Sheet1");
		
		int totalRows = sheetName.getLastRowNum();
		Row cells_in_the_row= sheetName.getRow(0);
		int totalColumns= cells_in_the_row.getLastCellNum();
		
		DataFormatter format= new DataFormatter();
		String testdata[][]= new String[totalRows][totalColumns];
		
		for(int i=1; i<=totalRows; i++) {
			for(int j=0 ; j <totalColumns; j++) {
				testdata[i-1][j]=format.formatCellValue(sheetName.getRow(i).getCell(j));
			}
		}
		return testdata;
	}
}
