package animals;

public class Frog extends AnimalImpl {
    public Frog(String name, Integer age, String gender) {
        super(name, age, gender);
    }

    @Override
    public String produceSound() {
        return "Frogggg";
    }

    @Override
    public String toString() {
        return String.format("Frog%n%s %d %s", this.getName(), this.getAge(), this.getGender());
    }
}
