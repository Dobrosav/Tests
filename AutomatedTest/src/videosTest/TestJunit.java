package videosTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Scanner;

import org.junit.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TestJunit {
	public static ChromeDriver driver;
	@Before
	public void before() {
		driver=new ChromeDriver();
		driver.get("https://classtranscribe-dev.ncsa.illinois.edu/");
	}
	@Test
	public void checkTitle() {
		assertEquals("ClassTranscribe", driver.getTitle());
	}
	@Test
	public void testSignIn() {
		driver.findElement(By.className("MuiButtonBase-root")).click();
		driver.findElement(By.id("Test")).click();
	//	waitForPageLoad();
	//	assertEquals("Test User", driver.findElement(By.tagName("strong")).getText());
		driver.get("https://classtranscribe-dev.ncsa.illinois.edu/video?id=696f4642-a2cb-4bb8-b9c9-f0af26e5677d");
	}
	
	@Test
	public void testVideoEntry() {
		driver.get("https://classtranscribe-dev.ncsa.illinois.edu/video?id=696f4642-a2cb-4bb8-b9c9-f0af26e5677d");
	}
	@Test
	public void testPlayOrPaused() {
		driver.findElement(By.id("play-btn")).click();
	}
	@Test
	public void editFirstTitle() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String desiredText;
		Scanner s=new Scanner(System.in);
		desiredText=s.nextLine();
		js.executeScript("document.getElementById('caption-line-textarea-0d01ddb7-057c-4e72-9e34-0f17943eb690').innerHTML="+ desiredText);
	}
	@Test
	public void testPlay() {
		driver.findElement(By.cssSelector("watch-ctrl-button")).click();
	}
	@Test
	public void close() {
		driver.close();
	}
}