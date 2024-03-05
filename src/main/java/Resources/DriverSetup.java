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

	String huburl = "http://10.66.136.70:4444";

	public WebDriver SelectDriver() throws MalformedURLException {
		WebDriver d = null;
		DesiredCapabilities ds = new DesiredCapabilities();
		 ds.setBrowserName("chrome");
		d = new RemoteWebDriver(new URL(huburl), ds);
		//Scanner sc = new Scanner(System.in);
		//System.out.println("Enter \n1 for remote webdriver\n2 for local webdriver");
		// int x = sc.nextInt();
		// if (x == 1) {
		// 	DesiredCapabilities ds = new DesiredCapabilities();
		// 	//ds.setCapability("browserName", "chrome");
		// 	ds.setBrowserName("chrome");
		// 	//ds.setBrowserName("MicrosoftEdge");

		// 	d = new RemoteWebDriver(new URL(huburl), ds);
		// } else if (x == 2) {
		// 	System.out.println("Enter the browser to execute \n1.Chrome\n2.Edge");
		// 	int a = sc.nextInt();
		// 	switch (a) {
		// 	case 1:
		// 		d = new ChromeDriver();
		// 		break;
		// 	case 2:
		// 		d = new EdgeDriver();
		// 		break;
		// 	default:
		// 		System.out.println("Wrong choice\n");
		// 	}
		// }
		return d;
	}

}
