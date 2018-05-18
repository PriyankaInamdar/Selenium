package utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class LoginTestMe {
	private WebDriver driver;
	private static int rownum=0;
	private int colnum=2;
	@Test(dataProvider = "logindata",priority=1)
	public void test_me_login(String uname, String pass) throws Exception
	{
		try {
			//ExcelUtility.setExcelPath("Sheet1", "C:\\Users\\A06438_P5.training\\Desktop\\Priyanka\\Drivers\\ExcelData.xlsx\\");  
			driver.findElement(By.id("userName")).clear();
			driver.findElement(By.id("userName")).sendKeys("Lalitha");
			driver.findElement(By.cssSelector("#password")).clear();
			driver.findElement(By.cssSelector("#password")).sendKeys("Password123");
			driver.findElement(By.xpath("/html/body/main/div/div/div/form/fieldset/div[4]/div/input[1]")).click();
			Assert.assertEquals(driver.getTitle(),"Home");

			ExcelUtility.setExcelCell(rownum, colnum, "Pass");
			Thread.sleep (5000);
		}catch (AssertionError e) {
			ExcelUtility.setExcelCell(rownum, colnum, "Fail");
		}
		finally {
			rownum++;

			driver.navigate().to("http://localhost:8083/TestMeApp/Login.htm");
		}

	}
	@DataProvider(name="logindata")
	public String[][] login_data() throws Exception{
		ExcelUtility.setExcelPath("Sheet1", "C:\\Users\\A06438_P5.training\\Desktop\\Priyanka\\Drivers\\ExcelData.xlsx\\");
		String[][] tabledata = ExcelUtility.getExcelTable();
		return tabledata;
	}
	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.gecko.driver","C:\\Users\\A06438_P5.training\\Desktop\\Priyanka\\Drivers\\geckodriver-v0.20.1-win64\\geckodriver.exe\\");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:8083/TestMeApp/login.htm");
	}
	@AfterTest
	public void afterTest() {
	}

	@Test (priority=2)
	
	public void select_Category() {
		
		WebElement category = driver.findElement(By.xpath("//html//body//header//div[2]//div//div//ul//li[2]//a//span"));
				Actions act = new Actions(driver);
				act.moveToElement(category).click().build().perform();
				WebElement electronics = driver.findElement(By.xpath("//html//body//header//div[2]//div//div//ul//li[2]//ul//li[1]//a//span"));
		act.moveToElement(electronics).click().build().perform();
		
		WebElement headfons = driver.findElement(By.xpath("//html//body//header//div[2]//div//div//ul//li[2]//ul//li[1]//ul//li[1]//a//span"));
		
		act.moveToElement(headfons).click().build().perform();
		
		Assert.assertEquals(driver.getTitle(), "Search");
		
		}
	
	/*@Test(priority=3)
	public void select_product()
	{
		
			driver.findElement(By.xpath("//html//body//section//div//div//div[2]//div//div//div//div[2]//center//a")).click();
			WebElement cart = driver.findElement(By.xpath("//html//body//header//div[1]//div//div//div[2]//div//a[2]"));
			Assert.assertEquals(driver.getTitle(), "View Cart");
			
	}
	*/
}
