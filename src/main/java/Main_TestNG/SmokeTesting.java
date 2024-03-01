package Main_TestNG;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Project_POM.CarPOM;
import Project_POM.HomePOM;
import Project_POM.LoanCal1;
import Project_POM.LoanCal2;
import Project_POM.LoanCal3;
import Resources.DriverSetup;
import Resources.Screenshots;

public class SmokeTesting {
	public static WebDriver driver;
	CarPOM lp;
	LoanCal1 lc1;
	LoanCal2 lc2;
	LoanCal3 lc3;
	DriverSetup d;
	Screenshots ss;
	@BeforeClass
	public void setup() throws InterruptedException, MalformedURLException
	{
//		WebDriverManager.chromedriver().setup();
		d = new DriverSetup();
		driver = d.SelectDriver();
		driver.get("https://emicalculator.net/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		ss=new Screenshots();
	}
	@Test(priority = 1)
	public void car_Loan() throws IOException {
		
		lp=new CarPOM(driver);
		lp.CarClick();
		System.out.println("Smoke testing for car loan funtionality is passed");
		System.out.println("=====================");
	}
	@Test(priority = 2)
	public void home_Loan() {
		lp.Menu_Click();
		System.out.println("Smoke testing for loan loan funtionality is passed");
		System.out.println("=====================");
	}
	@Test(priority = 3)
	public void Loan_cal1() throws IOException {
		lc1=new LoanCal1(driver);
		lc1.LoanCalClick();
		System.out.println("Smoke testing for EMI calculator page funtionality is passed");
		System.out.println("=====================");
	}
	@Test(priority = 4)
	public void Loan_cal2() throws IOException {
		lc2=new LoanCal2(driver);
		lc2.LoanCal2Click();
		System.out.println("Smoke testing for Loan Amount calculator page funtionality is passed");
		System.out.println("=====================");
	}
	@Test(priority = 5)
	public void Loan_cal3() throws IOException {
		lc3=new LoanCal3(driver);
		lc3.LoanCal3Click();
		System.out.println("Smoke testing for Loan Tenure calculator page funtionality is passed");
		System.out.println("=====================");
	}
	@AfterClass
	public void close() {
		driver.quit();
	}
	
	
	
}
