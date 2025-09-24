public class EducationService extends CommunityService {
    public EducationService(String serviceName, String location) {
        super(serviceName, location);
    }

    @Override
    public void deliverService() {
        System.out.println(serviceName + " is conducting free classes at " + location);
    }
}
