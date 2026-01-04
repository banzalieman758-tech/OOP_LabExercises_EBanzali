public class Helicopter extends AirTransport {
    public Helicopter() {
        name = "Helicopter";
        maxSpeed = 250;
    }

    public void showInfo() {
        System.out.println("Air Vehicle: " + name + ", Top speed: " + maxSpeed);
    }
}
