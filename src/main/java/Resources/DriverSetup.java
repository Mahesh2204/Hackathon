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
		String Run = "local";

		if (Run.equals("remote")) {
			DesiredCapabilities ds = new DesiredCapabilities();
			ds.setBrowserName("chrome");
			d = new RemoteWebDriver(new URL(huburl), ds);
		} else if (Run.equals("local")) {
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
