public class HealthService extends CommunityService {
    public HealthService(String serviceName, String location) {
        super(serviceName, location);
    }

    @Override
    public void deliverService() {
        System.out.println(serviceName + " is providing medical assistance at " + location);
    }
}
