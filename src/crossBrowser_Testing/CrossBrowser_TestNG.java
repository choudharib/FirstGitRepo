package crossBrowser_Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CrossBrowser_TestNG {
	WebDriver driver;
	
	@BeforeMethod
	@Parameters("browser")
	
	public void crossBrowserTest(String browser) {
		// TODO Auto-generated method stub
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
	}
	
	@Test
		public void openwebsite() throws InterruptedException {
            // Navigate to a website
            driver.get("https://www.google.com");

            // Perform some action
            driver.findElement(By.name("q")).sendKeys("Selenium WebDriver");
            driver.findElement(By.name("btnK")).submit();
            Thread.sleep(3000);

            // Get and print the title
            System.out.println("Page Title is: " + driver.getTitle());

        } 
		
	@AfterMethod
		public void tearDown() {
			if(driver != null) {
				driver.quit();
			}
		}
		
	}


