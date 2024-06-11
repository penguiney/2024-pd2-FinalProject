<<<<<<< HEAD:src/test/java/finalproject/TestApi.java


=======
>>>>>>> d8ce52da585265c15cacfd9574043a6601ec52d3:src/test/java/TestApi.java
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestApi {
    public static void main(String[] args) {
        //known
        String api = "AIzaSyAUlDMhU-2Oao7I23dk68R8ilYP6_L0LQc";
        String id = "jeqH4eMGjhY";

        //will get
        String title = "";
        

		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\Application\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver(); // googleChrome

        String url = "https://www.googleapis.com/youtube/v3/videos?id=" + id + "&key=" + api + "&part=snippet";

        driver.get(url);
        String content = driver.findElement(By.xpath("/html/body/pre")).getText();

        content = content.substring(content.indexOf("\"title\": "));
        content = content.substring(10);
        title = content.substring(0, content.indexOf('\"'));
        System.out.println(title);
        //System.out.println(content);
    }
}
