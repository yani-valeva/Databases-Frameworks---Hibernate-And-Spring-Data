package defineBankAccount;

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        account.id = 1;
        account.balance = 15;

        System.out.printf("Account ID%d, balance %.2f", account.id, account.balance);
    }
}
