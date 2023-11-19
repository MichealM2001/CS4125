import javax.swing.*;
import java.awt.*;
import java.io.*;

public class EditCSVGUI {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("CSV Editor");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);
            frame.setLayout(new BorderLayout());

            JTextArea textArea = new JTextArea();
            textArea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(textArea);

            JButton editButton = new JButton("Edit CSV");
            editButton.addActionListener(e -> {
                String fileName = "AddCar.csv";
                editCSVFile(fileName, textArea);
            });

            frame.add(scrollPane, BorderLayout.CENTER);
            frame.add(editButton, BorderLayout.SOUTH);

            frame.setVisible(true);
        });
    }

    private static void editCSVFile(String fileName, JTextArea textArea) {
        try {
            // Read the entire CSV file into memory
            File file = new File(fileName);
            BufferedReader br = new BufferedReader(new FileReader(file));
            StringBuilder csvData = new StringBuilder();
            String line;

            while ((line = br.readLine()) != null) {
                csvData.append(line).append("\n");
            }

            String userInput = JOptionPane.showInputDialog("Which line would you like to edit? (Enter line number or cancel to exit)");

            if (userInput == null || userInput.trim().isEmpty()) {
                return; // User canceled or entered an empty string
            }

            int lineToEdit;
            try {
                lineToEdit = Integer.parseInt(userInput);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid line number.");
                return;
            }

            if (lineToEdit > 0 && lineToEdit <= csvData.toString().split("\n").length) {
                int newYearOfReg;
                String newModel;
                int newPrice;
                String newIsRented;
                String newClassification;

                newYearOfReg = Integer.parseInt(JOptionPane.showInputDialog("Enter year of registration:"));
                newModel = JOptionPane.showInputDialog("Enter model of car:");
                newPrice = Integer.parseInt(JOptionPane.showInputDialog("Enter price of car:"));
                newIsRented = JOptionPane.showInputDialog("Is car rented? (yes or no):").toLowerCase();
                newClassification = JOptionPane.showInputDialog("Enter classification of car:");

                String newLine = newYearOfReg + "," + newModel + "," + newPrice + "," + newIsRented + "," + newClassification;

                String[] lines = csvData.toString().split("\n");
                lines[lineToEdit - 1] = newLine;

                String updatedCsvData = String.join("\n", lines);

                BufferedWriter bw = new BufferedWriter(new FileWriter(file));
                bw.write(updatedCsvData);
                bw.close();

                textArea.setText(updatedCsvData);
                JOptionPane.showMessageDialog(null, "Line edited successfully.");
            } else {
                JOptionPane.showMessageDialog(null, "Invalid line number. No changes made.");
            }

        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error opening the file.");
            e.printStackTrace();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error editing the file.");
            e.printStackTrace();
        }
    }
}
