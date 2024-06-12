

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class EnterSong  extends inputFolderName implements ActionListener{
    private JLabel folderNameLabel;
    private JButton addSong,removeSong,moveSong,lastOpenFolder,previousSongPage,nextSongPage,playSong;
    private Folder folder = null;
    private InputSongName inputFolderName = new InputSongName(); 
    public List<JButton> songButtonList = new ArrayList<>();
    private int songPositiveInder = 0;  //index of position of song ordered 
    public int appearSongIndex = 0;

    EnterSong(){
        lastOpenFolder = new JButton("back");
        lastOpenFolder.setBounds(0, 0, 70, 50);
        lastOpenFolder.setActionCommand("last to OpenFolder");
        lastOpenFolder.addActionListener(this);

        addSong = new JButton("Add");
        addSong.setBounds(0,50,110,50);
        addSong.setActionCommand("add Song");
        addSong.addActionListener(this);

        removeSong = new JButton("remove");
        removeSong.setBounds(110, 50, 130, 50);
        removeSong.setActionCommand("remove song");
        removeSong.addActionListener(this);

        moveSong = new JButton("move");
        moveSong.setBounds(240,50,110,50);
        moveSong.setActionCommand("move song to other folder");
        moveSong.addActionListener(this);

        previousSongPage = new JButton("Previous");
        previousSongPage.setBounds(0, 360, 110, 50);
        previousSongPage.setActionCommand("previous Song page");
        previousSongPage.addActionListener(this);

        nextSongPage = new JButton("Next");
        nextSongPage.setBounds(240, 360, 110, 50);
        nextSongPage.setActionCommand("next Song page");
        nextSongPage.addActionListener(this);

        playSong = new JButton("Play");
        playSong.setBounds(110, 360, 130, 50);
        playSong.setActionCommand("play song");
        playSong.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){}  //override

    public void appearEnterSong(){
        folderNameLabel = new JLabel(folder.name);
        folderNameLabel.setBounds(70, 0, 350, 50);
        folderNameLabel.setFont(new Font("Verdava", Font.PLAIN, 30));

        add(folderNameLabel);
        add(lastOpenFolder);
        add(addSong);
        add(removeSong);
        add(moveSong);
        for(int i = 0; i < 5;i++){
            if(i + appearSongIndex >= songButtonList.size()) break;
            add(songButtonList.get(i + appearSongIndex));
        }

        add(previousSongPage);
        add(nextSongPage);
        add(playSong);

        //ensure num of "songButtonList".size() can go to "nextSongPage" or "previousSongPage"
        previousSongPage.setEnabled(true);
        nextSongPage.setEnabled(true);
        if(appearSongIndex == 0) previousSongPage.setEnabled(false);
        if(songButtonList.size() - appearSongIndex <= 5) nextSongPage.setEnabled(false);
    }

    public void exitEnterSong(){
        remove(folderNameLabel);
        remove(lastOpenFolder);
        remove(addSong);
        remove(removeSong);
        remove(moveSong);
        for(int i = 0; i < 5;i++){
            if(i + appearSongIndex >= songButtonList.size()) break;
            remove(songButtonList.get(i + appearSongIndex));
        }
        remove(previousSongPage);
        remove(nextSongPage);
        remove(playSong);
    }

    public void storeSongNameButton(Song song){
        JButton songNameButton = new JButton(song.name);

        songNameButton.setBounds(0, 110 + songPositiveInder * 50, 350, 50);       
        songPositiveInder++;
        songPositiveInder %= 5;

        songNameButton.setActionCommand(song.name);
        songNameButton.addActionListener(this);
        songButtonList.add(songNameButton);
    }

    public void initialSongList(Folder folder){ 
        this.folder = folder;
        songPositiveInder = 0;
        songButtonList = new ArrayList<>();
        for(Song song : folder.content){
            storeSongNameButton(song);
        }
    }

    public Song findNextOrPreviousSong(String songName,int order){
        for(int i = 0;i < folder.content.size();i++){
            if(songName.equals(folder.content.get(i).name)){
                i += order;
                if(i == -1) i += folder.content.size();
                else if(i == folder.content.size()) i = 0;
                return folder.content.get(i);
            }
        }
        return folder.content.get(order);
    }
}
