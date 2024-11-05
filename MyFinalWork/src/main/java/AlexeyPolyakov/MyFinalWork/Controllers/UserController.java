package AlexeyPolyakov.MyFinalWork.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/Profile")
public class UserController {

    @GetMapping("/Profile")
    public  String UserPage(){
        return "UserProfile";
    }
    @GetMapping("/MainPage")
    public  String MainPage(){
        return "MainPage";
    }

}
