package pl.edu.utp.wtie.homeworkweek2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;

@Controller
@Profile("Pro")
public class ShopPro {

    private Basket basket;

    @Autowired
    public ShopPro(Basket basket) {
        this.basket = basket;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void showInfo() {
        System.out.println("Witaj w sklepie internetowym w wariancie PRO");
        System.out.println("*** Lista produktów w koszyku: ***");
        basket.getProductList().forEach(System.out::println);
        System.out.format("Sumaryczna cena netto: %.2f zł%n", basket.getNetPrice());
        System.out.format("Podatek VAT (%d%%): %.2f zł%n", basket.getTax(), basket.calculateTax());
        System.out.format("Cena brutto: %.2f zł%n", basket.getGrossPrice());
        System.out.format("Rabat (%d%%): %.2f zł%n", basket.getDiscount(), basket.calculateDiscount());
        System.out.format("Cena brutto z uwzględeniem rabatu: %.2f zł%n", basket.getDiscountedPrice());
    }
}
