package Cars;
import javax.swing.*;

import Login.LoginGUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import Rentals.*;
import States.UserContext;


public class CarRentalGUI extends JFrame {
    private JButton carRentalButton;
    private String username;

        public CarRentalGUI() {
        super("Car Rental - Welcome, "); // Accessing username from UserContext
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocation(400, 200);
        setSize(800, 400);

        this.username = username;

        // Components for car rental frame
        List<RentalModel> availableCars = RentalController.loadCarsFromCsv();
        DefaultListModel<String> carListModel = new DefaultListModel<>();
        JList<String> carList = new JList<>(carListModel);
        JButton rentButton = new JButton("Rent Selected Car");

        // Populate the car list with details (name, price, availability)
        for (RentalModel car : availableCars) {
            carListModel.addElement(car.getCarName() + " - Price per day: $" + car.getPricePerDay() + " Availability: " + car.getAvailability());
        }

        // Layout for car rental frame
        setLayout(new BorderLayout());
        add(new JScrollPane(carList), BorderLayout.CENTER);
        add(rentButton, BorderLayout.SOUTH);

        // Event handling for renting button
        carRentalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedCarString = carList.getSelectedValue();

                if (selectedCarString != null) {
                    String[] selectedCarParts = selectedCarString.split(" - ");
                    String selectedCarName = selectedCarParts[0];

                    String daysInput = JOptionPane.showInputDialog(CarRentalGUI.this, "Enter number of days to rent:");

                    try {
                        int rentalDays = Integer.parseInt(daysInput);
                        List<RentalModel> updatedCars = RentalController.loadCarsFromCsv();
                        RentalModel selectedCarObject = RentalController.findCarByName(updatedCars, selectedCarName);

                        if (selectedCarObject != null) {
                            double totalCost = RentalController.calculateRentalCost(
                                    selectedCarObject, rentalDays, username);

                            // Decrease availability
                            // selectedCarObject.decreaseAvailability();
                            selectedCarObject.changeAvailability(false);

                            // Save cars to CSV
                            RentalView.saveCarsToCsv(updatedCars);

                            // Display updated availability in GUI
                            RentalView.displayUpdatedAvailability(selectedCarObject);

                            // Display rental summary in GUI
                            String summary = "Car '" + selectedCarName + "' rented for " + rentalDays + " days.\n";
                            summary += "Total Cost: $" + totalCost;
                            JOptionPane.showMessageDialog(CarRentalGUI.this, summary);
                        } else {
                            JOptionPane.showMessageDialog(CarRentalGUI.this, "Invalid selection. Please try again.");
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(CarRentalGUI.this, "Invalid input. Please enter a valid number of days.");
                    }
                } else {
                    JOptionPane.showMessageDialog(CarRentalGUI.this, "Please select a car to rent.");
                }
            }
        });
    }
}
