package animals;

public class Cat extends AnimalImpl {
    public Cat(String name, Integer age, String gender) {
        super(name, age, gender);
    }

    @Override
    public String produceSound() {
        return "MiauMiau";
    }

    @Override
    public String toString() {
        return String.format("Cat%n%s %d %s", this.getName(), this.getAge(), this.getGender());
    }
}
