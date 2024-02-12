<<<<<<< HEAD
//package com.example.Reviews.Model;
//
//import com.example.Reviews.Repositories.MyUserRepository;
//import com.example.Reviews.Services.MyDatabaseUserDetailsService;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//        @Bean
//         public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception { //tu ustawiam wszelkie przekierowywania
//            http
//                    .authorizeRequests(authorize -> authorize
//                            .requestMatchers("/helloPage").permitAll() //każdy ma dostęp do helloPage.html
//                            .requestMatchers("/login").permitAll() //każdy ma dostęp do login.html
//                            .requestMatchers("/style/**").permitAll() //dostęp do css js itp.
//
//                            .anyRequest().authenticated() // Wymagane uwierzytelnienia dla innych zasobów
//                    )
//
//                    .formLogin(form -> form
//                            .usernameParameter("username")
//                            .passwordParameter("password")
//
//                            .loginPage("/login") // Strona logowania
//                            .failureUrl("/login?failed") //jak złe hasło czy coś
//                            .loginProcessingUrl("/login") //processowanie
//
//                            .defaultSuccessUrl("/homePage")
//                    );
//
//            return http.build();
//        }
//
//        @Bean
//        public static PasswordEncoder passwordencoder() {
//            return new BCryptPasswordEncoder();
//        }
//
//
//        private final MyUserRepository myUserRepository;
//        public SecurityConfig(MyUserRepository myUserRepository) {
//
//            this.myUserRepository = myUserRepository;
//        }
//
//        @Bean
//        public UserDetailsService userDetailsService() {
//            return new MyDatabaseUserDetailsService(myUserRepository);
//        }
//
//}
//
=======
package com.example.Reviews.Model;

import com.example.Reviews.Repositories.MyUserRepository;
import com.example.Reviews.Services.MyDatabaseUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
        @Bean
         public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception { //tu ustawiam wszelkie przekierowywania
            http
                    .authorizeRequests(authorize -> authorize
                            .requestMatchers("/helloPage").permitAll() //każdy ma dostęp do helloPage.html
                            .requestMatchers("/login").permitAll() //każdy ma dostęp do login.html
                            .requestMatchers("/style/**").permitAll() //dostęp do css js itp.
                            .anyRequest().authenticated() // Wymagane uwierzytelnienia dla innych zasobów
                    )

                    .formLogin(form -> form
                            .usernameParameter("username")
                            .passwordParameter("password")

                            .loginPage("/login") // Strona logowania
                            .failureUrl("/login?failed") //jak złe hasło czy coś
                            .loginProcessingUrl("/login") //processowanie

                            .defaultSuccessUrl("/homePage")
                    );

            return http.build();
        }

        @Bean
        public static PasswordEncoder passwordencoder() {
            return new BCryptPasswordEncoder();
        }


        private final MyUserRepository myUserRepository;
        public SecurityConfig(MyUserRepository myUserRepository) {

            this.myUserRepository = myUserRepository;
        }

        @Bean
        public UserDetailsService userDetailsService() {
            return new MyDatabaseUserDetailsService(myUserRepository);
        }

}

>>>>>>> 32c33eb846bc164d97b48cece151813d0a2be2ec
