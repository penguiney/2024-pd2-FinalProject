import java.io.Serializable;

public class Song implements Serializable {
    private static final long serialVersionUID = 1L;
    String trueName;
    String name;
    String shortName;
    String mediumName;
    Song(String name, String trueName) {
        this.trueName = trueName;
        this.name = name;
        shortName = name;
        mediumName = name;

        int shortn = 15; boolean reachShort = false;
        int mediumn = 25;
        int size = 0;
        for(int i = 1; i <= name.length(); i++) {
            size++;
            if((name.indexOf(i-1) >= 0x4e00)&&(name.indexOf(i-1) <= 0x9fbb))  size++;
            if(size >= shortn) {
                if(size >= mediumn && reachShort) {
                    mediumName = name.substring(0, i-3) + "...";
                    break;
                }
                if(!reachShort) shortName = name.substring(0, i-3) + "...";
                reachShort = true;
            }
        }
    }
}