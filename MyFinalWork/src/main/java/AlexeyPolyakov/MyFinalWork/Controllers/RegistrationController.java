package AlexeyPolyakov.MyFinalWork.Controllers;

import AlexeyPolyakov.MyFinalWork.DataBase.UserEntity;
import AlexeyPolyakov.MyFinalWork.Service.UserService;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new UserEntity());
        return "registration"; // имя вашего HTML-шаблона
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<?> addUser(@RequestBody @Valid UserEntity userForm) {
        if (!userForm.getHashPassword().equals(userForm.getConfirmPassword())) {
            return ResponseEntity.badRequest().body("Пароли не совпадают");
        }
        if (!userService.saveUser(userForm)) {
            return ResponseEntity.badRequest().body("Пользователь с таким именем уже существует");
        }


        return ResponseEntity.ok("Регистрация успешна");
    }
}
