package videosTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {
	private static ChromeDriver driver;
	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vd180005d\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://www.bing.com");

		System.out.println("Loaded BING homepage");
		System.out.println("Search for some term and then press ENTER");

		Scanner s=new Scanner(System.in);
		String search=s.nextLine();
		System.out.println(search);
		System.out.println("Clicking on the first link ...");
		driver.findElement(By.id("sb_form_q")).sendKeys(search);
		driver.findElement(By.className("search")).click();
		driver.findElement(By.tagName("h2")).click();

		Thread.sleep(3000);

		driver.quit();
	}

}
