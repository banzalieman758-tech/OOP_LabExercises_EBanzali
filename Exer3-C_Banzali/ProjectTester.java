public class ProjectTester {
    public static void main(String[] args) {
        // Donors
        Donor donor1 = new Donor("CommunityAidHub", "Barangay 5", "Juan Dela Cruz", "09171234567", 5000);
        Donor donor2 = new Donor("CommunityAidHub", "Barangay 5", "Maria Santos", "09179876543", 3000);

        // Beneficiaries
        Individual ind1 = new Individual("CommunityAidHub", "Barangay 5", "Pedro", "Food Pack", 35);
        Organization org1 = new Organization("CommunityAidHub", "Barangay 5", "Youth Club", "Medical Aid", 25);

        // Assistance
        Assistance aid1 = new Assistance("CommunityAidHub", "Barangay 5", "Food Pack", 50);
        Assistance aid2 = new Assistance("CommunityAidHub", "Barangay 5", "Medical Kit", 30);

        // Display Info
        System.out.println("=== Donors ===");
        donor1.info();
        donor1.thankDonor();
        donor2.info();
        donor2.thankDonor();

        System.out.println("\n=== Beneficiaries ===");
        ind1.info();
        org1.info();

        System.out.println("\n=== Assistance Provided ===");
        aid1.info();
        aid2.info();
    }
}
