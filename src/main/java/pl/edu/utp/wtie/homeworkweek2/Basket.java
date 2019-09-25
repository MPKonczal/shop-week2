package pl.edu.utp.wtie.homeworkweek2;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@ConfigurationProperties(prefix="page-info")
public class Basket {

    private int tax;
    private int discount;
    private List<Product> productList;

    public Basket() {
        Product product = new Product();
        Product product1 = new Product("bread", product.getRandomPrice());
        Product product2 = new Product("orange juice", product.getRandomPrice());
        Product product3 = new Product("ham", product.getRandomPrice());
        Product product4 = new Product("cheese", product.getRandomPrice());
        Product product5 = new Product("wine", product.getRandomPrice());
        productList = new ArrayList<>();
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);
        productList.add(product5);
    }

    void showInfo(String mode) {
        System.out.println("Witaj w sklepie internetowym w wariancie " + mode);
        System.out.println("*** Lista produktów w koszyku: ***");
        productList.forEach(System.out::println);
        System.out.format("Sumaryczna cena netto: %.2f zł%n", getNetPrice());

        if ("Plus".equals(mode) || "Pro".equals(mode)) {
            System.out.format("Podatek VAT (%d%%): %.2f zł%n", getTax(), calculateTax());
            System.out.format("Cena brutto: %.2f zł%n", getGrossPrice());
            {
                if ("Pro".equals(mode)) {
                    System.out.format("Rabat (%d%%): %.2f zł%n", getDiscount(), calculateDiscount());
                    System.out.format("Cena brutto z uwzględeniem rabatu: %.2f zł%n", getDiscountedPrice());
                }
            }
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
