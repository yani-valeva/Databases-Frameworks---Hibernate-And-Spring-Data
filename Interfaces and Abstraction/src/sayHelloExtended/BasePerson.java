package sayHelloExtended;

public abstract class BasePerson implements Person {
    private String name;

    protected BasePerson(String name) {
        this.setName(name);
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
