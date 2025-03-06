import java.awt.Color;
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
        topBar.setBounds(0, 0, 800, 15);
        topBar.setOpaque(false);
        topBar.setBackground(Color.GRAY);

        JTextArea textArea = new JTextArea();
        textArea.setBounds(45, 25, 700, 250);
        textArea.setForeground(Color.WHITE);
        textArea.setOpaque(true);
        textArea.setBorder(null);

        mainFrame.add(topBar);
        mainFrame.add(textArea);
        mainFrame.repaint();
    }
}
