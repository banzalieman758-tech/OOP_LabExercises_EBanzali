public class TransportationTester {
    public static void main(String[] args) {
        // Air Vehicles
        Helicopter heli = new Helicopter();
        Airplane plane = new Airplane();
        SpaceShuttle shuttle = new SpaceShuttle();

        heli.showInfo();
        plane.showInfo();
        shuttle.showInfo();

        // Land Vehicles
        Truck truck = new Truck();
        SUV suv = new SUV();
        Tricycle trike = new Tricycle();
        Motorcycle motor = new Motorcycle();
        Kariton cart = new Kariton();

        truck.showInfo();
        suv.showInfo();
        trike.showInfo();
        motor.showInfo();
        cart.showInfo();

        // Water Vehicles
        Boat boat = new Boat();
        Submarine sub = new Submarine();

        boat.showInfo();
        sub.showInfo();
    }
}
