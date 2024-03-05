package Main_TestNG;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Project_POM.CarPOM;
import Project_POM.HomePOM;
import Project_POM.LoanCal1;
import Project_POM.LoanCal2;
import Project_POM.LoanCal3;
import Resources.DriverSetup;
import Resources.Screenshots;

@Listeners(Main_TestNG.ExtentReportManager.class)
public class TestingMethods {

	public static WebDriver driver;
	CarPOM lp;
	HomePOM Hl;
	Screenshots ss;
	LoanCal1 lc1;
	LoanCal2 lc2;
	LoanCal3 lc3;
	DriverSetup d;
    @Parameters({"browser"})
	@BeforeClass(alwaysRun = true)
	void setup(String browser) throws InterruptedException, IOException {
//		WebDriverManager.chromedriver().setup();
		d = new DriverSetup();
		driver = d.SelectDriver(browser);
		driver.get("https://emicalculator.net/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		ss = new Screenshots();
		lp = new CarPOM(driver);
		Hl = new HomePOM(driver);
		lc1 = new LoanCal1(driver);
		lc2 = new LoanCal2(driver);
		lc3 = new LoanCal3(driver);
	}

	@Test(priority = 1, groups = { "RegressionTesting" })
	void testLogo() throws IOException, AWTException, InterruptedException {
		ss.ScreenShotTaker(driver, "EmiCal");
		Assert.assertEquals(lp.checkHeading(), "EMI Calculator for Home Loan, Car Loan & Personal Loan in India");

	}

	@Test(priority = 2, groups = { "SmokeTesting", "RegressionTesting" })
	public void Car_Loan() {
		lp.CarClick();

	}

	@Test(priority = 3, groups = "RegressionTesting")
	void Car_Loan_Details() throws IOException, AWTException, InterruptedException {

		lp.Loan_Amount();
		lp.Loan_Interest();
		lp.Loan_Tenure();
		ss.ScreenShotTaker(driver, "CarLoan");
		lp.scroll();
		ss.ScreenShotTaker(driver, "CarLoanEmi");
	}

	@Test(priority = 4, groups = "RegressionTesting")
	void EMI_Calculation() {
		lp.EmiCalculation();
		System.out.println("");
		System.out.println("Test Scenario 1 successfully completed");
		System.out.println("=====================");
	}

	@Test(priority = 5, groups = { "SmokeTesting", "RegressionTesting" })
	public void home_Loan() {
		lp.Menu_Click();
	}

	@Test(priority = 6, groups = "RegressionTesting")
	public void Home_page() throws IOException, InterruptedException, AWTException {

		Hl.Home_Loan_Set();
		Thread.sleep(5000);
		ss.ScreenShotTaker(driver, "HomeLoan");
		Hl.Scroll1();
		ss.ScreenShotTaker(driver, "HomeLoanEMI");
		Hl.scroll2();
		Hl.WriteTable();
		ss.ScreenShotTaker(driver, "HomeLoanTable");
		System.out.println("");
		System.out.println("Test Scenario 2 successfully completed");
		System.out.println("=====================");
	}

	@Test(priority = 7, groups = { "SmokeTesting", "RegressionTesting" })
	public void Loan_cal1() throws IOException {
		// lc1 = new LoanCal1(driver);
		lc1.LoanCalClick();
	}

	@Test(priority = 8, groups = { "RegressionTesting" })
	public void Calc1() throws InterruptedException, IOException {
		lc1.LoanAMT();
		lc1.LoanINt();
		lc1.Tenure();
		lc1.yearTomonth();
		lc1.feeCharges();
		lc1.emi();
		lc1.adv();
		lc1.date();
		lc1.month();
		lc1.Dropdn();
		lc1.hover();
		System.out.println("UI check for EMI Calculator page done Successfully");
	}

	@Test(priority = 9, groups = { "SmokeTesting", "RegressionTesting" })
	public void Loan_cal2() throws IOException {

		lc2.LoanCal2Click();
	}

	@Test(priority = 10, groups = { "RegressionTesting" })
	public void Calc2() throws InterruptedException, IOException {
		lc2.emi();
		lc2.UI_Check2();
		System.out.println("UI check for Loan Amount Calculator page done Successfully");
	}

	@Test(priority = 11, groups = { "SmokeTesting", "RegressionTesting" })
	public void Loan_cal3() throws IOException {

		lc3.LoanCal3Click();
	}

	@Test(priority = 12, groups = { "RegressionTesting" })
	public void Calc3() throws InterruptedException, IOException {
		lc3.UI_Check3();
		System.out.println("UI check for Loan Tenure Calculator page done Successfully");
		System.out.println("");
		System.out.println("Test Scenario 3 successfully completed");
		System.out.println("=====================");
	}

	public String captureScreen(String name) {
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + name + "_" + ".png";
		File targetFile = new File(targetFilePath);
		sourceFile.renameTo(targetFile);
		return targetFilePath;
	}

	@AfterClass(alwaysRun = true)
	public void close_b() {
		driver.close();
	}

}
