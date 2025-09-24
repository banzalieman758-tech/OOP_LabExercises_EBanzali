public class DisasterRelief extends CommunityService {
    public DisasterRelief(String serviceName, String location) {
        super(serviceName, location);
    }

    @Override
    public void deliverService() {
        System.out.println(serviceName + " is providing emergency support at " + location);
    }
}
