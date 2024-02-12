//package com.example.Reviews.Services;
//
//import com.example.Reviews.Model.MyUser;
//import com.example.Reviews.Model.MyUserDTO;
//import com.example.Reviews.Repositories.MyUserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.Collections;
//import java.util.List;
//
//@Service
//public class RegistrationService {
//
//    @Autowired
//    private MyUserRepository userRepository;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    public void registerNewUser(MyUserDTO userDTO) {
//        if (userRepository.findByUsername(userDTO.getUsername()) != null) {
//            throw new RuntimeException("Użytkownik o podanej nazwie już istnieje");
//        }
//
////        if (!userDTO.getPassword().equals(userDTO.getConfirmPassword())) {
////            throw new RuntimeException("Potwierdzenie hasła nie pasuje do hasła");
////        }
//
//        MyUser user = new MyUser();
//        user.setUsername(userDTO.getUsername());
//        user.setPassword(passwordEncoder.encode(userDTO.getPassword())); // Szyfrowanie hasła
//        user.setRoles(Collections.singleton("USER").toString()); // Domyślna rola użytkownika
//
//        userRepository.save(user);
//    }
//}
