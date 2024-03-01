package Cucumber.Steps;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Resources.DriverSetup;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

public class Hooks {
	public static WebDriver driver;
	static DriverSetup d;
	@BeforeAll
    public static void before_or_after_all() throws IOException, InterruptedException{
		d = new DriverSetup();
		driver = d.SelectDriver();
		driver.get("https://emicalculator.net/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  
}
	@AfterStep
  public void addScreenshot(Scenario scenario) {
  if(!scenario.isFailed()) {
     TakesScreenshot ts=(TakesScreenshot) driver;
     byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
     scenario.attach(screenshot, "image/png",scenario.getName());
      }
	}
	@AfterAll
	public static void before_or_after_all1() {
		driver.quit();
	}
}
