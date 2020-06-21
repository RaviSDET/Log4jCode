import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {

	WebDriver driver;
	Logger log =Logger.getLogger(LoginTest.class);
	
	
	
	@BeforeMethod
	public void stepUp() {
		log.info("-------------------------------Starting chrome browser------------------------------------------");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
	}
	
	@Test(priority = 1)
	public void validateTitle() {
		log.info("-----------------------login page ----------------------------------------");
	String title =driver.getTitle();
	System.out.println(title);
	
	}
	
	
	@Test(priority = 2)
	public void doLogin() {
		log.info("-----------------------do Login ----------------------------------------");
		WebElement email= driver.findElement(By.id("Email"));
		email.clear();
		email.sendKeys("admin@yourstore.com");
		WebElement password =driver.findElement(By.id("Password"));
		password.clear();
		password.sendKeys("admin");
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		
		
	}
	
	
	
	
}
