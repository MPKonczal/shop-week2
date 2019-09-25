package pl.edu.utp.wtie.homeworkweek2;

import java.util.Random;

public class Product {

    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Product() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getRandomPrice() {
        Random random = new Random();
        double randomPrice = random.nextDouble() * (300 - 50) + 50;
        randomPrice *= 100;
        randomPrice = Math.round(randomPrice);
        randomPrice /= 100;
        return randomPrice;
    }

    @Override
    public String toString() {
        return "-> " + name + ": " + price + " zł";
    }
}
