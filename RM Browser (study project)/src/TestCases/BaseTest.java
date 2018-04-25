package TestCases;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.ss.excelant.ExcelAntTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import PageObjects.Login_page;
import PageObjects.PageGenerator;
import PageObjects.UserManagement;

import org.testng.annotations.DataProvider;
import Utilities.*;

import org.testng.annotations.Test;

public class BaseTest extends DataProviders {
	public WebDriver driver;
    public WebDriverWait wait;
    public PageGenerator page;
    
    
       
    @BeforeSuite
    public void setup () {
        //Create a Chrome driver. All test classes use this.      
        System.setProperty("webdriver.chrome.driver", "C:\\Soft\\WebBrowserDrivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//go to testing server
		driver.get("http://stl-qa-rm02:8080/rtmBrowser/");	
		        
        //Create a wait. All test classes use this.
        wait = new WebDriverWait(driver,10);
 
        //Maximize Window
        //driver.manage().window().maximize();
 
        //Instantiate the Page Class
        page = new PageGenerator(driver);
    }     
    
  @Test (dataProvider = "userData")
  public void login_as_admin(String username, String password, String DB, String project) 
  {
      //Open RM Browser login page
      //Initialize elements by using PageFactory
  page.GetInstance(Login_page.class).go_to_LoginPage();
      //login as admin user
  page.GetInstance(Login_page.class).login_as_admin(username, password, DB, project);
      //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='']")));
      //page.GetInstance(LoginPage.class).verifyLoginPassword((""));  	  
      System.out.println("bububu");   
  page.GetInstance(Login_page.class).goToHomeView();
  
  }
    
    @AfterSuite
    public void teardown () {
       // driver.quit();
    }
    

    
}
