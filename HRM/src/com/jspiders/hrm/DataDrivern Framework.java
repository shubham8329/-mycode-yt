package Orange_HRM_Project;

import java.io.File;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class ExcelDataDemo1 {
	
	XSSFWorkbook wb;
    XSSFSheet sheet1;
    
    
    public ExcelDataDemo1(String excelpath) {
    	
    	try
    	{
    	
    	File src=new File(excelpath);
    	FileInputStream fis=new FileInputStream(src);
    	wb=new XSSFWorkbook(fis);
    	}
    	catch(Exception e)
    	{
    		
    		System.out.println(e);
    	}
    	
    }
    
    public String getData(int sheetnumber,int row,int col) {
    	
    	sheet1=wb.getSheetAt(sheetnumber);
    	String data=sheet1.getRow(row).getCell(col).getStringCellValue();
        return data;
    	
    	
    }
    
    public int getRowCount(int sheetIndex) {
		
    	int  row=wb.getSheetAt(sheetIndex).getLastRowNum();
    	
    	row= row + 1;
    	return row;
    	
    	
    }
    
	

}


<----Data Driver FrameWork Admin Status Check--->

package Orange_HRM_Project;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo1 {
	
	WebDriver driver;
	@Test(dataProvider="Orng HRM")
	
	public void OpenBrowser(String username,String password) {
		 
		System.setProperty("webdriver.driver", "C:\\Users\\user\\Downloads\\chromedriver_win32 (1)");
		driver=new ChromeDriver();
		String url="https://opensource-demo.orangehrmlive.com/";
		driver.get(url);
		driver.findElement(By.name("txtUsername")).sendKeys(username);
		driver.findElement(By.name("txtPassword")).sendKeys(password);
		driver.findElement(By.name("Submit")).click();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		String title="OrangeHRM";
		Assert.assertEquals("OrangeHRM", title);
		driver.getTitle();
		
		
		
	}
	
	@DataProvider(name="Orng HRM")
	
      Object[][]passout(){
		
		ExcelDataDemo1 excel=new ExcelDataDemo1("C:\\Users\\user\\eclipse-workspace\\Practice Testing SeleniumQA\\TestData\\ORANGE HRM Project.xlsx");
		
		int row=excel.getRowCount(0);
		Object[][]data=new Object[row][2];
		
		for(int i=0;i<=row;i++)
		{
			try
			{
			data[i][0]=excel.getData(0, i, 0);
			data[i][1]=excel.getData(0, i, 1);
			}
			catch(Exception e) {
				
				System.out.println(e);;
			}
		}
		
		
		return data;
		
		
	}
	

}
