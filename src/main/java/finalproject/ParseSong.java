package finalproject;

import java.awt.Graphics2D;
import java.awt.Image;
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

public class ParseSong {
    public static int videoWidth = 320;
    public static int videoHeight = 180;

    public void goParse(String website, String folder) {
        String id = getID(website);
        getVideoPicturebyWebsite(id, folder);
        getOthersByAPI();//TODO
        String title = "";
        getMp3bySelenium(website, title);
    }

    public String getID(String website) {
        if(!website.contains("=")) {
            System.err.println("Error: ParseSong/getID - wrong website");
            return null;
        }
        website = website.substring(website.indexOf("="));
        System.out.println("ID = " + website);
        return website;
    }

    public void getVideoPicturebyWebsite(String id, String folder) {
        String website = "https://img.youtube.com/vi/" + id + "/maxresdefault.jpg";
        String path = "";
        try {
            URL url = new URL(website);
            InputStream in = url.openStream();
            //resize image
            BufferedImage image = ImageIO.read(in); 
            BufferedImage resizedImage = resizeImage(image);
            // save image
            File file = new File("/pic/" + path + ".jpg");//-----------------------------------TODO:圖片名字
            ImageIO.write(resizedImage, "jpg", file);
            in.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
            return;
        } catch (NullPointerException n) {
            System.out.println("Error: ParseSong/getID - no file can be write");
            n.printStackTrace();
            return;
        }
    }

    private BufferedImage resizeImage(BufferedImage image) {
        Image im = image.getScaledInstance(videoWidth, videoHeight, Image.SCALE_SMOOTH);
        BufferedImage resizedImage = new BufferedImage(videoWidth, videoHeight, BufferedImage.TYPE_INT_ARGB);
        
        Graphics2D graph = resizedImage.createGraphics();
        graph.drawImage(im, 0, 0, null);
        graph.dispose();
        
        return resizedImage;
    }

    public void getOthersByAPI() {

    }
   
    public void getMp3bySelenium(String website, String title) {
        System.setProperty("webdriver.chrome.driver", "C:/Program Files/Google/Chrome/pplication/chromedriver.exe"); //TODO：might be change
		
		WebDriver driver = new ChromeDriver();
		//parse file
		driver.get("https://mp3-juices.nu/ajdO/");
		WebElement element = driver.findElement(By.id("query") );
		element.sendKeys(website);
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
		//move file
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
