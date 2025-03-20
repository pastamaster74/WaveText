import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
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
        newFileButton.setBounds(5, 5, 140, 20);
        newFileButton.setFont(new Font("sans-serif", Font.PLAIN, 14));
        newFileButton.setBackground(Color.LIGHT_GRAY);

        JButton saveFileButton = new JButton("Save");
        saveFileButton.setBounds(5, 30, 140, 20);
        saveFileButton.setFont(new Font("sans-serif", Font.PLAIN, 14));
        saveFileButton.setBackground(Color.LIGHT_GRAY);

        JButton saveFileAsButton = new JButton("Save as");
        saveFileAsButton.setBounds(5, 55, 140, 20);
        saveFileAsButton.setFont(new Font("sans-serif", Font.PLAIN, 14));
        saveFileAsButton.setBackground(Color.LIGHT_GRAY);

        JTextField nameField = new JTextField();
        nameField.setBounds(15, 75, 120, 20);
        nameField.setFont(new Font("sans-serif", Font.ITALIC, 14));
        nameField.setBackground(Color.LIGHT_GRAY);

        JButton openFileButton = new JButton("Open");
        openFileButton.setBounds(5, 100, 140, 20);
        openFileButton.setFont(new Font("sans-serif", Font.PLAIN, 14));
        openFileButton.setBackground(Color.LIGHT_GRAY);

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
        fileOptionPanel.add(saveFileButton);
        fileOptionPanel.add(saveFileAsButton);
        fileOptionPanel.add(nameField);
        fileOptionPanel.add(openFileButton);
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

        saveFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String filePath = "no file";
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                fileChooser.setCurrentDirectory(new File("desktop"));
                int result = fileChooser.showSaveDialog(fileChooser);
        
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    filePath = selectedFile.getAbsolutePath();
                    
                }

                if (!filePath.equals("no file")) {
                    File file = new File(filePath);
                    try {
                        FileWriter fileWriter = new FileWriter(file);
                        fileWriter.write("");
                        fileWriter.write(textArea.getText());
                        fileWriter.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    
                    
                }
            }
        });

        saveFileAsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String filePath = "no file";
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                fileChooser.setCurrentDirectory(new File("desktop"));
                int result = fileChooser.showSaveDialog(fileChooser);
        
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    filePath = selectedFile.getAbsolutePath();
                }

                if (!filePath.equals("no file")) {
                    File newFile = new File(filePath + "\\" + nameField.getText().strip() + ".txt");
                    try {
                        newFile.createNewFile();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    try {
                        FileWriter fileWriter = new FileWriter(newFile);
                        fileWriter.write(textArea.getText());
                        fileWriter.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });

        openFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String filePath = "no file";
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                fileChooser.setCurrentDirectory(new File("desktop"));
                int result = fileChooser.showOpenDialog(fileChooser);
        
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    filePath = selectedFile.getAbsolutePath();
                }

                if (!filePath.equals("no file")) {
                    File file = new File(filePath);
                    textArea.setText("");
                    try {
                        Scanner fileScanner = new Scanner(file);
                        while (fileScanner.hasNextLine()) {
                            textArea.setText(textArea.getText() + fileScanner.nextLine() + "\n");
                        }
                        fileScanner.close();
                    } catch (FileNotFoundException exception) {
                        exception.printStackTrace();
                    }
                    fileOptionPanel.setVisible(false);
                    mainFrame.repaint();
                }
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
