public class Individual extends Beneficiary {
    private int age;

    public Individual(String projectName, String location, String name, String aidType, int age) {
        super(projectName, location, name, aidType);
        this.age = age;
    }

    @Override
    public void info() {
        super.info();
        System.out.println("Age: " + age);
    }
}
