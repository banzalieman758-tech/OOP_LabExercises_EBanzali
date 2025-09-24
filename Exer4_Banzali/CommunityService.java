public class CommunityService {
    protected String serviceName;
    protected String location;

    public CommunityService(String serviceName, String location) {
        this.serviceName = serviceName;
        this.location = location;
    }

    // overridden by subclasses
    public void deliverService() {
        System.out.println(serviceName + " is being delivered at " + location);
    }

    // Overloaded methods 
    public void info() {
        System.out.println("Service: " + serviceName + " | Location: " + location);
    }

    public void info(String extra) {
        System.out.println("Service: " + serviceName + " | Location: " + location + " | " + extra);
    }
}
