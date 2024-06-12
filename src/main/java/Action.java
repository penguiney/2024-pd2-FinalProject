import java.awt.event.*;;

public class Action extends EnterScreen{
    private ListStruct struct;
    private Folder operateFolder = null;
    private boolean isFolder = false;
    private boolean isSong = false;  //know what type in this screen
    private Song operateSong = null;
    private Folder olderOperaFolder;
    private boolean isMove = false;
    private boolean isStartSong = false;

    public Action(ListStruct struct){
        this.struct = struct;
    }

    public void actionPerformed(ActionEvent e){  //override actionPerformes for all class 
        String buttonAction = e.getActionCommand();
        if(buttonAction.equals("last page to EnterScreen")){ //"OpenFolder" to "EnterScreen"
            isInEnterScreen = true;
            exitOpenFolderScreen();
            appearEnterScreen();
            isFolder = false;
            repaint();
        }else if (buttonAction.equals("go to EnterSong")){  //"OpenFolder" to "EnterSong"
            if(operateFolder == null){
                appearWarnScreen("No Folder Selected");
            }else{
                if(isMove){
                    struct.moveSong(operateSong.name, olderOperaFolder.name, operateFolder.name);
                    operateFolder = olderOperaFolder;
                }
                else 
                    operateSong = null; //initial operateSong
                isMove= false;
                exitOpenFolderScreen();
                initialSongList(operateFolder);
                appearEnterSong();
                isFolder = false;
                isSong = true;
                repaint();
            }
        }else if(buttonAction.equals("createFolder")){   //on "OpenFolder" open "inputFolderName"
            appearInputFolderName();
        }else if(buttonAction.equals("ensure Folder")){  //"inputFolderName" to "OpenFolder"
            struct.addList(getFolderName());
            exitinputFolderName();
            struct.printRoot(); //know name of folder
            storeFolderNameButton(getFolderName());
            appearOpenFolderScreen();
            repaint();
        }else if(buttonAction.equals("remove Folder")){ //on "OpenFolder"
            if(operateFolder == null) appearWarnScreen("No Folder Selected");
            else{
                exitOpenFolderScreen();
                removeFolderInFolderList(operateFolder.name);
                struct.deleteList(operateFolder.name);
                initialFolderList();
                appearOpenFolderScreen();
                repaint();
            }
        }else if(buttonAction.equals("ensure warn")){ //"WanrScreen" to "OpenFolder"
            exitWarnScreen();
        }else if (buttonAction.equals("previous Folder page")){ //On "OpenFolder"
            exitOpenFolderScreen();
            appearFolderIndex -= 4;
            appearOpenFolderScreen();
            repaint();
        }else if(buttonAction.equals("next Folder page")){ //On "OpenFolder"
            exitOpenFolderScreen();
            appearFolderIndex += 4;
            appearOpenFolderScreen();
            repaint();
        }else if(buttonAction.equals("last to OpenFolder")){ //"EnterSong" to "OpenFolder"
            exitEnterSong();
            setStruct(struct);
            struct.printRoot(); //know name of folder
            appearOpenFolderScreen();
            isFolder = true;
            isSong = false;
            repaint();
        }else if(buttonAction.equals("add Song")){ //"EnterSong" to "inputSongName"
            appearInputSongName();
        }else if(buttonAction.equals("ensure Song")){ //On "EnterSong" add song
            struct.addSong(operateFolder.name,false,getSongName(),getSongWebsite());
            exitinputSongName();
            exitEnterSong();
            initialSongList(operateFolder);
            appearEnterSong();
        }else if(buttonAction.equals("previous Song page")){// On "EnterSong"
            exitEnterSong();
            appearSongIndex -= 5;
            appearEnterSong();
            repaint();
        }else if(buttonAction.equals("next Song page")){  //On "EnterSong"
            exitEnterSong();
            appearSongIndex += 5;
            appearEnterSong();
            repaint();
        }else if(buttonAction.equals("move song to other folder")){ //wiat need to write
            if(operateSong == null) appearWarnScreen("No Song Selected");
            else{
                olderOperaFolder = operateFolder;
                exitEnterSong();
                isFolder = true;
                isSong = false;
                moveSongToOtherFolder();        //"EnterSong" to "OpenFolder"
                repaint();
                isMove = true;
            }
        }else if(buttonAction.equals("remove song")){  //On "EnterSong"
            if(operateSong == null) appearWarnScreen("No Song Selected");
            else{
                struct.deleteSong(operateFolder.name, operateSong.name);
                exitEnterSong();
                initialSongList(operateFolder);
                appearEnterSong();
                repaint();
            }
        }else if(buttonAction.equals("play song")){  //"EnterSong" to "SongMainScreen"
            if(operateSong == null) appearWarnScreen("No Song Selected");
            else{
                exitEnterSong();
                appearStartSongMainScreen(operateSong);
                repaint();
            }

        }else if(buttonAction.equals("last to EnterSong")){ //"SongMainScreen" to "EnterSong"
            exitSongMainScreen();
            appearEnterSong();
            repaint();
        }else if(buttonAction.equals("Start and Stop")){
            isStartSong = !isStartSong;
            exitSongMainScreen();
            if(isStartSong) appearStopSongMainScreen(operateSong);
            else appearStartSongMainScreen(operateSong);
            repaint();
        } else{    //on "OpenFolder" when button of folder is clicked
            if(isFolder){
                for(int folderIndex = 0;folderIndex < folderList.size();folderIndex++){  //when folder button is clicked, operate action on this folder
                    folderList.get(folderIndex).setEnabled(true);
                    if(buttonAction.equals(folderList.get(folderIndex).getText())){
                        folderList.get(folderIndex).setEnabled(false);
                        operateFolder = Main.root.listContent.get(folderIndex);
                    }
                }
            }else if(isSong){
                for(int songIndex = 0;songIndex < songButtonList.size();songIndex++){  //when song button is clicked, operate action on this folder
                    songButtonList.get(songIndex).setEnabled(true);
                    if(buttonAction.equals(songButtonList.get(songIndex).getText())){
                        songButtonList.get(songIndex).setEnabled(false);
                        operateSong = operateFolder.content.get(songIndex);                
                    }
                }
            }
        }

    }

    public void mouseClicked(MouseEvent mouseEvent) { //"EnterScreen" to "OpenFolder"
        OpenFolder openFolder = new OpenFolder();
        if(isInEnterScreen){
            isInEnterScreen = false;
            exitEnterScreen();              
            setStruct(struct);
            struct.printRoot(); //know name of folder
            initialFolderList();
            appearOpenFolderScreen();
            isFolder = true;
            repaint();                      //refresh screen
        }
    }
}
