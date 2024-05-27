import java.util.ArrayList;

public class ListStruct {

    public void addList(String name) {
        root = main.root;
        Folder folder = new Folder(name);
        root.list.add(folder);
        System.out.println("AddList Successfully");
    }
    public void addSong(String folderName, boolean isMP4, String name, String title, String website, int time) { //listName = FoderName
        root = main.root;
        int index = root.list.indexOf(folderName);
        if (index == -1) addList(folderName);

        Song song = new Song(isMP4, name, title, website, time);

        Folder folder = root.list[index];
        folder.content.add(song);
        System.out.println("AddSong Successfully");
    }
    public void deleteList(String name) { //list = forder
        root = main.root;
        root.list.remove(name);
        System.out.println("DeleteList Successfully");
    }
    public void deleteSong(String name) {
        root = main.root;
        int index = root.list.indexOf(name);
        if (index == -1) {
            System.out.println("Error : Folder " + name + " not exist");
            return;
        }
        Folder folder = root.list[index];
        folder.remove(index);
        System.out.println("DeleteSong Successfully");
    }
    public void moveSong(String name, String oldFolderName, String newFolderName) {
        root = main.root;
        int oldIndex = root.list.indexOf(oldFolderName);
        int newIndex = root.list.indexOf(newFolderName);
        if  (oldIndex == -1) {
            System.out.println("Error : Folder " + oldFolderName + " not exist");
            return;
        }
        if  (newIndex == -1) {
            System.out.println("Error : Folder " + newFolderName + " not exist");
            return;
        }
        //?


        System.out.println("MoveSong Successfully");
    }
    //search
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