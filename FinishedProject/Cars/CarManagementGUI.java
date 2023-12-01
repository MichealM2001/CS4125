package Cars;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CarManagementGUI {
    private static final String fileName = "AddCar.csv";

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Car Management System");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);
            frame.setLayout(new BorderLayout());

            JTextArea textArea = new JTextArea();
            textArea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(textArea);

            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new GridLayout(1, 3));

            JButton addButton = new JButton("Add Car");
            addButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    addCar();
                    updateTextArea(textArea);
                }
            });

            JButton removeButton = new JButton("Remove Car");
            removeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    removeCar();
                    updateTextArea(textArea);
                }
            });

            JButton exitButton = new JButton("Exit");
            exitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });

            buttonPanel.add(addButton);
            buttonPanel.add(removeButton);
            buttonPanel.add(exitButton);

            frame.add(scrollPane, BorderLayout.CENTER);
            frame.add(buttonPanel, BorderLayout.SOUTH);

            frame.setVisible(true);
        });
    }

    private static void addCar() {
        try (FileWriter fw = new FileWriter(fileName, true)) {
            int yearOfReg = Integer.parseInt(JOptionPane.showInputDialog("Enter year of registration:"));
            String model = JOptionPane.showInputDialog("Enter model of car:");
            int price = Integer.parseInt(JOptionPane.showInputDialog("Enter price of car:"));
            String isRented = JOptionPane.showInputDialog("Is car rented? (yes or no):").toLowerCase();
            String classification = JOptionPane.showInputDialog("Enter classification of car:");

            fw.write(yearOfReg + "," + model + "," + price + "," + isRented + "," + classification + "\n");
            JOptionPane.showMessageDialog(null, "Car details added to the CSV.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error creating/writing to the file.");
            e.printStackTrace();
        }
    }

    private static void removeCar() {
        try {
            File inputFile = new File(fileName);
            File tempFile = new File("temp.csv");

            if (!inputFile.exists()) {
                JOptionPane.showMessageDialog(null, "File not found.");
                return;
            }

            String carModelToRemove = JOptionPane.showInputDialog("Enter the model of the car to remove:");

            Scanner fileScanner = new Scanner(inputFile);
            FileWriter fw = new FileWriter(tempFile, true);

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(",");

                if (parts.length >= 2 && !parts[1].equalsIgnoreCase(carModelToRemove)) {
                    fw.write(line + "\n");
                }
            }

            fileScanner.close();
            fw.close();

            if (inputFile.delete() && tempFile.renameTo(inputFile)) {
                JOptionPane.showMessageDialog(null, "Car removed from the CSV.");
            } else {
                JOptionPane.showMessageDialog(null, "Failed to remove car.");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error reading/writing to the file.");
            e.printStackTrace();
        }
    }

    private static void updateTextArea(JTextArea textArea) {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            StringBuilder sb = new StringBuilder();
            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine()).append("\n");
            }
            textArea.setText(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
