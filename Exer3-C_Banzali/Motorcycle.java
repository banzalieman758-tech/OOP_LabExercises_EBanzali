public class Motorcycle extends LandTransport {
    public Motorcycle() {
        name = "Motorcycle";
        maxSpeed = 90;
    }

    public void showInfo() {
        System.out.println("Land Vehicle: " + name + ", Top speed: " + maxSpeed);
    }
}
