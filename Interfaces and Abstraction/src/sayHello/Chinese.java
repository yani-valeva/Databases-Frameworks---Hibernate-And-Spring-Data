package sayHello;

public class Chinese implements Person {
    private String name;

    public Chinese(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.setName(name);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String sayHello() {
        return "Djydjybydjy";
    }
}
