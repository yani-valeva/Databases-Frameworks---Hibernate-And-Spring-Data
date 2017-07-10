package telephony;

public class Smartphone implements Calling, Browsing{
    private String model;

    public Smartphone(String model) {
        this.setModel(model);
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String getCalling(String number) {
        for (int i = 0; i < number.length(); i++) {
            if (Character.isLetter(number.charAt(i))) {
                throw new IllegalArgumentException("Invalid number!");
            }
        }
        return "Calling... " + number;
    }

    @Override
    public String getBrowsing(String url) {
        for (int i = 0; i < url.length(); i++) {
            if (Character.isDigit(url.charAt(i))) {
                throw new IllegalArgumentException("Invalid URL!");
            }
        }

        return "Browsing: " + url + "!";
    }
}
