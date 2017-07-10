package birthdayCelebrations;

public class Citizen implements Identifiable, Birthable {
    private String id;
    private String name;
    private int age;
    private String birthdate;

    public Citizen(String id, String name, int age, String birthdate) {
        this.setId(id);
        this.setName(name);
        this.setAge(age);
        this.setBirthdate(birthdate);
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getBirthdate() {
        return this.birthdate;
    }
}
