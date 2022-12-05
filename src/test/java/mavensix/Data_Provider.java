package mavensix;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Data_Provider {
	
	public static WebDriver driver;

	@Test(dataProvider = "Data")
	public void UseData(String url, String uname, String password) {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		
		driver.findElement(By.cssSelector("#login1")).sendKeys(uname);
		driver.findElement(By.cssSelector("#password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@class='signinbtn']")).click();
		driver.findElement(By.xpath("//body/div[4]/div[1]/div[1]/div[2]/a[2]")).click();
		
		
		driver.close();
		driver.quit();
	}
	
	
	@DataProvider
	public Object[][] Data() {
		Object[][] data = new Object[1][3];
		
		data[0][0] = "https://mail.rediff.com/cgi-bin/login.cgi";
		data[0][1] = "seleniumpanda@rediffmail.com";
		data[0][2] = "Selenium@123";
		
		return data;
		
		
	}
}
