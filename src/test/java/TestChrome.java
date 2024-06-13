import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestChrome {
    public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\Application\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver(); // googleChrome
		// Firefox
		
		driver.get("https://en.ytmp3s.nu/EFcx/");
		String title = driver.getTitle();
		System.out.print(title);
	}
}


