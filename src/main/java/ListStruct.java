import java.io.Serializable;
import java.util.ArrayList;

public class ListStruct {
    DataList datalist = new DataList();
    
    public Folder searchFolderByName (String trueName) {
        for(Folder f : Main.root.listContent) {
            if(f.name.equals(trueName)) return f;
        }
        System.err.println("Error: ListStruct/searchFolderBytrueName - No such folder");
        return null;
    }

    public Song searchSongBytrueName (Folder folder, String trueName) {
        for(Song s : folder.content) {
            if(s.trueName.equals(trueName)) return s;
        }
        System.err.println("Error: ListStruct/searchSongBytrueName - No such song");
        return null;
    } 

    public boolean searchFolder (String trueName) {
        for(Folder f : Main.root.listContent) if(f.name.equals(trueName)) return true;
        return false;
    }

    public boolean searchSong (Folder folder, String trueName) {
        for(Song s : folder.content) if(s.trueName.equals(trueName)) return true;
        return false;
    }

    public boolean addList(String trueName) {
        Folder folder = new Folder(trueName);
        if(searchFolder(trueName)) {
            System.out.println("Error: ListStruct/addList - List already exist"); 
            return false; 
        }
        Main.root.listContent.add(folder);
        System.out.println("AddList Successfully");
        System.out.println(trueName);
        datalist.saveList();
        return true;
    }

    public boolean addSong(String folderName, String name, String trueName) { //listtrueName = FodertrueName
        Song song = new Song(name, trueName);
        
        Folder folder = searchFolderByName(folderName);
        if(searchSong(folder, trueName)) {
            System.out.println("Error: ListStruct/addSong - Song already exist"); 
            return false; 
        }
        folder.content.add(song);
        System.out.println("AddSong Successfully");
        datalist.saveList();
        return true;
    }

    public void deleteList(String trueName) { //list = forder
        Main.root.listContent.remove(searchFolderByName(trueName));
        System.out.println("DeleteList Successfully");
        datalist.saveList();
    }

    public void deleteSong(String folderName, String trueName) {
        Folder folder = searchFolderByName(folderName);
        folder.content.remove(searchSongBytrueName(folder, trueName));
        System.out.println("DeleteSong Successfully");
        datalist.saveList();
    }

    public void moveSong(String trueName, String oldfolderName, String newfolderName) {
        Folder oldFolder = searchFolderByName(oldfolderName);
        Song theSong = searchSongBytrueName(oldFolder, trueName);
        deleteSong(oldfolderName, trueName);
        addSong(newfolderName, theSong.name, theSong.trueName);
        System.out.println("MoveSong Successfully");
        datalist.saveList();
    }

    public void printRoot() {
        for(Folder f : Main.root.listContent) 
        {
            System.out.println("Folder trueName: "+f.name);
            for(Song s : f.content) 
                System.out.println("Folder trueName: " + f.name +" Song trueName: " + s.trueName + "\n");
        }    
    }

    public ArrayList<Folder> getRoot(){
        return Main.root.listContent;
    }
}



