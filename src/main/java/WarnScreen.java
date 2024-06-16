import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class WarnScreen extends InputSongName implements ActionListener{
    private JFrame warnScreen = new JFrame("Warn");
    private JButton ensureWarn = new JButton("confirm");
    private JLabel warnWord = new JLabel("No Folder Selected");
    
    WarnScreen(){
        warnScreen.setLayout(null);
        warnScreen.setSize(350,250);

        warnWord.setFont(new Font("Verdana",Font.PLAIN,25));
        warnWord.setBounds(40, 30, 350, 100);

        ensureWarn.setBounds(110,150,100,50);
        ensureWarn.setActionCommand("ensure warn to OpenFolder");
        ensureWarn.addActionListener(this);
        warnScreen.add(warnWord);
        warnScreen.add(ensureWarn);
    }

    public void appearWarnScreen(String condition){
        warnScreen.remove(warnWord);
        warnWord = new JLabel(condition);
        warnWord.setFont(new Font("Verdana",Font.PLAIN,25));
        warnWord.setBounds(40, 30, 350, 100);
        warnScreen.add(warnWord);
        ensureWarn.setActionCommand("ensure warn");
        warnScreen.setVisible(true);
    }

    public void exitWarnScreen(){
        warnScreen.setVisible(false);
    }

    public void actionPerformed(ActionEvent e){} //override
}
