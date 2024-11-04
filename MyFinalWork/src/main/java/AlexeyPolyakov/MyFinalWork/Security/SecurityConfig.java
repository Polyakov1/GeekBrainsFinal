package AlexeyPolyakov.MyFinalWork.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/public/**").permitAll() // Разрешить доступ к публичным ресурсам
                        .requestMatchers("/registration").permitAll() // Разрешить доступ к странице регистрации
                        .anyRequest().authenticated() // Все остальные запросы требуют аутентификации
                )
                .formLogin(form -> form
                        .loginPage("/registration") // Укажите вашу кастомную страницу авторизации
                        .permitAll() // Разрешить доступ к странице авторизации
                )
                .logout(logout -> logout
                        .permitAll() // Разрешить выход
                );

        return http.build();
    }
}
