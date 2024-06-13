import java.io.Serializable;

public class Song implements Serializable {
    boolean isMP4;
    String name;
    String website;
    String shortName;
    String mediumName;
    Song(boolean isMP4, String name, String website) {
        this.isMP4 = isMP4;
        this.name = name;
        this.website = website;
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