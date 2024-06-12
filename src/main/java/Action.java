import java.awt.event.*;;

public class Action extends EnterScreen{
    private ListStruct struct;
    private Folder operateFolder = null;

    public Action(ListStruct struct){
        this.struct = struct;
    }

    public void actionPerformed(ActionEvent e){  //override actionPerformes for all class 
        String buttonAction = e.getActionCommand();
        if(buttonAction.equals("last page to EnterScreen")){ //"OpenFolder" to "EnterScreen"
            isInEnterScreen = true;
            exitOpenFolderScreen();
            appearEnterScreen();
            repaint();
        }else if (buttonAction.equals("go to EnterSong")){  //"OpenFolder" to "EnterSong"
            if(operateFolder == null){
                appearWarnScreen("No Folder Selected");
            }else{
                exitOpenFolderScreen();
                //add folder to do
                appearEnterSong(operateFolder);
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
        }else if(buttonAction.equals("ensure warn to OpenFolder")){ //"WanrScreen" to "OpenFolder"
            exitWarnScreen();
        }else if (buttonAction.equals("previous page")){ //On "OpenFolder"
            exitOpenFolderScreen();
            appearFolderIndex -= 4;
            appearOpenFolderScreen();
            repaint();
        }else if(buttonAction.equals("next page")){ //On "OpenFolder"
            exitOpenFolderScreen();
            appearFolderIndex += 4;
            appearOpenFolderScreen();
            repaint();
        }else if(buttonAction.equals("last to OpenFolder")){ //"EnterSong" to "OpenFolder"
            exitEnterSong();
            setStruct(struct);
            struct.printRoot(); //know name of folder
            appearOpenFolderScreen();
            repaint();
        }else if(buttonAction.equals("add Song")){ //"EnterSong" to "inputSongName"
            appearInputSongName();
        }else{    //on "OpenFolder" when button of folder is clicked
            for(int folderIndex = 0;folderIndex < folderList.size();folderIndex++){  //when folder button is clicked, operate action on this folder
                folderList.get(folderIndex).setEnabled(true);
                if(buttonAction.equals(folderList.get(folderIndex).getText())){
                    folderList.get(folderIndex).setEnabled(false);
                    operateFolder = Main.root.listContent.get(folderIndex);
                }
            }
        }

    }

    public void mouseClicked(MouseEvent mouseEvent) {
        OpenFolder openFolder = new OpenFolder();
        if(isInEnterScreen){
            isInEnterScreen = false;
            exitEnterScreen();              
            setStruct(struct);
            struct.printRoot(); //know name of folder
            initialFolderList();
            appearOpenFolderScreen();
            repaint();                      //refresh screen
        }
    }
}
