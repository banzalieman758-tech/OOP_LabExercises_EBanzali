public class CommunityAid {
    protected String projectName;
    protected String location;

    public CommunityAid(String projectName, String location) {
        this.projectName = projectName;
        this.location = location;
    }

    public void info() {
        System.out.println("Project: " + projectName + " | Location: " + location);
    }
}
