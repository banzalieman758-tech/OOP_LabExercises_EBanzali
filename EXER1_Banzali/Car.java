public class Car {
    private String color;
    private String regNumber;
    private String engineCode;

    // no-argument constructor
    public Car() {
        this.color = "Not Assigned";
        this.regNumber = "No Registration Yet";
        this.engineCode = "No Engine Code";
    }
    public Car(String color, String regNumber, String engineCode) {
        this.color = color;
        this.regNumber = regNumber;
        this.engineCode = engineCode;
    }

    //-----------method-----------------------------------------------
    public void displayInfo() {
        System.out.println("=== Car Information ===");
        System.out.println("Color       : " + color);
        System.out.println("Reg Number  : " + regNumber);
        System.out.println("Engine Code : " + engineCode);
        System.out.println("========================");
    }
}