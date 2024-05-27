import java.util.ArrayList;

public class ListStruct {
    public Folder searchFolderByName (String name) {
        ArrayList<Folder> root = Main.root;
        for(Folder f : root) {
            if(f.name == name) return f;
        }
        System.err.println("Error: ListStruct/searchFolderByName - No such folder");
        return null;
    }
    public Song searchSongByName (Folder folder, String name) {
        for(Song s : folder.content) {
            if(s.name == name) return s;
        }
        System.err.println("Error: ListStruct/searchSongByName - No such song");
        return null;
    } 
    public void addList(String name) {
        ArrayList<Folder> root = Main.root;
        Folder folder = new Folder(name);
        root.add(folder);
        System.out.println("AddList Successfully");
    }
    public void addSong(String folderName, boolean isMP4, String name, String title, String website, int time) { //listName = FoderName
        Song song = new Song(isMP4, name, title, website, time);

        Folder folder = searchFolderByName(folderName);
        folder.content.add(song);
        System.out.println("AddSong Successfully");
    }
    public void deleteList(String name) { //list = forder
        ArrayList<Folder> root = Main.root;
        root.remove(searchFolderByName(name));
        System.out.println("DeleteList Successfully");
    }
    public void deleteSong(String folderName, String name) {
        Folder folder = searchFolderByName(folderName);
        folder.content.remove(searchSongByName(folder, name));
        System.out.println("DeleteSong Successfully");
    }
    public void moveSong(String name, String oldFolderName, String newFolderName) {
        Folder oldFolder = searchFolderByName(oldFolderName);
        Song theSong = searchSongByName(oldFolder, name);

        addSong(newFolderName, theSong.isMP4, theSong.name, theSong.title, theSong.website, theSong.time);
        deleteSong(oldFolderName, name);
        System.out.println("MoveSong Successfully");
    }
}
class Folder {
    String name;
    int length;
    ArrayList <Song> content;
    Folder(String name) {
        this.name = name;
    }
}
class Song {
    boolean isMP4;
    String name;
    String title;
    String website;
    int time;
    Song(boolean isMP4, String name, String title, String website, int time) {
        this.isMP4 = isMP4;
        this.name = name;
        this.title = title;;
        this.website = website;
        this.time = time;
    }
}