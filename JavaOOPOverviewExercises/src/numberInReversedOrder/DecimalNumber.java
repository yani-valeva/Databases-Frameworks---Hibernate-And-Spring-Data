package numberInReversedOrder;

public class DecimalNumber {
    private String number;

    public DecimalNumber(String number) {
        this.number = number;
    }

    public String reverseNumber() {
        StringBuilder sb = new StringBuilder(number);
        return sb.reverse().toString();
    }
}
