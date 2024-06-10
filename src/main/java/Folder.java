import java.io.Serializable;
import java.util.ArrayList;

public class Folder implements Serializable {
    String name;
    int length;
    ArrayList <Song> content;
    Folder(String name) {
        this.name = name;
        this.content = new ArrayList<Song>();
    }
}