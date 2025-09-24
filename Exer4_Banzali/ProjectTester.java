import java.util.ArrayList;

public class ProjectTester {
    public static void main(String[] args) {
        ArrayList<CommunityService> services = new ArrayList<>();

        // Add services
        services.add(new HealthService("Medical Mission", "Barangay Hall"));
        services.add(new EducationService("Free Tutorial", "Community Center"));
        services.add(new FoodAid("Food for Families", "Covered Court"));
        services.add(new DisasterRelief("Typhoon Response", "Evacuation Site"));
        services.add(new ShelterService("Temporary Housing", "Municipal Gym"));

        // Test polymorphism
        for (CommunityService service : services) {
            service.deliverService();           
            service.info("Polymorphism Test");  
            System.out.println("---------------------------------");
        }
    }
}
