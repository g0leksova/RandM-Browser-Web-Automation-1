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

public class Login_page extends BasePage{

	//*********Constructor*********
	 public Login_page (WebDriver driver) {
	        super(driver);
	    };
	 	 
	//*********Web Elements By Using Page Factory*********
	    @FindBy(how = How.XPATH, using = "//*[@id=\"ic__username\"]")
	    public WebElement username;
	 
	    @FindBy(how = How.XPATH, using = "//*[@id=\"ic__password\"]")
	    public WebElement password;
	 
	    @FindBy(how = How.XPATH, using = "//*[@id=\"ic_login_button\"]")
	    public WebElement Loginbutton;
	 
	    //@FindBy(how = How.XPATH, using = "//*[@id=\"loginForm\"]/div[1]/div/div")
	    //public WebElement errorMessageUsername;
	 
	    //@FindBy(how = How.XPATH, using = "//*[@id=\"loginForm\"]/div[2]/div/div")
	    //public WebElement errorMessagePassword;
	    
	    @FindBy(how = How.XPATH, using = "//*[@id=\"ic__database\"]")
	    public WebElement DB;
	 
	    @FindBy(how = How.XPATH, using = "//*[@id=\"ic__project\"]")
	    public WebElement project;
	    
	//*********Page Methods*********
	//public void sun(String Susername) {
		//username.sendKeys(Susername);
	//}
	    
	 public void login_as_admin (String pusername, String ppassword, String pDB, String pproject){
	        writeText(username,pusername);
	        writeText(password,ppassword);
	        
    //Get all options form the list 
	//Select oSelect = new Select(driver.findElement(By.id("yy_date_8")));
	//List <WebElement> elementCount = oSelect.getOptions();
	//System.out.println(elementCount.size());
	
	        //Select selectDB= new Select(DB);
	        //selectDB.selectByValue(pDB);	
	        //Select selectProject= new Select(project);
	        //selectProject.selectByValue(pproject);
	        
	        //select DB
	        DropDown_select (DB, pDB);	
	        //wait
	        //WebDriverWait wait = new WebDriverWait(driver, 10);	        
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	        //select project
	        
	       // WebDriverWait wait = new WebDriverWait(driver, 10);

	        //WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\\\"ic__project\\\"]")));
	        
	        DropDown_select (project, pproject); 
	        //click Login button
	        click(Loginbutton);	       
	        //Enter Password
	        //writeText(password, ppassword);
	        //Click Login Button
	        //click(loginButton);
	    }
	 
	 public void goToHomeView () {
		 driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	        click(HomeViewMenu);
	 }
	 
	 public Login_page go_to_LoginPage (){	 
	        //I want to chain LoginPage's methods so I return LoginPage by initializing its elements
	        return new PageFactory().initElements(driver,Login_page.class);
	    }
		 
	 
	 
}
