public class CarTester {
    public static void main(String[] args) {
        Car car1 = new Car();
        car1.displayInfo();

       
        Car car2 = new Car("Mazda", "Blue", "ABC 1234", "CH-10001");
        car2.displayInfo();

        Car car3 = new Car("Toyota", "Red", "DEF 5678", "CH-10002");
        car3.displayInfo();

        Car car4 = new Car("Kia", "Black", "GHI 9012", "CH-10003");
        car4.displayInfo();

        Car car5 = new Car("Hyundai", "White", "JKL 3456", "CH-10004");
        car5.displayInfo();

        Car car6 = new Car("Subaru", "Silver", "MNO 7890", "CH-10005");
        car6.displayInfo();

        Car car7 = new Car("Peugeot", "Green", "PQR 2468", "CH-10006");
        car7.displayInfo();

        Car car8 = new Car("Nissan", "Yellow", "STU 1357", "CH-10007");
        car8.displayInfo();

        Car car9 = new Car("Honda", "Gray", "VWX 8642", "CH-10008");
        car9.displayInfo();

        Car car10 = new Car("Ferrari", "Orange", "YZA 1122", "CH-10009");
        car10.displayInfo();
    }
}
