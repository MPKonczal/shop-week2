package pl.edu.utp.wtie.homeworkweek2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;

@Controller
@Profile("Start")
public class ShopStart {

    @Autowired
    public ShopStart(Basket basket) {
        String mode = "Start";
        basket.showInfo(mode);
    }
}
