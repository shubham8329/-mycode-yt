
package Orange_HRM_Project;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataDemo2 {
	
	XSSFWorkbook wb;
	XSSFSheet sheet1;
	
	public ExcelDataDemo2(String excelpath) {
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
		 
    	 sheet1=wb.getSheetAt(sheetnumber) ;
    	 String data=sheet1.getRow(row).getCell(col).getStringCellValue();
    	 
    	  return data;
    	  
    	  
      }
      public int getRowCount(int sheetIndex) {
		
    	 int row=wb.getSheetAt(sheetIndex).getLastRowNum();
    	 row=row + 1;
    	 
    	  return row;
    	  
    	  
      }
}



<--- Data Driven Framework Emlpoyee Add-->
package Orange_HRM_Project;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo2 {
	
	WebDriver driver;
	
	@Test(dataProvider="Add Emp")
	
	public void OpenBrowser(String firstname,String middlename,String lastname) {
		
		System.setProperty("webdriver.driver", "C:\\Users\\user\\Downloads\\chromedriver_win32 (1)");
		driver=new ChromeDriver();
		String url="https://opensource-demo.orangehrmlive.com/index.php/dashboard";
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
	    driver.findElement(By.name("txtPassword")).sendKeys("admin123");
        driver.findElement(By.name("Submit")).click();
        
        Actions act=new Actions(driver);
        WebElement w=driver.findElement(By.xpath("//*[@id=\"menu_pim_viewPimModule\"]/b"));
        act.moveToElement(w).perform();
		
		driver.findElement(By.id("menu_pim_addEmployee")).click();
		
		driver.findElement(By.name("firstName")).sendKeys(firstname);
		driver.findElement(By.name("middleName")).sendKeys(middlename);
		driver.findElement(By.name("lastName")).sendKeys(lastname);
		driver.findElement(By.name("photofile")).sendKeys("C:\\Users\\user\\eclipse-workspace\\Practice Testing SeleniumQA\\TestData\\OrangeHRM Add Emp.xlsx");
		driver.findElement(By.name("chkLogin")).click();
		
		
		driver.findElement(By.name("user_name")).sendKeys("mayur123");
		driver.findElement(By.name("user_password")).sendKeys("mayur@123");
		driver.findElement(By.name("re_password")).sendKeys("mayur@123");
		
		Select status=new Select(driver.findElement(By.xpath("//select[@id='status']")));
		status.selectByIndex(1);
		driver.findElement(By.id("btnSave")).click();
		
		driver.findElement(By.name("user_name")).sendKeys("mohit");
		driver.findElement(By.name("user_password")).sendKeys("mohit@123");
		driver.findElement(By.name("re_password")).sendKeys("mohit@123");
		
		Select status1=new Select(driver.findElement(By.xpath("//select[@id='status']")));
		status1.selectByIndex(0);
		driver.findElement(By.id("btnSave")).click();
		
	}
	
	
	@DataProvider(name="Add Emp")
	
	Object[][]passdata(){
		
		ExcelDataDemo2 execel=new ExcelDataDemo2("C:\\Users\\user\\eclipse-workspace\\Practice Testing SeleniumQA\\TestData\\OrangeHRM Add Emp.xlsx");
		
		int row=execel.getRowCount(0);
		
		Object[][]data=new Object[row][3];
		
		for(int i=0;i<=row;i++) {
			
			try
			{
			
			data[i][0]=execel.getData(0, i, 0);
			data[i][1]=execel.getData(0, i, 1);
			data[i][2]=execel.getData(0, i, 2);
			}
			catch(Exception e)
			
			{
				System.out.println(e);
			}
		}
		
		
		return data;
		
		
		
	}
	
	
	

}

