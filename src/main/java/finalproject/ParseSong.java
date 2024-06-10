

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;

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

public class ParseSong {
    public static int videoWidth = 320;
    public static int videoHeight = 180;

    public void goParse(String website, String folder) {
        String api_key = "AIzaSyAUlDMhU-2Oao7I23dk68R8ilYP6_L0LQc";
        String id = getID(website);
        String name = "";


        name = getNameByAPI(id, api_key);
        getMp3bySelenium(website, name);
        getVideoPicturebyWebsite(name, id);

        ListStruct struct = new ListStruct();
        struct.addSong(folder, false, name, website);
    }

    public String getID(String website) {
        if(!website.contains("=")) {
            System.err.println("Error: ParseSong/getID - wrong website");
            return null;
        }
        website = website.substring(website.indexOf("=") + 1);
        System.out.println("Getting ID successfully");
        return website;
    }

    public void getVideoPicturebyWebsite(String title, String id) {
        System.out.println("Start getting Picture...");

        String website = "https://img.youtube.com/vi/" + id + "/maxresdefault.jpg";
        try {
            URL url = new URL(website);
            InputStream in = url.openStream();
            BufferedImage image = ImageIO.read(in); 
            // save image
            File file = new File("./picture/" + title + ".jpg");
            ImageIO.write(image, "jpg", file);
            in.close();
            System.out.println("Getting Picture successfully");
        } catch (IOException ioe) {
            ioe.printStackTrace();
            return;
        } catch (NullPointerException n) {
            System.out.println("Error: ParseSong/getID - no file can be write");
            n.printStackTrace();
            return;
        }
    }
    public String getNameByAPI(String id, String key) {
        System.out.println("Start getting title...");

        String title = "";
        String url = "https://www.googleapis.com/youtube/v3/videos?id=" + id + "&key=" + key + "&part=snippet";

        ChromeOptions co = new ChromeOptions();
		co.addArguments("-headless");
		System.setProperty("webdriver.chrome.driver", "C:/Program Files/Google/Chrome/Application/chromedriver.exe");
		WebDriver driver = new ChromeDriver(co);//website invisible

        driver.get(url);
        String content = driver.findElement(By.xpath("/html/body/pre")).getText();
        //dividing
        content = content.substring(content.indexOf("\"title\": "));
        content = content.substring(10);
        title = content.substring(0, content.indexOf('\"'));
        System.out.println(title);
        driver.close();
        System.out.println("Getting title successfully");
        return title;
    }
   
    public void getMp3bySelenium(String website, String title) {
        System.out.println("Start getting Mp3...");

        ChromeOptions co = new ChromeOptions();
		co.addArguments("-headless");
        System.setProperty("webdriver.chrome.driver", "C:/Program Files/Google/Chrome/Application/chromedriver.exe"); //TODO�?might be change
		WebDriver driver = new ChromeDriver(co);//website invisible

		//---parse file
		driver.get("https://mp3-juices.nu/ajdO/");
		WebElement element = driver.findElement(By.id("query") );
		element.sendKeys(website);
        try {
			TimeUnit.SECONDS.sleep(1);
		} catch ( InterruptedException e) {
			e.printStackTrace();
		}
		element.sendKeys("\n");
		try {
			TimeUnit.SECONDS.sleep(1);
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
		//---move file
        String oldPlace = System.getProperty("user.home") + "/Downloads/" + title + ".mp3";
        try {
            File file = new File(oldPlace);
            while(!file.exists()) TimeUnit.SECONDS.sleep(1);
		} catch ( InterruptedException e) {
			e.printStackTrace();
		}
		Path oldPath = Paths.get(oldPlace);
    	Path newPath = Paths.get("./music/" + title + ".mp3");
    	try {
     		Files.move(oldPath, newPath);
    	} catch (FileAlreadyExistsException ex) {
      		System.out.println("Error: ParseSongBySelenium - file already exist");
    	} catch (IOException io) {
			System.out.println("Error: ParseSongBySelenium - I/O error");
    	}  
        driver.quit();
        System.out.println("Getting Mp3 successfully");
    }
}