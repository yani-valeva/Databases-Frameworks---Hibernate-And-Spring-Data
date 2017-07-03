package shoppingSpree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private Double money;
    private List<Product> products;

    public Person() {
        this.products = new ArrayList<>();
    }

    public Person(String name, Double money) {
        this();
        this.setName(name);
        this.setMoney(money);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }

        this.name = name;
    }

    public Double getMoney() {
        return this.money;
    }

    public void setMoney(Double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }

        this.money = money;
    }

    public List<Product> getProducts() {
        return this.products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void addProducts(Product product) {
        this.products.add(product);
    }
}
