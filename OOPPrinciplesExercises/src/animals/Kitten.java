package animals;

public class Kitten extends Cat{

    public Kitten(String name, Integer age, String gender) {
        super(name, age, gender);
    }

    @Override
    public String produceSound() {
        return "Miau";
    }

    @Override
    public String toString() {
        return String.format("Kitten%n%s %d Female", this.getName(), this.getAge());
    }
}
