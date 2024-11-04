package AlexeyPolyakov.MyFinalWork.DataBase;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "hash_password", nullable = false)
    private String hashPassword;



    private String confirmPassword;
    public UserEntity() {


    }

    public UserEntity(int id, String name, String surname, String lastName, String email, Date birthday, String phoneNumber, String hashPassword) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.lastName = lastName;
        this.email = email;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.hashPassword = hashPassword;
    }
}
