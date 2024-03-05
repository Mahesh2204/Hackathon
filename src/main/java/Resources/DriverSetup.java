package Resources;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverSetup {

	String huburl = "http://localhost:4444/wd/hub";

	public WebDriver SelectDriver(String browser) throws MalformedURLException {
		WebDriver d = null;
//		switch (browser) {
//		case "chrome":
//			d = new ChromeDriver();
//			break;
//		case "edge":
//			d = new EdgeDriver();
//			break;
//		default:
//			System.out.println("Wrong choice\n");
//		}
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter \n1 for remote webdriver\n2 for local webdriver");
		int x = sc.nextInt();
		if (x == 1) {
			DesiredCapabilities ds = new DesiredCapabilities();
			ds.setBrowserName("chrome");
			d = new RemoteWebDriver(new URL(huburl), ds);
		} else if (x == 2) {
			switch (browser) {
			case "chrome":
				d = new ChromeDriver();
				break;
			case "edge":
				d = new EdgeDriver();
				break;
			default:
				System.out.println("Wrong choice\n");
			}
		}
		return d;
	}

}
