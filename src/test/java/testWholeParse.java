import java.util.regex.Pattern;

public class testWholeParse {
    public static void main(String[] args) {
        ParseSong parsebot = new ParseSong();
        ListStruct struct = new ListStruct();
        struct.addList("Test_Folder");
        parsebot.goParse("https://www.youtube.com/watch?v=1tTarGJlzW4", "Test_Folder");
        struct.printRoot();
    }
}
