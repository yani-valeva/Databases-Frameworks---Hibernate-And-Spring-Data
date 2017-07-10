package animals;

public class Tomcat extends Cat {
    public Tomcat(String name, Integer age, String gender) {
        super(name, age, gender);
    }

    @Override
    public String produceSound() {
        return "Give me one million b***h";
    }

    @Override
    public String toString() {
        return String.format("Tomcat%n%s %d Male", this.getName(), this.getAge());
    }
}
