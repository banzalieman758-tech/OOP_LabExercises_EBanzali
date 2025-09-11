public class Car {
    private String brand;
    private String color;
    private String plateNo;
    private String chassisNo;

    // Default constructor
    public Car() {
        this.brand = "Generic Car";
        this.color = "Unknown";
        this.plateNo = "No Plate";
        this.chassisNo = "No Chassis";
    }

    public Car(String brand, String color, String plateNo, String chassisNo) {
        this.brand = brand;
        this.color = color;
        this.plateNo = plateNo;
        this.chassisNo = chassisNo;
    }

    // Method to display information
    public void displayInfo() {
        System.out.println("Car Details");
        System.out.println("Brand       : " + brand);
        System.out.println("Color       : " + color);
        System.out.println("Plate No    : " + plateNo);
        System.out.println("Chassis No  : " + chassisNo);
        System.out.println("-----------------------");
    }
}
