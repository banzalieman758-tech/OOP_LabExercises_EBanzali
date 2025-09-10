public class CarTester {
    public static void main(String[] args) {
        Car car1 = new Car("Blue", "REG-5566", "ENG-2025");

        Car car2 = new Car();

        car1.displayInfo();
        car2.displayInfo();
    }
}