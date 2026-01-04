public class Tricycle extends LandTransport {
    public Tricycle() {
        name = "Tricycle";
        maxSpeed = 60;
    }

    public void showInfo() {
        System.out.println("Land Vehicle: " + name + ", Top speed: " + maxSpeed);
    }
}
