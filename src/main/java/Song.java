import java.io.Serializable;

public class Song implements Serializable {
    boolean isMP4;
    String name;
    String website;
    Song(boolean isMP4, String name, String website) {
        this.isMP4 = isMP4;
        this.name = name;
        this.website = website;
    }
}