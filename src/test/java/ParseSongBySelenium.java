5import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ParseSongBySelenium
{
    public static void main(String[] args) {
		ChromeOptions co = new ChromeOptions();
		co.addArguments("-headless");

		System.setProperty("webdriver.chrome.driver", "C:/Program Files/Google/Chrome/Application/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver(); 
		
		driver.get("https://mp3-juices.nu/ajdO/");
		
		WebElement element = driver.findElement(By.id("query") );
		element.sendKeys("https://www.youtube.com/watch?v=8QHaRNPCvMk");

		//element = driver.findElement(By.);
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch ( InterruptedException e) {
			e.printStackTrace();
		}
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
		//?????????å¥?
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch ( InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Start moving...");

		Path sourcePath = Paths.get(System.getProperty("user.home") + "/Downloads/" + "?????????å¥?" + ".mp3");
    	Path targetPath = Paths.get("./music/" + "?????????å¥?" + ".mp3");

    	try {
     		Files.move(sourcePath, targetPath);
    	} catch (FileAlreadyExistsException ex) {
      		System.out.println("Error: ParseSongBySelenium - file already exist");
    	} catch (IOException io) {
			System.out.println("Error: ParseSongBySelenium - I/O error");
    	}

		driver.quit();
	}
}
