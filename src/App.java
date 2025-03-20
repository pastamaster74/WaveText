import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class App {
    public static void main(String[] args) throws Exception {
        JFrame mainFrame = new JFrame("DogNotes");
        mainFrame.setLayout(null);
        mainFrame.setBounds(600, 200, 800, 600);
        mainFrame.getContentPane().setBackground(new Color(50, 159, 168));
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setResizable(false);

        JPanel topBar = new JPanel();
        topBar.setBounds(0, 0, 800, 20);
        topBar.setOpaque(true);
        topBar.setBackground(Color.GRAY);

        JTextArea textArea = new JTextArea();
        textArea.setBounds(25, 30, 750, 525);
        textArea.setFont(new Font("sans-serif", Font.PLAIN, 13));
        textArea.setBackground(new Color(40, 149, 168));
        textArea.setForeground(Color.BLACK);
        textArea.setBorder(BorderFactory.createSoftBevelBorder(1, Color.GRAY, Color.gray));
        textArea.setOpaque(true);

        JTextArea rowIndicator = new JTextArea("1");
        rowIndicator.setBounds(7, 33, 25, 600);
        rowIndicator.setFont(new Font("sans-serif", Font.ITALIC, 13));
        rowIndicator.setOpaque(false);
        rowIndicator.setEditable(false);

        JButton fileButton = new JButton("File");
        fileButton.setBounds(0, 0, 100, 20);
        fileButton.setFont(new Font("sans-serif", Font.ITALIC, 15));
        fileButton.setBackground(Color.LIGHT_GRAY);

        JPanel fileOptionPanel = new JPanel();
        fileOptionPanel.setBounds(0, 20, 150, 250);
        fileOptionPanel.setBackground(Color.GRAY);
        fileOptionPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        fileOptionPanel.setVisible(false);
        fileOptionPanel.setLayout(null);

        JButton newFileButton = new JButton("New");
        newFileButton.setBounds(25, 5, 100, 20);
        newFileButton.setFont(new Font("sans-serif", Font.PLAIN, 14));
        newFileButton.setBackground(Color.LIGHT_GRAY);

        JLabel cornerLabel1 = new JLabel();
        cornerLabel1.setBounds(700, 20, 100, 75);
        cornerLabel1.setOpaque(true);
        cornerLabel1.setBackground(Color.WHITE);

        JLabel cornerLabel2 = new JLabel();
        cornerLabel2.setBounds(15, 475, 100, 100);
        cornerLabel2.setOpaque(true);
        cornerLabel2.setBackground(Color.WHITE);

        mainFrame.add(fileButton);
        mainFrame.add(fileOptionPanel);
        mainFrame.add(topBar);
        mainFrame.add(textArea);
        mainFrame.add(rowIndicator);
        mainFrame.add(cornerLabel1);
        mainFrame.add(cornerLabel2);
        mainFrame.repaint();

        fileOptionPanel.add(newFileButton);
        fileOptionPanel.repaint();

        fileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!fileOptionPanel.isVisible()) {
                    fileOptionPanel.setVisible(true);
                } else {
                    fileOptionPanel.setVisible(false);
                }
            }
        });

        newFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
                mainFrame.repaint();
                fileOptionPanel.repaint();
                fileOptionPanel.setVisible(false);
            }
        });

        while (true) {
            rowIndicator.setText("");
            for (int i = 1; i < textArea.getLineCount() + 1; i++) {
                rowIndicator.setText(rowIndicator.getText() + Integer.toString(i) + "\n");
            }
            Thread.sleep(textArea.getLineCount() * 10);
        }
    }
}
