package videosTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class VideosTest {
	private static ChromeDriver driver; 
	private List<WebElement> videoslist;
	private ListIterator<WebElement> theListOfVideos;
	public VideosTest() throws InterruptedException {
		driver=new ChromeDriver();
		driver.get("https://classtranscribe-dev.ncsa.illinois.edu/");
		driver.findElement(By.className("MuiButtonBase-root")).click();
		driver.findElement(By.id("Test")).click();
		
	//	driver.findElement(By.className("material-icons")).click();
	//	driver.get("https://classtranscribe-dev.ncsa.illinois.edu/offering/7cbe09d4-1a12-4335-937a-cf989e3280c9");
		//driver.findElement(By.className("MuiFormControlLabel-root")).click();
		Thread.sleep(5000);
		driver.get("https://classtranscribe-dev.ncsa.illinois.edu/instructor/my-courses");
	}
	public void getTitle() {
		String s=driver.getTitle();
		System.out.println(s);
	}
	public void enterToCourses() {
		//driver.get("https://classtranscribe-dev.ncsa.illinois.edu/instructor/my-courses");
		//driver.findElement(By.className("MuiFormControlLabel-root")).click();
	}
	public static void enterToSomeVideo() {
		driver.get("https://classtranscribe-dev.ncsa.illinois.edu/video?id=696f4642-a2cb-4bb8-b9c9-f0af26e5677d");
	}
	public static void pause(){
		driver.findElement(By.id("play-btn")).click();
	}
	public void close() {
		driver.close();
	}
	public static void editFirstTitle() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String desiredText;
		Scanner s=new Scanner(System.in);
		desiredText=s.nextLine();
		js.executeScript("document.getElementById('caption-line-textarea-0d01ddb7-057c-4e72-9e34-0f17943eb690').innerHTML="+ desiredText);
	}
	public static void play() {
		// TODO Auto-generated method stub
		driver.findElement(By.cssSelector(".watch-ctrl-button")).click();
	}
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vd180005d\\Downloads\\chromedriver_win32\\chromedriver.exe");
		VideosTest test=new VideosTest();
		Thread.sleep(5000);
		//VideosTest.enterToCourses();
		VideosTest.enterToSomeVideo();
		Thread.sleep(10000);
		VideosTest.pause();//pause the video
		Thread.sleep(10000);
		VideosTest.play();// play the video
		VideosTest.editFirstTitle();
		Thread.sleep(5000);
		test.close();
	}
	

}
