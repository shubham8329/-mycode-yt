package com.jspiders.hrm;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Searching_ADD_Candicate {
	WebDriver driver;
  @Test(priority=1)
  public void Recruitment() {
	  Actions act=new Actions(driver);
      WebElement w=driver.findElement(By.xpath("//*[@id=\"menu_recruitment_viewRecruitmentModule\"]/b"));
      act.moveToElement(w).build().perform();
      
      driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/ul[1]/li[5]/ul[1]/li[1]/a[1]")).click();
      
      driver.findElement(By.name("candidateSearch[candidateName]")).sendKeys("Joe Root");
	  driver.findElement(By.id("btnSrch")).click();
//	  driver.findElement(By.id("ohrmList_chkSelectAll")).click();
//	  driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr/td[7]/a")).click();
	  
	  
	//a[@id='menu_pim_viewEmployeeList']
  }
  
  
  @BeforeMethod
  public void OpenBrowser() {
	  
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
	  driver=new ChromeDriver();
	  String url="https://opensource-demo.orangehrmlive.com/index.php/dashboard";
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
	    driver.findElement(By.name("txtPassword")).sendKeys("admin123");
        driver.findElement(By.name("Submit")).click();
        
       
        
  }
}
