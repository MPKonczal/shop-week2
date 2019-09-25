package pl.edu.utp.wtie.homeworkweek2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;

@Controller
@Profile("Pro")
public class ShopPro {

    @Autowired
    public ShopPro(Basket basket) {
        String mode = "Pro";
        basket.showInfo(mode);
    }
}
