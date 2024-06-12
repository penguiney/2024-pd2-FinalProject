import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestChrome {
    public static void main(String[] args) {
		//??¥ç??è¦½å?¨å??è£?ä½?ç½®ç?ºé??è¨­å??webDriver?????ªå?????å°?pathè¨­å?????ä½?ç½®ï??ä¹???¯ä»¥ä½¿ç?¨System.setProperty ä¾????å®?è·¯å??
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\Application\\chromedriver.exe");
		//Seleniumå°?ä¸???????è¦½å?¨æ??ä¾?äº?ä¸???????webDriver
		WebDriver driver = new ChromeDriver(); // googleChrome
		// Firefox
		//WebDriver firefoxDriver = new FirefoxDriver();  
		// ??°Googleé¦????
		driver.get("https://en.ytmp3s.nu/EFcx/");
		// ???å¾?pageTitle
		String title = driver.getTitle();
		System.out.print(title);
	}
}


