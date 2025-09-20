public class Boat extends WaterTransport {
    public Boat() {
        name = "Boat";
        maxSpeed = 40;
    }

    public void showInfo() {
        System.out.println("Water Vehicle: " + name + ", Top speed: " + maxSpeed);
    }
}
