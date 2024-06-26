import java.util.*;
import java.awt.MediaTracker;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class OpenFolder extends EnterSong implements ActionListener{
    private JButton lastPage,createFolder,EnterFolder,removeFolder,previousFolderPage,nextFolderPage,moveSong;
    ImageIcon folderImageJpg = new ImageIcon("./picture/folder.png");
    private JLabel folderImage = new JLabel(folderImageJpg);
    public List<JButton> folderList = new ArrayList<>();
    private List<JLabel> folderImageList = new ArrayList<>();
    private ListStruct struct;
    private ArrayList<Folder> root;
    public int appearFolderIndex = 0;

    public OpenFolder(){ 

        lastPage = new JButton("Back");
        lastPage.setBounds(0, 0, 80, 50);
        lastPage.setActionCommand("last page to EnterScreen");
        lastPage.addActionListener(this);

        createFolder = new JButton("create");
        createFolder.setBounds(0, 310, 100, 50);
        createFolder.setActionCommand("createFolder");
        createFolder.addActionListener(this);

        EnterFolder = new JButton("Enter");
        EnterFolder.setBounds(100, 310, 150, 50);
        EnterFolder.setActionCommand("go to EnterSong");
        EnterFolder.addActionListener(this);

        removeFolder = new JButton("Remove");
        removeFolder.setBounds(250, 310, 100, 50);
        removeFolder.setActionCommand("remove Folder");
        removeFolder.addActionListener(this);

        previousFolderPage = new JButton("Previous");
        previousFolderPage.setBounds(0, 360, 175, 50);
        previousFolderPage.setActionCommand("previous Folder page");
        previousFolderPage.addActionListener(this);

        nextFolderPage = new JButton("Next");
        nextFolderPage.setBounds(175, 360, 175, 50);
        nextFolderPage.setActionCommand("next Folder page");
        nextFolderPage.addActionListener(this);

        moveSong = new JButton("move");
        moveSong.setBounds(100, 310, 150, 50);
        moveSong.setActionCommand("go to EnterSong");
        moveSong.addActionListener(this);

        for(int i = 0; i < 4;i++){  //show 4 "folderImage" in screen and order thsm
            folderImage = new JLabel(folderImageJpg);
            if(i == 0) folderImage.setBounds(0, 60, 150, 100);
            else if(i == 1) folderImage.setBounds(200, 60, 150, 100);
            else if(i == 2) folderImage.setBounds(0, 180, 150, 100);
            else if(i == 3) folderImage.setBounds(200, 180, 150, 100);
            folderImageList.add(folderImage);
        }
    }

    public void actionPerformed(ActionEvent e){
        //you need to write, use override
    } 

    public void moveSongToOtherFolder(){
        add(moveSong);
        for(int i = 0;i < 4;i++){
            if(i + appearFolderIndex >= folderList.size()) break;
            add(folderList.get(i+appearFolderIndex));
            add(folderImageList.get(i));
            System.out.println(i+" add successful");
        }
        add(previousFolderPage);
        add(nextFolderPage);

        //ensure num of "folderList".size() can go to "nextFolderPage" or "previousFolderPage"
        previousFolderPage.setEnabled(true);
        nextFolderPage.setEnabled(true);
        if(appearFolderIndex == 0) previousFolderPage.setEnabled(false);
        if(folderList.size() - appearFolderIndex <= 4) nextFolderPage.setEnabled(false);
    }

    public void appearOpenFolderScreen(){
        add(lastPage);
        add(createFolder);
        add(EnterFolder);
        add(removeFolder);
        for(int i = 0;i < 4;i++){
            if(i + appearFolderIndex >= folderList.size()) break;
            System.out.println(i+" folder");
            add(folderList.get(i+appearFolderIndex));
            add(folderImageList.get(i));
        }
        add(previousFolderPage);
        add(nextFolderPage);

        //ensure num of "folderList".size() can go to "nextFolderPage" or "previousFolderPage"
        previousFolderPage.setEnabled(true);
        nextFolderPage.setEnabled(true);
        if(appearFolderIndex == 0) previousFolderPage.setEnabled(false);
        if(folderList.size() - appearFolderIndex <= 4) nextFolderPage.setEnabled(false);
    }

    public void exitOpenFolderScreen(){
        remove(lastPage);
        remove(createFolder);
        remove(EnterFolder);
        remove(removeFolder);
        for(int i = 0;i < 4;i++){
            if(i + appearFolderIndex >= folderList.size()) break;
            remove(folderList.get(i+appearFolderIndex));
            remove(folderImageList.get(i));
        }
        remove(previousFolderPage);
        remove(nextFolderPage);
        remove(moveSong);
    } 

    public void setStruct(ListStruct struct){
        this.struct = struct;
        root = struct.getRoot();
    }

    public void storeFolderNameButton(String name){  //when 'initialFolderList' operate, order all folder
        JButton folderNameButton = new JButton(name);

        if(folderList.size() % 4 == 0)folderNameButton.setBounds(0, 160, 150, 20);
        else if(folderList.size() % 4 == 1) folderNameButton.setBounds(200, 160, 150, 20);
        else if(folderList.size() % 4 == 2) folderNameButton.setBounds(0, 280, 150, 20);
        else if(folderList.size() % 4 == 3) folderNameButton.setBounds(200, 280, 150, 20);
        
        folderNameButton.setActionCommand(name);
        folderNameButton.addActionListener(this);
        folderList.add(folderNameButton);
    }

    public void initialFolderList(){  //when "EnterScreen" to "OpenFolder", we need to load Folders and show them
        folderList = new ArrayList<>();
        for(Folder f : root){
            System.out.println(f.name+" add button");
            storeFolderNameButton(f.name);
        }
    }
    
    public void removeFolderInFolderList(String folderName){  //when folder is removed, erase folder.name in "folderList"
        for(int i = 0;i < root.size();i++){
            if(root.get(i).name.equals(folderName)) folderList.remove(i);
        }
    }
}

