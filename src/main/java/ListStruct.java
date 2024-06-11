import java.io.Serializable;
import java.util.ArrayList;

public class ListStruct {
    DataList datalist = new DataList();
    
    public Folder searchFolderByName (String name) {
        for(Folder f : Main.root.listContent) {
            if(f.name.equals(name)) return f;
        }
        System.err.println("Error: ListStruct/searchFolderByName - No such folder");
        return null;
    }

    public Song searchSongByName (Folder folder, String name) {
        for(Song s : folder.content) {
            if(s.name.equals(name)) return s;
        }
        System.err.println("Error: ListStruct/searchSongByName - No such song");
        return null;
    } 

    public boolean searchFolder (String name) {
        for(Folder f : Main.root.listContent) if(f.name.equals(name)) return true;
        return false;
    }

    public boolean searchSong (Folder folder, String name) {
        for(Song s : folder.content) if(s.name.equals(name)) return true;
        return false;
    }

    public void addList(String name) {
        Folder folder = new Folder(name);
        if(searchFolder(name)) {
            System.out.println("Error: ListStruct/addList - List already exist"); 
            return; 
        }
        Main.root.listContent.add(folder);
        System.out.println("AddList Successfully");
        System.out.println(name);
        datalist.saveList();
    }

    public void addSong(String folderName, boolean isMP4, String name, String website) { //listName = FoderName
        Song song = new Song(isMP4, name, website);
        
        Folder folder = searchFolderByName(folderName);
        if(searchSong(folder, name)) {
            System.out.println("Error: ListStruct/addSong - Song already exist"); 
            return; 
        }
        folder.content.add(song);
        System.out.println("AddSong Successfully");
        datalist.saveList();
    }

    public void deleteList(String name) { //list = forder
        Main.root.listContent.remove(searchFolderByName(name));
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
        for(Folder f : Main.root.listContent) {
            for(Song s : f.content) {
                System.out.println("Folder name: " + f.name +" Song name: " + s.name + "\n");
            }
        }
    }
}



