package testPKG;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pagePKG.HerbsPage;
import utilities.JustHerbsUtilities;



public class HerbsTest {

	
	WebDriver driver;
	HerbsPage ob;
	
	@BeforeTest
	public void setup()
	{
		driver=new ChromeDriver();
		
	}
	
	@BeforeMethod
	public void get()
	{
		driver.get("https://www.justherbs.in/");
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
	}
	
	
	@Test(priority=1)
	public void SignInToYourAccount() throws Exception
	{
		 ob=new HerbsPage(driver);
		 ob.createAccount();
			ob.logins();
		 
		String xl="D:\\jhproject\\JustherbsPro.xlsx";
		 String sheet="Sheet1";
		 int rowcount=JustHerbsUtilities.getRowcount(xl, sheet);
		 System.out.println(rowcount);
		 for(int i=1;i<=rowcount;i++)
		 	 
		 {
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			 String username=JustHerbsUtilities.getCellValue(xl, sheet, i, 0);
			 System.out.println("username----"+username);
			 String password= JustHerbsUtilities.getCellValue(xl, sheet, i, 1);
			 System.out.println("password----"+password);
			 ob.signinAcct(username, password); 
			
		 }
	}
	
	@Test(priority=2)
	public void logintest() throws Exception
	{
		
       ob=new HerbsPage(driver);
		ob.logoicon();
		
    }

	
	@Test(priority=3)
	public void addcart() throws Exception
	{
		ob=new HerbsPage(driver);
		ob.addtocart();
	}
	

	@Test(priority=4)
	public void searchbar() throws Exception
	{
		ob=new HerbsPage(driver);
		ob.searchtest();
	}
	
	
	@Test(priority=5)
    public void scrnshottest() throws Exception 
	{
		ob=new HerbsPage(driver);
		ob.scrnshot();
	}
	

	@Test(priority=6)
	public void togetalllinks() throws Exception
	{
		ob=new HerbsPage(driver);
		ob.alllinks();
	}
	 
	
}


