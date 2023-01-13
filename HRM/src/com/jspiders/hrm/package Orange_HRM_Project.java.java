package com.jspiders.hrm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Cheking_The_PIM_Search {
	WebDriver driver;
  @Test(priority=1)
  public void Check_The_PIM() {
	  Actions act=new Actions(driver);
	  WebElement w=driver.findElement(By.xpath("//b[contains(text(),'PIM')]"));
	   act.moveToElement(w).build().perform();
        
       driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
       driver.findElement(By.name("btnAdd")).click();
       
       driver.findElement(By.name("firstName")).sendKeys("Mohit");
       driver.findElement(By.name("middleName")).sendKeys("Pradip");
       driver.findElement(By.name("lastName")).sendKeys("Patil");
       driver.findElement(By.name("photofile")).sendKeys("C:\\Users\\user\\Desktop\\oarnghrm.txt");
       driver.findElement(By.name("chkLogin")).click();
       driver.findElement(By.name("user_name")).sendKeys("Mayur");
       driver.findElement(By.name("user_password")).sendKeys("mayur@123");
       driver.findElement(By.name("re_password")).sendKeys("mayur@123");
       
       
       Select status=new Select(driver.findElement(By.cssSelector("select[name^='status']")));
       status.selectByIndex(1);
	    driver.findElement(By.xpath("//input[@id='btnSave']")).click();
  }
  @Test(priority=2)
  public void Return SEarch Emp(){
	          
	  Actions act=new Actions(driver);
	  WebElement w1=driver.findElement(By.xpath("//b[contains(text(),'PIM')]"));
	  act.moveToElement(w1).build().perform();
      driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
      
      driver.findElement(By.id("empsearch_employee_name_empName")).sendKeys("Joe Root");
	  driver.findElement(By.name("empsearch[supervisor_name]")).sendKeys("Melan Peiris");
	  driver.findElement(By.name("_search")).click();
	  
	  
  } 
   @BeforeMethod
   
   public void OpenBrowser()
   {
		  System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
	    driver=new ChromeDriver();
	    String url="https://opensource-demo.orangehrmlive.com/index.php/dashboard";
	    driver.get(url);
	    driver.manage().window().maximize();
	    driver.findElement(By.name("txtUsername")).sendKeys("Admin");
	    driver.findElement(By.name("txtPassword")).sendKeys("admin123");
        driver.findElement(By.name("Submit")).click();
        
       	    
   }
   
}
