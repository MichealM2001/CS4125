import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CarController {
    private CarView view;
    private File file;

    public CarController(CarView view, String fileName) {
        this.view = view;
        file = new File(fileName);
    }

    public void run() {
        while (true) {
            int choice = view.getUserChoice();
            if (choice == 1) {
                addCar();
            } else if (choice == 2) {
                removeCar();
            } else if (choice == 3) {
                break;
            } else {
                view.displayMessage("Invalid choice. Please try again.");
            }
        }
    }

    private void addCar() {
        Car car = view.getCarDetails();
        writeCarToCSVFile(car);
        view.displayMessage("Car details added to the CSV.");
    }

    private void removeCar() {
        String carModelToRemove = view.getCarModelToRemove();
        removeCarFromCSV(carModelToRemove);
    }

    private void writeCarToCSVFile(Car car) {
        try (FileWriter fw = new FileWriter(file, true)) {
            fw.write(
                car.getYearOfReg() + ","
                + car.getModel() + ","
                + car.getPrice() + ","
                + car.getClassification() + "\n"
            );
        } catch (IOException e) {
            view.displayMessage("Error creating/writing to the file.");
            e.printStackTrace();
        }
    }

    private void removeCarFromCSV(String carModelToRemove) {
        // Implement the code to remove a car here, similar to the original code
        // Use the view to display appropriate messages
    }
}
