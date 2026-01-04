public class Donor extends CommunityAid {
    private String donorName;
    private String contact;
    private double donatedAmount;

    public Donor(String projectName, String location, String donorName, String contact, double donatedAmount) {
        super(projectName, location);
        this.donorName = donorName;
        this.contact = contact;
        this.donatedAmount = donatedAmount;
    }

    public void info() {
        super.info();
        System.out.println("Donor: " + donorName + " | Contact: " + contact + " | Donated: $" + donatedAmount);
    }

    public void thankDonor() {
        System.out.println("Thank you " + donorName + " for your donation!");
    }
}
