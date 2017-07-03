package shoppingSpree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Person> peopleMoney = new ArrayList<>();
        List<Product> productsCost = new ArrayList<>();

        String[] peopleInfo = reader.readLine().split(";");
        String[] productsInfo = reader.readLine().split(";");
        String input = reader.readLine();

        try {
            for (int i = 0; i < peopleInfo.length; i++) {
                String[] peopleAndMoney = peopleInfo[i].trim().split("=");
                String name = peopleAndMoney[0];
                double money = Double.parseDouble(peopleAndMoney[1]);
                Person person = new Person(name, money);
                peopleMoney.add(person);
            }

            for (int i = 0; i < productsInfo.length; i++) {
                String[] productsAndPrice = productsInfo[i].trim().split("=");
                String name = productsAndPrice[0];
                double price = Double.parseDouble(productsAndPrice[1]);
                Product product = new Product(name, price);
                productsCost.add(product);
            }

        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
            return;
        }

        while (!input.equals("END")) {
            String[] purchasesInfo = input.split("\\s+");
            String personName = purchasesInfo[0];
            String productName = purchasesInfo[1];
            boolean isFound = false;

            for (Person person : peopleMoney) {
                String currentPerson = person.getName();
                Double currentMoney = person.getMoney();

                if (currentPerson.equals(personName)) {
                    for (Product product : productsCost) {
                        String currentProduct = product.getName();
                        double currentPrice = product.getCost();

                        if (currentProduct.equals(productName) && currentMoney >= currentPrice) {
                            System.out.printf("%s bought %s%n", currentPerson, currentProduct);
                            person.setMoney(currentMoney - currentPrice);
                            person.addProducts(product);
                            isFound = true;
                            break;
                        } else if (currentProduct.equals(productName) && currentMoney < currentPrice){
                            System.out.printf("%s can't afford %s%n", currentPerson, currentProduct);
                            isFound = true;
                            break;
                        }
                    }
                }

                if (isFound) {
                    break;
                }
            }

            input = reader.readLine();
        }

        for (Person person : peopleMoney) {
            String name = person.getName();
            List<Product> buyProducts = person.getProducts();

            if (buyProducts.size() > 0) {
                List<String> allPersоnProducts = new ArrayList<>();
                for (Product buyProduct : buyProducts) {
                    allPersоnProducts.add(buyProduct.getName());
                }
                String joined = String.join(", ", allPersоnProducts);
                System.out.printf("%s - %s%n", name, joined);
            } else {
                System.out.printf("%s - Nothing bought%n", name);
            }
        }
    }
}
