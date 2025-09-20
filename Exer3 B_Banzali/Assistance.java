public class Assistance extends CommunityAid {
    private String type;
    private int quantity;

    public Assistance(String projectName, String location, String type, int quantity) {
        super(projectName, location);
        this.type = type;
        this.quantity = quantity;
    }

    public void info() {
        super.info();
        System.out.println("Assistance Type: " + type + " | Quantity: " + quantity);
    }
}
