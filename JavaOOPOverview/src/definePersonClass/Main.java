package definePersonClass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String commandInfo = reader.readLine();
        HashMap<Integer, BankAccount> accounts = new HashMap<>();

        while (!commandInfo.equals("End")) {
            String[] commandArgs = commandInfo.split("\\s+");
            String command = commandArgs[0];

            switch (command) {
                case "Create":
                    executeCreate(commandArgs, accounts);
                    break;
                case "Deposit":
                    executeDeposit(commandArgs, accounts);
                    break;
                case "Withdraw":
                    executeWithdraw(commandArgs, accounts);
                    break;
                case "Print":
                    executePrint(commandArgs, accounts);
                    break;
            }

            commandInfo = reader.readLine();
        }
    }

    private static void executePrint(String[] commandArgs, HashMap<Integer, BankAccount> accounts) {
        int id = Integer.parseInt(commandArgs[1]);

        if (!accounts.containsKey(id)) {
            System.out.println("Account does not exist");
            return;
        }

        BankAccount account = accounts.get(id);
        System.out.printf("Account %s, balance %.2f%n", account, account.getBalance());
    }

    private static void executeWithdraw(String[] commandArgs, HashMap<Integer, BankAccount> accounts) {
        int id = Integer.parseInt(commandArgs[1]);
        double amount = Double.parseDouble(commandArgs[2]);

        if (!accounts.containsKey(id)) {
            System.out.println("Account does not exist");
            return;
        }

        try {
            accounts.get(id).withdraw(amount);
        } catch (IllegalStateException ise) {
            System.out.println(ise.getMessage());
        }
    }

    private static void executeDeposit(String[] commandArgs, HashMap<Integer, BankAccount> accounts) {
        int id = Integer.parseInt(commandArgs[1]);
        double amount = Double.parseDouble(commandArgs[2]);

        if (!accounts.containsKey(id)) {
            System.out.println("Account does not exist");
            return;
        }

        try {
            accounts.get(id).deposit(amount);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }

    private static void executeCreate(String[] commandArgs, HashMap<Integer, BankAccount> accounts) {
        int id = Integer.parseInt(commandArgs[1]);

        if (accounts.containsKey(id)) {
            System.out.println("Account already exists");
        } else {
            BankAccount account = new BankAccount();
            account.setId(id);
            accounts.put(id, account);
        }
    }
}