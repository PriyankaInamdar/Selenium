import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTest {

	private WebDriver driver;
	@Test 
	public void register() {
		driver.findElement(By.linkText("REGISTER")).click();
		driver.findElement(By.name("firstname")).sendKeys("Priyanka");
		driver.findElement(By.name("lastname")).sendKeys("Inamdar");
		driver.findElement(By.id("userName")).sendKeys("priyainamdar@gmail.com");
		driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[7]/td[2]/input")).sendKeys("Accenture_Magarpatta");
		driver.findElement(By.name("city")).sendKeys("Pune");

		Select country = new Select(driver.findElement(By.name("country"))); 
		country.selectByVisibleText("INDIA");

		driver.findElement(By.cssSelector("input[name='email']")).sendKeys("priyainamdar");
	}

	@BeforeMethod
	public void beforeMethod() {
	}

	@AfterMethod
	public void afterMethod() {
	}

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.gecko.driver","C:\\Users\\A06438_P5.training\\Desktop\\Priyanka\\Drivers");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://newtours.demoaut.com");

	}

	@AfterTest
	public void afterTest() {
	}

}
