
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
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import java.util.Locale;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(authorize -> authorize
                        //dostep zawsze
                        .requestMatchers("/helloPage").permitAll()
                        .requestMatchers("/login").permitAll()
                        .requestMatchers("/style/**").permitAll()
                        .requestMatchers("/register").permitAll() // Zezwolenie dla '/register'
                        .requestMatchers("/zarejestruj").permitAll()

                        //dostep jak jestes zalogowany
                        .requestMatchers("/home").authenticated()
                        .requestMatchers("/").authenticated()
                        .requestMatchers("/home/addReviewForm").authenticated()
                        .requestMatchers("/home/myReviewsForm").authenticated()
                        .requestMatchers("/addReview").authenticated()
                        .requestMatchers("/addReview/add").authenticated()
                        .requestMatchers("/editReviewPage").authenticated()
                        .requestMatchers("/myReview").authenticated()
                        .requestMatchers("/myReview/deleteReview").authenticated()
                        .requestMatchers("/myReviews").authenticated()
                        .requestMatchers("/editReview").authenticated()
                        .anyRequest().permitAll()
                )
                .formLogin(form -> form
                        .usernameParameter("username")
                        .passwordParameter("password")
                        .loginPage("/login")
                        .failureUrl("/login?failed")
                        .loginProcessingUrl("/login/process")
                        .defaultSuccessUrl("/home")
                );
//                .formLogin(form -> form
//                        .loginPage("/login")
//                        .failureUrl("/login?failed")
//                        .loginProcessingUrl("/login/process")
//                        .defaultSuccessUrl("/home")
//                );


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


}

