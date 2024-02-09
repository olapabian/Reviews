package com.example.Reviews.Model;

import ch.qos.logback.core.encoder.Encoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
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
                            .anyRequest().authenticated() // Wymaganie uwierzytelnienia dla innych zasobów
                    )

                    .formLogin(form -> form
                            .usernameParameter("username")
                            .passwordParameter("password")

                            .loginPage("/login") // Strona logowania
                            .failureUrl("/login?failed")
                            .loginProcessingUrl("/login")

                            .defaultSuccessUrl("/homePage")
                    );

            return http.build();
        }

        @Bean
        public static PasswordEncoder passwordencoder() {
            return new BCryptPasswordEncoder();
        }
//tutaj potrzebujemy repository dla użytkowników żeby hasła działało
//        @Bean
//        public InMemoryUserDetailsManager userDetailsService() {
//            UserDetails admin = User.withUsername("admin")
//                    .password(passwordencoder().encode("adminPass"))
//                    .roles("ADMIN")
//                    .build();
//            UserDetails user = User.withUsername("user")
//                    .password(passwordencoder().encode("userPass"))
//                    .roles("USER")
//                    .build();
//            return new InMemoryUserDetailsManager(admin, user);
//        }


}

