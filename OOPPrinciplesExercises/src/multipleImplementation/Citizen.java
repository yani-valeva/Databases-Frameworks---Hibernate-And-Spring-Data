package multipleImplementation;

public class Citizen implements Person, Identifiable, Birthable {
    private String name;
    private Integer age;
    private String id;
    private String birthdate;

    public Citizen(String name, Integer age, String id, String birthdate) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.birthdate = birthdate;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Integer getAge() {
        return this.age;
    }

    public String getId() {
        return this.id;
    }

    public String getBirthdate() {
        return this.birthdate;
    }
}
