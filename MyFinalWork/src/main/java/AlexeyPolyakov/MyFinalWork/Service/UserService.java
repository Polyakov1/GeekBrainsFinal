package AlexeyPolyakov.MyFinalWork.Service;

import AlexeyPolyakov.MyFinalWork.DataBase.UserEntity;
import AlexeyPolyakov.MyFinalWork.MessageError.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserEntity> GetAllUser()
    {
       return userRepository.findAll();
    }
    public void CreateUser(UserEntity userEntity){
        userRepository.save(userEntity);
    }
    public void DeleteUser(UserEntity userEntity){
        userRepository.delete(userEntity);
    }
    public UserEntity getClientById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Client with ID " + id + " not found"));
    }
    public void UpdateUser(UserEntity userEntity){
        userRepository.save(userEntity);
    }
    public Boolean SaveUser(UserEntity userEntity){
        try {
            userRepository.save(userEntity);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean saveUser(UserEntity user) {
        // Проверяем, существует ли пользователь с таким email
        if (userRepository.findByEmail(user.getEmail()) != null) {
            return false; // Пользователь с таким email уже существует
        }
        System.out.println(user);
        userRepository.save(user); // Сохраняем пользователя
        System.out.println(userRepository.findByEmail(user.getEmail()));
        return true; // Успешно сохранено
    }
}
