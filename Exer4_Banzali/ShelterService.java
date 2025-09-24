public class ShelterService extends CommunityService {
    public ShelterService(String serviceName, String location) {
        super(serviceName, location);
    }

    @Override
    public void deliverService() {
        System.out.println(serviceName + " is offering temporary shelter at " + location);
    }
}
