package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import PageObjects.*;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class BasePage extends PageGenerator{

	 public BasePage(WebDriver driver) {
	        super(driver);
	    }
	 
	 @FindBy(how = How.XPATH, using = "//*[@id=\"topPanel\"]/div[1]/ul/li[1]")
	    public WebElement HomeViewMenu;
	 
	    //If we need we can use custom wait in BasePage and all page classes
	    WebDriverWait wait = new WebDriverWait(this.driver,20);
	 
	    //Click Method by using JAVA Generics (You can use both By or Webelement)
	    public <T> void click (T elementAttr) {
	        if(elementAttr.getClass().getName().contains("By")) {
	            driver.findElement((By) elementAttr).click();
	        } else {
	            ((WebElement) elementAttr).click();
	        }
	    }
	 
	    //Write Text by using JAVA Generics (You can use both By or Webelement)
	    public <T> void writeText (T elementAttr, String text) {
	        if(elementAttr.getClass().getName().contains("By")) {
	            driver.findElement((By) elementAttr).sendKeys(text);
	        } else {
	            ((WebElement) elementAttr).sendKeys(text);
	        }
	    }
	 
	    //Read Text by using JAVA Generics (You can use both By or Webelement)
	    public <T> String readText (T elementAttr) {
	        if(elementAttr.getClass().getName().contains("By")) {
	            return driver.findElement((By) elementAttr).getText();
	        } else {
	            return ((WebElement) elementAttr).getText();
	        }
	    }
	 
	    //Close popup if exists
	    public void handlePopup (By by) throws InterruptedException {
	        List<WebElement> popup = driver.findElements(by);
	        if(!popup.isEmpty()){
	            popup.get(0).click();
	            Thread.sleep(200);
	        }
	    }
	    
	  //Select value from single drop-down list
	    public <T> void DropDown_select (T elementAttr, String value) {
	        if(elementAttr.getClass().getName().contains("By")) {
	        	Select selectValue=  new Select(driver.findElement((By) elementAttr));
	        	selectValue.selectByValue(value);	     
	        } else {	        	
	        	Select selectDB2=  new Select(((WebElement) elementAttr));
	        	selectDB2.selectByValue(value);	 
	        }
	    }
  	    
	  //Click on some of Main tool bar sub-menu
	    public <T> void click_MainToolbar_action(T elementAttr, T elementAttr2) throws InterruptedException {	    	
			click (elementAttr);
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);		
			click (elementAttr2);						
		}
	    		
 public void switch_to_opened_form() {
	// Store and Print the name of the First window
	// String handle= driver.getWindowHandle();
	 //System.out.println(handle);
	// Store and Print the name of all the windows open	              	 
     //Set handles = driver.getWindowHandles();
    // System.out.println(handles);
     
  // Pass a window handle to the other window    
    // for (String handle1 : driver.getWindowHandles()) {
     //	System.out.println(handle1);
     	//driver.switchTo().window(handle1);
     	//}
	 
	 String parentWindow = driver.getWindowHandle();
	 Set<String> handles =  driver.getWindowHandles();
	    for(String windowHandle  : handles)
	        {
	        if(!windowHandle.equals(parentWindow))
	           {
	           driver.switchTo().window(windowHandle);
	         // <!--Perform your operation here for new window-->
	          driver.close(); //closing child window
	          driver.switchTo().window(parentWindow); //cntrl to parent window
	           }
	        }
	 
 }
		
 
 
	
}
