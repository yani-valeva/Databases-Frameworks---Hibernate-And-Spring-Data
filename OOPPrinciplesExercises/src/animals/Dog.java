package animals;

public class Dog extends AnimalImpl {
    public Dog(String name, Integer age, String gender) {
        super(name, age, gender);
    }

    @Override
    public String produceSound() {
        return "BauBau";
    }

    @Override
    public String toString() {
        return String.format("Dog%n%s %d %s", this.getName(), this.getAge(), this.getGender());
    }
}
