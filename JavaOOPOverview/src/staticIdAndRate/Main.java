package staticIdAndRate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.HashMap;

public class Main {
    static DecimalFormat df = new DecimalFormat("#.##");
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String commandInfo = reader.readLine();
        HashMap<Integer, BankAccount> accounts = new HashMap<>();

        while (!commandInfo.equals("End")) {
            String[] commandArgs = commandInfo.split("\\s+");
            String command = commandArgs[0];

            switch (command) {
                case "Create":
                    executeCreate(accounts);
                    break;
                case "Deposit":
                    executeDeposit(accounts, commandArgs);
                    break;
                case "SetInterest":
                    executeSetInterest(commandArgs[1]);
                    break;
                case "GetInterest":
                    executeGetInterest(accounts, commandArgs);
                    break;
            }

            commandInfo = reader.readLine();
        }
    }

    private static void executeCreate(HashMap<Integer, BankAccount> accounts) {
        BankAccount account = new BankAccount();
        accounts.put(account.getId(), account);
        System.out.printf("Account %s created%n", account);
    }

    private static void executeSetInterest(String commandArg) {
        double interest = Double.parseDouble(commandArg);

        try {
            BankAccount.setInterest(interest);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }

    private static void executeGetInterest(HashMap<Integer, BankAccount> accounts, String[] commandArgs) {
        int id = Integer.parseInt(commandArgs[1]);

        if (!accounts.containsKey(id)) {
            System.out.println("Account does not exist");
            return;
        }

        int years = Integer.parseInt(commandArgs[2]);
        BankAccount account = accounts.get(id);

        try {
            System.out.printf("%.2f%n", account.getInterest(years));
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }

    }

    private static void executeDeposit(HashMap<Integer, BankAccount> accounts, String[] commandArgs) {
        int id = Integer.parseInt(commandArgs[1]);

        if (!accounts.containsKey(id)) {
            System.out.println("Account does not exist");
            return;
        }

        double amount = Double.parseDouble(commandArgs[2]);
        BankAccount account = accounts.get(id);

        try {
            account.deposit(amount);
            System.out.printf("Deposited %s to %s%n", df.format(amount), account);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }
}
