package birthdayCelebrations;

public class Pet implements Birthable {
    private String name;
    private String birthdate;

    public Pet(String name, String birthdate) {
        this.setName(name);
        this.setBirthdate(birthdate);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public String getBirthdate() {
        return this.birthdate;
    }
}
