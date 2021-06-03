package internship;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;


public class Main {
	private static int count=0;
	private static ArrayList<String> columnValues = new ArrayList<String>();
	//private static ChromeDriver driver;
	private static void readData() {
		Scanner scanner;
		try {
			scanner = new Scanner(new File("C:\\Users\\vd180005d\\Desktop\\pr-data.csv"));
			while(scanner.hasNextLine()) {
	            String values = scanner.nextLine();
	            columnValues.add(values);
	            count++;
	        }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static String status(String url)  {		
		ChromeDriver driver=new ChromeDriver();
		driver.get(url);
		String status=driver.findElement(By.className("State")).getText();
		String sstatus;
		if(status.equals("Open"))
			sstatus="Opened";
		else if(status.equals("Merged") || status.equals("Closed"))
			sstatus= "Accepted";
		else
			sstatus="Rejected";
//		System.out.println(status);
		driver.close();
		return sstatus;
	}
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
			try {
			//	driver=new ChromeDriver();
			readData();
			FileWriter fw;
			String[] status=new String[count];
			status[0]="Status";
			for(int i=1;i<count;i++) {
				String[] tmp=columnValues.get(i).split(",");
				if(i==1000 || i==1002 || i==1001) {
					status[i]=""
							+ "";
				}
				else if(columnValues.get(i).contains("Opened")) {
					String url=tmp[6];
					status[i]=status(url);
					System.out.println(status[i]);
				}
				else if(tmp.length<6)
					status[i]="";
				else 
					status[i]=tmp[5];
				System.out.println(i);
				if(i%200==0)
					Thread.sleep(20000);
			}
				fw = new FileWriter("C:\\Users\\vd180005d\\Desktop\\FixedTests_UnfixedODandIDtestsOutput.csv",true);
				int i=0;
				while(i<count) {		
		//			System.out.println(status[i]);
					fw.write(status[i]+"\n");
					i++;
				}
				fw.close();
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
