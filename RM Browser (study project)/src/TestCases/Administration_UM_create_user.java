package TestCases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import PageObjects.Login_page;
import PageObjects.PageGenerator;
import org.testng.annotations.DataProvider;
import Utilities.*;
import PageObjects.*;

public class Administration_UM_create_user extends BaseTest {
	//WebDriver driver;

@Test(priority =1)
  public void open_UM_User_Info() throws InterruptedException {
  	
		page.GetInstance(ToolBar.class).InitElements();
	    page.GetInstance(ToolBar.class).open_UserManagement_form();
	    //driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);	
	    	    
	    //need to switch to user_management form	    	    	    	    	      
	    String parentWindow = driver.getWindowHandle();
	    Set<String> handles =  driver.getWindowHandles();
	       for(String windowHandle  : handles)
	           {
	           if(!windowHandle.equals(parentWindow))
	              {
	              driver.switchTo().window(windowHandle);
	              page.GetInstance(UserManagement.class).InitElements();
	             //<!--Perform your operation here for new window-->
	             // page.GetInstance(ToolBar.class).InitElements();
	              //page.GetInstance(ToolBar.class).open_UserManagement_form();
	             driver.close(); //closing child window
	             driver.switchTo().window(parentWindow); //cntrl to parent window
	              }
	           }
	    
	    

	    
	    //page.GetInstance(UserManagement.class).open_new_user_overlay();
	    
        //System.out.println("Create User");

	  
  }

  @AfterMethod
  public void afterMethod() {
  }


  

}
