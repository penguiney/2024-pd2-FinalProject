import java.io.BufferedInputStream;
import java.io.FileInputStream;
import javazoom.jl.player.Player;
import javazoom.jl.player.advanced.AdvancedPlayer;

public class testMP3Player {
    public static void AdvancedPlayer(String filename) { // the first type of player
        try {
            FileInputStream fis = new FileInputStream(filename);
            BufferedInputStream bis = new BufferedInputStream(fis);
            AdvancedPlayer player = new AdvancedPlayer(bis);
            player.play();
        } catch (Exception e) {
            System.out.println("Problem playing file " + filename);
            System.out.println(e);
        }
    }

    public static void MP3player(String filename) { // the second type of player
        try {
            Player player = new Player(new FileInputStream(filename));
            player.play();
        } catch (Exception e) {
            System.out.println("Problem playing file " + filename);
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        String filepath = "./music/testMP3.mp3";
        MP3player(filepath);
    } 
}