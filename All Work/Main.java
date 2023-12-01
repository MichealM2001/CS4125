public class Main {
    public static void main(String[] args) {
        String fileName = "AddCar.csv"; // Define the name of the CSV file
        CarView view = new CarView();
        CarController controller = new CarController(view, fileName);

        controller.run();
    }
}
