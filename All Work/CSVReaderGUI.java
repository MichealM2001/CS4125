import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReaderGUI {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("CSV Reader");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);
            frame.setLayout(new BorderLayout());

            JTextArea textArea = new JTextArea();
            textArea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(textArea);

            JButton readButton = new JButton("Read CSV");
            readButton.addActionListener(e -> {
                String fileName = "AddCar.csv";
                readCSVFile(fileName, textArea);
            });

            frame.add(scrollPane, BorderLayout.CENTER);
            frame.add(readButton, BorderLayout.SOUTH);

            frame.setVisible(true);
        });
    }

    private static void readCSVFile(String filename, JTextArea textArea) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            StringBuilder sb = new StringBuilder();
            String line;

            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }

            textArea.setText(sb.toString());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error reading from the file.");
            e.printStackTrace();
        }
    }
}
