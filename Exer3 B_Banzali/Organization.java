public class Organization extends Beneficiary {
    private int memberCount;

    public Organization(String projectName, String location, String name, String aidType, int memberCount) {
        super(projectName, location, name, aidType);
        this.memberCount = memberCount;
    }

    @Override
    public void info() {
        super.info();
        System.out.println("Number of Members: " + memberCount);
    }
}
