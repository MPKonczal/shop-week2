package pl.edu.utp.wtie.homeworkweek2;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@ConfigurationProperties(prefix="page-info")
public class Basket {

    private int tax;
    private int discount;
    private List<Product> productList;

    public Basket() {
        Product product1 = new Product("bread", getPrice());
        Product product2 = new Product("orange juice", getPrice());
        Product product3 = new Product("ham", getPrice());
        Product product4 = new Product("cheese", getPrice());
        Product product5 = new Product("wine", getPrice());
        productList = new ArrayList<>();
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);
        productList.add(product5);
    }

    //@EventListener(ApplicationReadyEvent.class)
    void showInfo(String mode) {
        System.out.println("Witaj w sklepie internetowym w wariancie " + mode);
        System.out.println("*** Lista produktów w koszyku: ***");
        productList.forEach(System.out::println);
        System.out.format("Sumaryczna cena netto: %.2f zł%n", getNetPrice());

        if ("Plus".equals(mode) || "Pro".equals(mode)) {
            System.out.format("Podatek VAT (%d%%): %.2f zł%n", getTax(), calculateTax());
            System.out.format("Cena brutto: %.2f zł%n", getGrossPrice());
        } else if ("Pro".equals(mode)) {
            System.out.format("Rabat (%d%%): %.2f zł%n", getDiscount(), calculateDiscount());
            System.out.format("Cena brutto z uwzględeniem rabatu: %.2f zł%n", getDiscountedPrice());
        }
    }

    public List<Product> getProductList() {
        return productList;
    }

    public int getTax() {
        return tax;
    }

    public void setTax(int tax) {
        this.tax = tax;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public double getPrice() {
        Random random = new Random();
        double price = random.nextDouble() * (300 - 50) + 50;
        price *= 100;
        price = Math.round(price);
        price /= 100;
        return price;
    }

    public double getGrossPrice () {
        return getNetPrice() + calculateTax();
    }

    private double calculateTax() {
        return getNetPrice() * getTax() / 100;
    }

    public double getDiscountedPrice () {
        return getGrossPrice() - calculateDiscount();
    }

    private double calculateDiscount() {
        return getGrossPrice() * getDiscount() / 100;
    }

    public double getNetPrice() {
        double netPrice = 0;
        for (Product product : productList) {
            netPrice += product.getPrice();
        }
        return netPrice;
    }
}
