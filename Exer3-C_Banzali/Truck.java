public class Truck extends LandTransport {
    public Truck() {
        name = "Truck";
        maxSpeed = 80;
    }

    public void showInfo() {
        System.out.println("Land Vehicle: " + name + ", Top speed: " + maxSpeed);
    }
}
