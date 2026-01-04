public class SUV extends LandTransport {
    public SUV() {
        name = "SUV";
        maxSpeed = 120;
    }

    public void showInfo() {
        System.out.println("Land Vehicle: " + name + ", Top speed: " + maxSpeed);
    }
}
