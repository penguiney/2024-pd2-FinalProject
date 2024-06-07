package finalproject;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ParseSongBySelenium
{
    public static void main(String[] args) {
		//Not ready




		//若瀏覽器安裝位置為預設則webDriver會自動搜尋path設定的位置，也可以使用System.setProperty 來指定路徑
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\Application\\chromedriver.exe");
		//Selenium對不同瀏覽器提供了不同的webDriver
		WebDriver driver = new ChromeDriver(); // googleChrome
		// Firefox
		//WebDriver firefoxDriver = new FirefoxDriver();  
		// 到Google首頁
		driver.get("https://mp3-juices.nu/ajdO/");
		
		WebElement element = driver.findElement(By.id("query") );
		element.sendKeys("https://www.youtube.com/watch?v=8QHaRNPCvMk");

		//element = driver.findElement(By.);
		element.sendKeys("\n");

		try {
			TimeUnit.SECONDS.sleep(2);
		} catch ( InterruptedException e) {
			e.printStackTrace();
		}

		element = driver.findElement(By.className("1"));
		element.click();

		try {
			TimeUnit.SECONDS.sleep(5);
		} catch ( InterruptedException e) {
			e.printStackTrace();
		}

		element.click();
		//青蛙撞奶
		Path sourcePath = Paths.get(System.getProperty("user.home") + "/下載/" + "青蛙撞奶" + ".txt");
    	Path targetPath = Paths.get("./music/");

    	try {
     		Files.move(sourcePath, targetPath);
    	} catch (FileAlreadyExistsException ex) {
      		System.out.println("Error: ParseSongBySelenium - file already exist");
    	} catch (IOException io) {
			System.out.println("Error: ParseSongBySelenium - I/O error");
    	}

	}
}
