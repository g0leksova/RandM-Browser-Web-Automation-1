package PageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserManagement extends BasePage {

	@FindBy(how = How.XPATH, using = "/html/body/div[3]/div[2]/div[1]/div/div/div[1]/div[2]/div/button[1]")
	public WebElement New_button; 

	public UserManagement (WebDriver driver) {
        super(driver);		      
		//driver.wait = new WebDriverWait(driver, 30L);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);		

		this.wait = new WebDriverWait(driver, 30L);
		PageFactory.initElements(driver, this);
    };
    
    
    public void open_new_user_overlay() {
    	click (New_button);
    }
   public  UserManagement InitElements (){	 
        //I want to chain LoginPage's methods so I return LoginPage by initializing its elements
        return new PageFactory().initElements(driver,UserManagement.class);
    }
	
}
