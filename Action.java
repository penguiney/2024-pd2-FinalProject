import java.awt.event.*;;

public class Action extends EnterScreen{
    public void actionPerformed(ActionEvent e){  //override actionPerformes of OpenFolder 
        String buttonAction = e.getActionCommand();
        if(buttonAction == "last page to EnterScreen"){
            isInEnterScreen = true;
            exitOpenFolderScreen();
            appearEnterScreen();
            repaint();
        }
        else if (buttonAction == "go to EnterSong"){
            exitOpenFolderScreen();
            appearEnterSong();
            repaint();
        }else if(buttonAction == "last to OpenFolder"){
            exitEnterSong();
            appearOpenFolderScreen();
            repaint();
        }
    }
}
