import java.io.Serializable;
import java.util.ArrayList;

public class ListStruct {
    private ArrayList<Folder> root;
    DataList datalist = new DataList();
    ListStruct() {
        this.root = Main.root;
    }  
    
    public Folder searchFolderByName (String name) {
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
        Folder folder = new Folder(name);
        root.add(folder);
        System.out.println("AddList Successfully");
        System.out.println(name);
        datalist.saveList();
    }

    public void addSong(String folderName, boolean isMP4, String name, String website) { //listName = FoderName
        Song song = new Song(isMP4, name, website);

        Folder folder = searchFolderByName(folderName);
        folder.content.add(song);
        System.out.println("AddSong Successfully");
        datalist.saveList();
    }

    public void deleteList(String name) { //list = forder
        root.remove(searchFolderByName(name));
        System.out.println("DeleteList Successfully");
        datalist.saveList();
    }

    public void deleteSong(String folderName, String name) {
        Folder folder = searchFolderByName(folderName);
        folder.content.remove(searchSongByName(folder, name));
        System.out.println("DeleteSong Successfully");
        datalist.saveList();
    }

    public void moveSong(String name, String oldFolderName, String newFolderName) {
        Folder oldFolder = searchFolderByName(oldFolderName);
        Song theSong = searchSongByName(oldFolder, name);

        addSong(newFolderName, theSong.isMP4, theSong.name, theSong.website);
        deleteSong(oldFolderName, name);
        System.out.println("MoveSong Successfully");
        datalist.saveList();
    }

    public void printRoot() {
        for(Folder f : root) 
            for(Song s : f.content) 
                System.out.println("Folder name: " + f.name +" Song name: " + s.name + "\n");
    }
}

class Folder implements Serializable {
    String name;
    int length;
    ArrayList <Song> content;
    Folder(String name) {
        this.name = name;
        this.content = new ArrayList<Song>();
    }
}

class Song implements Serializable {
    boolean isMP4;
    String name;
    String website;
    Song(boolean isMP4, String name, String website) {
        this.isMP4 = isMP4;
        this.name = name;
        this.website = website;
    }
}