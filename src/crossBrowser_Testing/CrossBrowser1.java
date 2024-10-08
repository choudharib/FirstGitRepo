package crossBrowser_Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CrossBrowser1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		runTest(driver);
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driverFirefox = new FirefoxDriver();
		runTest(driverFirefox);
		
		WebDriverManager.edgedriver().setup();
		WebDriver driverEdge = new EdgeDriver();
		runTest(driverEdge);

	}

	private static void runTest(WebDriver driver) {
		// TODO Auto-generated method stub
		try {
			driver.get("https://www.google.com");
			
			driver.findElement(By.name("q")).sendKeys("Selenium WebDriver");
            driver.findElement(By.name("btnK")).submit();
            Thread.sleep(3000);  // Add wait to observe result

            // Print title of the page
            System.out.println("Title of the page on " + driver.getClass().getSimpleName() + ": " + driver.getTitle());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}
	}

}
