import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class WaitingMessege extends JFrame{

    JLabel label1;
    JLabel label2;

    WaitingMessege() {
        this.setTitle("Please wait...");
        
        setSize(300, 200);
        label1 = new JLabel("Starting getting Song ...");
        label1.setHorizontalAlignment(0);
        label1.setVerticalAlignment(JLabel.TOP);

        label2 = new JLabel();  

        this.add(label1);
        this.setVisible(true);
    }

    public void messege (int ii) {
        switch (ii) {
            case 1:
                label1.setText("Getting Song ...(1/5)");
                break;
            case 2:
                label1.setText("Getting Song ...(2/5)");
                break;
            case 3:
                label1.setText("Getting Song ...(3/5)");
                break;
            case 4:
                label1.setText("Getting Song ...(4/5)");
                break;
            case 5:
                label1.setText("Getting Song successully");
                break;
            case 6:
                label1.setText("Mp3 already exist!");
                break;    
            default:
                break;
        }
    }
    public void messege2 (String name) {
        label2.setText("Current Downloading: \n" + name);
        add(label2);
        repaint();
    }
}
