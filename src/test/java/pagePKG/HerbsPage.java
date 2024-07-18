package pagePKG;



import java.io.File;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;




public class HerbsPage {
	
	
	WebDriver driver;
	
   By account=By.xpath("//*[@id=\"shopify-section-header--default\"]/header[1]/div/div[2]/div/label[1]/i");
   By login=By.xpath("//*[@id=\"shopify-section-header--default\"]/header[1]/div/div[2]/div/div/a[1]");
   By emailid=By.xpath("//*[@id=\"customer_login\"]/input[3]");
   By passwrd=By.xpath("//*[@id=\"customer_login\"]/input[4]");
   By signin=By.xpath("//*[@id=\"customer_login\"]/input[5]");
   By logo =By.xpath("//*[@id=\"shopify-section-header--default\"]/header[1]/div/div[1]/a/img[1]");
   By hair=By.xpath("//*[@id=\"shopify-section-header--default\"]/header[1]/div/nav/span[3]/a");
   By category=By.xpath("//*[@id=\"shopify-section-header--default\"]/header[1]/div/nav/span[3]/div/span[1]/a/div/span");
   By hairoil=By.xpath("//*[@id=\"shopify-section-header--default\"]/header[1]/div/nav/span[3]/div/span[1]/div/span[2]/a/div/span");
   By bringarajtailcart=By.xpath("//*[@id=\"shopify-section-template--14206604181581__content\"]/div[3]/div/form/input[3]");
   By links=By.tagName("a");
   By viewcrt=By.xpath("//*[@id=\"shopify-section-header--default\"]/header[1]/div/div[2]/a/i");
   By serch=By.xpath("//*[@id=\"shopify-section-header--default\"]/header[1]/div/div[2]/span/i");
   By search=By.xpath("//*[@id=\"shopify-section-header--default\"]/div[1]/div[2]/form/input");
   By shampoo=By.xpath("//*[@id=\"zevi-container\"]/div/div[2]/div[2]/div[1]/div/div/div[1]/div/div[1]/a/div/img");
   By quantityincrment=By.xpath("//*[@id=\"product_form_3654720946253\"]/div[7]/div[1]/button[2]");
  
   public HerbsPage(WebDriver driver)
    {
    	
		this.driver=driver;
		
	}
	
    public void createAccount()
    {
    	driver.findElement(account).click();
    }	
    
    public void logins()	
    {
    	driver.findElement(login).click();
    }
    
    public void signinAcct(String email, String password) throws Exception 
    {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    	
    	driver.findElement(emailid).clear();
    	driver.findElement(emailid).sendKeys(email);
    	
    	driver.findElement(passwrd).clear();
    	driver.findElement(passwrd).sendKeys(password);
    	
    	driver.findElement(signin).click();
    	
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    
    public void logoicon() throws Exception
   	{
       		// wait=new WebDriverWait(driver, Duration.ofSeconds(30));
     
           	driver.findElement(logo).click();
               boolean s=driver.findElement(logo).isDisplayed();
               if(s)
               	
       		{
       			System.out.println("Logo is Present");
       		}
       		else
       		{
       			System.out.println("Logo not present");
       		}
   	} 
  
    public void addtocart() throws Exception
    {
       
    	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
    	WebElement w1= wait.until(ExpectedConditions.visibilityOfElementLocated(hair));

    	Actions act=new Actions(driver);
    	act.moveToElement(w1).perform();


    	driver.findElement(category).click();
    	driver.findElement(hairoil).click();
    	JavascriptExecutor jses=(JavascriptExecutor)driver;
		jses.executeScript("scroll(0,400)");
    	WebDriverWait waits=new WebDriverWait(driver,Duration.ofSeconds(30));
    	WebElement w2= waits.until(ExpectedConditions.visibilityOfElementLocated(bringarajtailcart));
    	  w2.click();
    }
  
   public void searchtest() 
    {
  
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(serch).click();
		driver.findElement(search).click();
		driver.findElement(search).sendKeys("shampoo",Keys.ENTER);
		
		driver.findElement(shampoo).click();
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("scroll(0,500)");
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		
		
		driver.findElement(quantityincrment).click();
	 }
   
   public void viewcart() throws InterruptedException 
   {
		
		driver.navigate().back();
		Thread.sleep(2000);
		//carticon.click();
		driver.findElement(viewcrt).click();
		driver.navigate().refresh();
	}
   
   public void scrnshot() throws Exception 
   {
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, new File("./justherbsSCREENSHOT/checkoutpage1.png"));
		Thread.sleep(2000);
		//driver.navigate().back();
	}
   
	
   public void alllinks()throws Exception
  	{
  		// to print all links
  		List<WebElement> list=driver.findElements(links);
  		for(WebElement w:list)
  		{
  			String s=w.getAttribute("href");
  			String s1=w.getText();
  			System.out.println("link: "+s+" text: "+s1);			
  		}
    }

 }

