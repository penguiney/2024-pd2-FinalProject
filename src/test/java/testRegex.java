import java.util.regex.Pattern;

public class testRegex {
    public static void main(String[] args) {
        String title = "Cyberpunk: Edgerunners song HEALTH– Major Crimes-";
        String regEx = "[^\\u4e00-\\u9fa5A-Za-z0-9.\\-~=: ]+";
        title = Pattern.compile(regEx).matcher(title).replaceAll("").trim();
        title = Pattern.compile("[|]+").matcher(title).replaceAll("").trim();
        title = Pattern.compile(":").matcher(title).replaceAll("_").trim();
        System.out.println(title);
    }
}
