import java.awt.Color;
import java.awt.Font;
import javax.swing.*;

public class App {
    public static void main(String[] args) throws Exception {
        JFrame mainFrame = new JFrame("DogNotes");
        mainFrame.setLayout(null);
        mainFrame.setBounds(600, 200, 800, 600);
        mainFrame.getContentPane().setBackground(new Color(50, 159, 168));
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel topBar = new JLabel();
        topBar.setBounds(0, 0, 800, 20);
        topBar.setOpaque(true);
        topBar.setBackground(Color.GRAY);

        JTextArea textArea = new JTextArea();
        textArea.setBounds(25, 30, 750, 525);
        textArea.setFont(new Font("sans-serif", Font.PLAIN, 13));
        textArea.setBackground(new Color(40, 149, 168));
        textArea.setForeground(Color.WHITE);
        textArea.setBorder(BorderFactory.createSoftBevelBorder(1, Color.GRAY, Color.gray));
        textArea.setOpaque(true);

        JLabel cornerLabel1 = new JLabel();
        cornerLabel1.setBounds(700, 20, 100, 75);
        cornerLabel1.setOpaque(true);
        cornerLabel1.setBackground(Color.WHITE);

        JLabel cornerLabel2 = new JLabel();
        cornerLabel2.setBounds(15, 475, 100, 100);
        cornerLabel2.setOpaque(true);
        cornerLabel2.setBackground(Color.WHITE);

        mainFrame.add(topBar);
        mainFrame.add(textArea);
        mainFrame.add(cornerLabel1);
        mainFrame.add(cornerLabel2);
        mainFrame.repaint();
    }
}
