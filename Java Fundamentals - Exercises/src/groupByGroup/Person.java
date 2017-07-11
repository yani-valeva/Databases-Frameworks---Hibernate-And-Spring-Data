package groupByGroup;

public class Person {
    private String name;
    private Integer group;

    public Person(String name, Integer group) {
        this.setName(name);
        this.setGroup(group);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGroup() {
        return this.group;
    }

    public void setGroup(Integer group) {
        this.group = group;
    }
}
