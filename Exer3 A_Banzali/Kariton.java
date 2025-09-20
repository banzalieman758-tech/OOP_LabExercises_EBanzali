public class Kariton extends LandTransport {
    public Kariton() {
        name = "Kariton";
        maxSpeed = 25;
    }

    public void showInfo() {
        System.out.println("Land Vehicle: " + name + ", Top speed: " + maxSpeed);
    }
}
