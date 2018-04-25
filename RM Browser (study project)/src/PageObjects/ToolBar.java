package PageObjects;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import PageObjects.BasePage;
import PageObjects.PageGenerator;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class ToolBar extends BasePage {

	//*********Constructor*********
		 public ToolBar (WebDriver driver) {
		        super(driver);		      
				driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		    };
		    
		    public  ToolBar InitElements (){	 
		        return new PageFactory().initElements(driver,ToolBar.class);
		    }
		    
		    
    //*********Web Elements By Using Page Factory*********
		@FindBy(how = How.XPATH, using = "//*[@id=\"topPanel\"]/div[1]/ul")
		public WebElement MainToolBar;
	
		@FindBy(how = How.XPATH, using = "//*[@id=\"topPanel\"]/div[1]/ul/li[5]")
		public WebElement Administration_Menu;

		@FindBy(css = "#menuPopUp > #userManagementMenu > a") 
		private WebElement Manage_Users;
		//------------------------------------------------------------------------------
		
		
		public UserManagement open_UserManagement_form () throws InterruptedException{
			this.click_MainToolbar_action(Administration_Menu, Manage_Users);
			return new UserManagement(driver);
		}				
}
