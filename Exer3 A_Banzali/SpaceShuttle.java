public class SpaceShuttle extends AirTransport {
    public SpaceShuttle() {
        name = "Space Shuttle";
        maxSpeed = 28000;
    }

    public void showInfo() {
        System.out.println("Air Vehicle: " + name + ", Top speed: " + maxSpeed);
    }
}
