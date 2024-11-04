package AlexeyPolyakov.MyFinalWork.Service;

import AlexeyPolyakov.MyFinalWork.DataBase.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByEmail(String email);
}
