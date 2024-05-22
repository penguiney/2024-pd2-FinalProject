import javax.swing.*;
import java.awt.*;

public class test {
    public static void main(String[] args) {
        JFrame frame = new JFrame("GridBagLayout Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JButton button1 = new JButton("Button 1");
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1.0; // 按钮 1 的 weightx 设置为 1
        panel.add(button1, c);

        JButton button2 = new JButton("Button 2");
        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 2.0; // 按钮 2 的 weightx 设置为 2，比按钮 1 的 weightx 大
        panel.add(button2, c);

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
        System.out.println("test");
    }
}
