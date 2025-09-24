public class FoodAid extends CommunityService {
    public FoodAid(String serviceName, String location) {
        super(serviceName, location);
    }

    @Override
    public void deliverService() {
        System.out.println(serviceName + " is distributing food packs at " + location);
    }
}
