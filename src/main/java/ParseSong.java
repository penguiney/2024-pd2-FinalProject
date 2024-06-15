

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
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ParseSong {
    

    public static int videoWidth = 320;
    public static int videoHeight = 180;

    public boolean goParse(String website, String name, String folder) {
        WaitingMessege waitingMessege = new WaitingMessege();
        ListStruct struct = new ListStruct();
        String api_key = "AIzaSyAUlDMhU-2Oao7I23dk68R8ilYP6_L0LQc";
        String id = getID(website);
        String trueName = "";

        waitingMessege.messege(1);
        System.out.println("parsing 1/5...");
        trueName = getNameByAPI(id, api_key);
        waitingMessege.messege2(trueName);
        File file = new File("./music/" + trueName + ".mp3");
        if(file.exists()) {
            waitingMessege.messege(6);
            System.out.println("Warning: ParseSong/goParse - file already exist");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch ( InterruptedException e) {
                e.printStackTrace();
            }
            waitingMessege.dispose();
            return struct.addSong(folder, name, trueName);
        }
        waitingMessege.messege(2);
        System.out.println("parsing 2/5...");
        getMp3bySelenium(website, trueName, waitingMessege);
        System.out.println("parsing 5/5...");
        getVideoPicturebyWebsite(trueName, id);
        System.out.println("add song...");
        waitingMessege.dispose();
        return struct.addSong(folder, name, trueName);
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
        title = content.substring(0, content.indexOf("\"description\"")-11);
        System.out.println(title);
        driver.close();
        System.out.println("Getting title successfully");

        String regEx = "[^\\u4e00-\\u9fa5A-Za-z0-9.\\-~=:,() ]+";
        title = Pattern.compile(regEx).matcher(title).replaceAll("").trim();
        title = Pattern.compile("[|]+").matcher(title).replaceAll("").trim();
        title = Pattern.compile(":").matcher(title).replaceAll("_").trim();
        System.out.println(title);
        return title;
    }
   
    public void getMp3bySelenium(String website, String title, WaitingMessege waitingMessege) {
        System.out.println("Start getting Mp3...");

        ChromeOptions co = new ChromeOptions();
		co.addArguments("--headless=new");
        System.setProperty("webdriver.chrome.driver", "C:/Program Files/Google/Chrome/Application/chromedriver.exe");
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
        waitingMessege.messege(3);
        System.out.println("parsing 3/5...");
        try {
            boolean ready = false;
            while(true) {
                try {
                    element = driver.findElement(By.className("completed"));
                } catch (NoSuchElementException n) {ready = false;}
                if (ready) break;
                ready = true;
                TimeUnit.SECONDS.sleep(1);
                System.out.println("..");
            }     
		} catch ( InterruptedException e) {
			e.printStackTrace();
		}
        waitingMessege.messege(4);
        System.out.println("parsing 4/5...");
		element.click();
		//---move file
        String oldPlace = System.getProperty("user.home") + "/Downloads/" + title + ".mp3";
        try {
            File file = new File(oldPlace);
            while(!file.exists())  {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("...");
            }
		} catch ( InterruptedException e) {
			e.printStackTrace();
		}
        waitingMessege.messege(5);
        System.out.println("parsing 5/5...");
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
