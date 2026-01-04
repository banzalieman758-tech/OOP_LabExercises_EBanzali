public class Beneficiary extends CommunityAid {
    protected String name;
    protected String aidType;

    public Beneficiary(String projectName, String location, String name, String aidType) {
        super(projectName, location);
        this.name = name;
        this.aidType = aidType;
    }

    public void info() {
        super.info();
        System.out.println("Beneficiary: " + name + " | Aid: " + aidType);
    }
}
