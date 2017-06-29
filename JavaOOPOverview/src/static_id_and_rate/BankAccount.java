package static_id_and_rate;

public class BankAccount {
    private final static double DEFAULT_INTEREST = 0.02;
    private  static double rate = DEFAULT_INTEREST;
    private static int bankAccountCount;
    private int id;
    private double balance;

    public BankAccount() {
        this.id = ++ bankAccountCount;
    }

    public int getId() {
        return this.id;
    }

    public static void setInterest(double interest) {
        if (interest < 0) {
            throw new IllegalArgumentException("Interest couldn't be negative!");
        }

        rate = interest;
    }

    public double getInterest(int years) {
        if (years < 0) {
            throw new IllegalArgumentException("Years couldn't be negative!");
        }

        return balance * rate * years;
    }

    public void deposit(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount couldn't be negative!");
        }

        this.balance += amount;
    }

    @Override
    public String toString() {
        return "ID" + this.id;
    }
}
