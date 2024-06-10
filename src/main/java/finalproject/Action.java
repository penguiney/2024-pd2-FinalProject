

import java.awt.event.*;;

public class Action extends EnterScreen{
    private ListStruct struct;
    public Action(ListStruct struct){
        this.struct = struct;
    }

    public void actionPerformed(ActionEvent e){  //override actionPerformes of OpenFolder 
        String buttonAction = e.getActionCommand();
        if(buttonAction.equals("last page to EnterScreen")){
            isInEnterScreen = true;
            exitOpenFolderScreen();
            appearEnterScreen();
            repaint();
        }
        else if (buttonAction.equals("go to EnterSong")){
            exitOpenFolderScreen();
            appearEnterSong();
            repaint();
        }else if(buttonAction.equals("last to OpenFolder")){
            exitEnterSong();
            appearOpenFolderScreen();
            repaint();
        }else if(buttonAction.equals("createFolder")){
            appearInputFolderName();
        }else if(buttonAction.equals("ensure Folder")){
            struct.addList(getFolderName());
            exitinputFolderName();
        }
    }
}
