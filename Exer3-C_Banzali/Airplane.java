public class Airplane extends AirTransport {
    public Airplane() {
        name = "Airplane";
        maxSpeed = 800;
    }

    public void showInfo() {
        System.out.println("Air Vehicle: " + name + ", Top speed: " + maxSpeed);
    }
}
