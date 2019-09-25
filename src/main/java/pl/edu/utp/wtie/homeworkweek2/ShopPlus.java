package pl.edu.utp.wtie.homeworkweek2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;

@Controller
@Profile("Plus")
public class ShopPlus {

    @Autowired
    public ShopPlus(Basket basket) {
        String mode = "Plus";
        basket.showInfo(mode);
    }
}
