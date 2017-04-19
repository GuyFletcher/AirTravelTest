import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AirTesting {
	
	//http://www.phptravels.net/
	//user@phptravels.com
	//demouser
	
	WebDriver driver;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
	}

	@Before
	public void setUp() throws Exception {
		
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Tamerai\\Desktop\\AirTravelTest\\geckodriver-v0.15.0-win32\\geckodriver.exe");
		
		driver = new FirefoxDriver();
		
		driver.get("http://www.phptravels.net/");
		
		WebElement accountLink = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/ul/li[2]/a"));
		accountLink.click();
		
		accountLink = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/ul/li[2]/ul/li[1]/a"));
		accountLink.click();
		
		Thread.sleep(2000);
		
		WebElement emailBox = driver.findElement(By.xpath("/html/body/div[3]/div[1]/form/div[4]/div/div[1]/input"));
		emailBox.clear();
		emailBox.sendKeys("user@phptravels.com");
		
		WebElement passBox = driver.findElement(By.xpath("/html/body/div[3]/div[1]/form/div[4]/div/div[2]/input"));
		passBox.clear();
		passBox.sendKeys("demouser");
		
		
		accountLink = driver.findElement(By.xpath("/html/body/div[3]/div[1]/form/div[4]/button"));
		accountLink.click();
		
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Ignore
	public void testLogIn() throws InterruptedException {
		
		Thread.sleep(10000); //wait for page to load
				
		WebElement text = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[1]/h3"));
		
		assertEquals("Hi, John Smith",text.getText());
		
	}
	
	@Ignore
	public void testCorrectHotel() throws InterruptedException {
		
		Thread.sleep(10000); //wait for page to load
		
		WebElement clicker = driver.findElement(By.xpath("/html/body/nav[1]/div/div/div/ul/li[2]/a"));
		clicker.click();
		
		Thread.sleep(5000); //wait for page to load
		
		clicker = driver.findElement(By.xpath("/html/body/div[5]/div[3]/div/table/tbody/tr[1]/td/div/div[2]/div/div[1]/a/button"));
		clicker.click();
		
		Thread.sleep(5000); //wait for page to load
		
		clicker = driver.findElement(By.xpath("/html/body/div[4]/div[2]/section/form[3]/div/div[2]/div[1]/div[2]/span"));
		clicker.click();
		
		Thread.sleep(5000); //wait for page to load
		
		WebElement text = driver.findElement(By.xpath("/html/body/div[5]/div[3]/div/table/tbody/tr[1]/td/div/div[2]/div/div[2]/h4/a/b"));
		
		assertEquals("Dee Marks Hotel & Resorts", text.getText());
		
		clicker = driver.findElement(By.xpath("/html/body/div[5]/div[3]/div/table/tbody/tr[1]/td/div/div[2]/div/div[1]/a/button"));
		clicker.click();
		
		Thread.sleep(5000); //wait for page to load
		
		text = driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[1]/div[1]/div[1]/div/strong"));
		
		assertEquals("Dee Marks Hotel & Resorts",text.getText());
		
		driver.close();
	}
	
	@Test
	public void testChangeLanguage() throws InterruptedException {
		
		Thread.sleep(10000); //wait for page to load
				
		WebElement text = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/ul/li[1]/a"));
		
		assertEquals("English",text.getText());
		
		text.click();
		
		text = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/ul/li[1]/ul/li[7]/a"));
		text.click();
		
		Thread.sleep(5000);
		
		text = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/ul/li[1]/a"));
		
		assertEquals("Spanish",text.getText());
		
		driver.close();
	}

}