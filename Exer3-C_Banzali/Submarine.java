public class Submarine extends WaterTransport {
    public Submarine() {
        name = "Submarine";
        maxSpeed = 30;
    }

    public void showInfo() {
        System.out.println("Water Vehicle: " + name + ", Top speed: " + maxSpeed);
    }
}
