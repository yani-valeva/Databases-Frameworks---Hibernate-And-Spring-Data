package borderControl;

public class Citizen implements Identifiable{
    private String id;
    private String name;
    private int age;

    public Citizen(String id, String name, int age) {
        this.setId(id);
        this.setName(name);
        this.setAge(age);
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

    @Override
    public String getId() {
        return this.id;
    }
}
