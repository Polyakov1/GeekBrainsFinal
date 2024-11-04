package AlexeyPolyakov.MyFinalWork.Controllers;

import AlexeyPolyakov.MyFinalWork.DataBase.UserEntity;
import AlexeyPolyakov.MyFinalWork.Service.UserService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/registration")
public class RegistrationController {

    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    // Обработчик GET-запросов для страницы регистрации
    @GetMapping
    public ResponseEntity<String> showRegistrationForm() {
        // Верните HTML-страницу или сообщение о том, что форма регистрации доступна
        return ResponseEntity.ok("Форма регистрации"); // Замените на вашу логику
    }

    @PostMapping
    public ResponseEntity<?> addUser(@RequestBody @Valid UserEntity userForm) {
        // Здесь вы можете добавить логику проверки пароля
        if (!userForm.getHashPassword().equals(userForm.getConfirmPassword())) {
            return ResponseEntity.badRequest().body("Пароли не совпадают");
        }
        if (!userService.saveUser(userForm)) {
            return ResponseEntity.badRequest().body("Пользователь с таким именем уже существует");
        }

        return ResponseEntity.ok("Регистрация успешна");
    }
}
