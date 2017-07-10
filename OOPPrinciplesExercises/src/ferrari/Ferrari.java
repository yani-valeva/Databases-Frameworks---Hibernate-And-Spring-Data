package ferrari;

public class Ferrari implements Car {
    String MODEL = "488-Spider";
    private String driver;

    public Ferrari(String driver) {
        this.driver = driver;
    }

    @Override
    public String getDriver() {
        return this.driver;
    }

    @Override
    public String brakes() {
        return "Brakes!";
    }

    @Override
    public String pushGas() {
        return "Zadu6avam sA!";
    }

    @Override
    public String toString() {
        return String.format("%s/%s/%s/%s", this.MODEL, this.brakes(), this.pushGas(), this.driver);
    }
}
