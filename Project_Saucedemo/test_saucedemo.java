package Project_Saucedemo;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class test_saucedemo {
	ExtentTest test;
	ExtentReports er;
	WebDriver driver;
	
	@BeforeClass
	public void reportconfig() {
		er=new ExtentReports(System.getProperty("user.dir")+"/JanuarySelenium/saucedemotest.html");
		
		 test = er.startTest("saucedemo");
		
	}
	
	
	
	@Test (priority=1)

	public void login() throws InterruptedException, IOException {
		
		driver=new ChromeDriver();
		
		
		
		driver.get("https://www.saucedemo.com/");
		
		test.log(LogStatus.PASS, "Browser opened successfully");
		
		test.log(LogStatus.PASS, "URL entered is correct");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		
		Thread.sleep(1000);
		
		driver.findElement(By.id("login-button")).click();
		
		 test.log(LogStatus.PASS, "clicked on login button");
	
	}

@Test (priority=2)

	public void add_to_cart() throws InterruptedException  {
		
	driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
	
	 test.log(LogStatus.PASS, "clicked on cart button");
	 Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@class=\"shopping_cart_link\"]")).click();
		
		 test.log(LogStatus.PASS, "clicked on link cart");
		
		driver.findElement(By.id("checkout")).click();
		
		 test.log(LogStatus.PASS, "clicked on checkout button");
	}
	

@Test (priority=3)
	public void checkout() {

		driver.findElement(By.id("first-name")).sendKeys("Momin");
		
		driver.findElement(By.id("last-name")).sendKeys("Razi");
		
		driver.findElement(By.id("postal-code")).sendKeys("421302");
		
		driver.findElement(By.id("continue")).click();
		
		 test.log(LogStatus.PASS, "clicked on continue button");
		
		driver.findElement(By.id("finish")).click();
		 test.log(LogStatus.PASS, "clicked on finish button");
	}
	

@Test (priority=4)

	public void proof() throws IOException {
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		
		File src = ts.getScreenshotAs(OutputType.FILE);
		
		File dest=new File("C:\\\\Users\\\\91735\\\\Pictures\\\\Saved Pictures\\\\Saucede_screenshot.png");
		test.log(LogStatus.PASS, "Screen shot is taken Successfully");
		FileUtils.copyFile(src, dest);
	}
	
	
	@Test (priority=5)
 
	public void laststep() {
		test.log(LogStatus.PASS, "closed browsers");
		driver.close();
	}
	
	
	@AfterClass
	public void reportflush() {
		
		
		
		er.endTest(test);
		
		er.flush();
		
		
	}

}
