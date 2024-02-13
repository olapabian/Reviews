package com.example.Reviews.Services;

import com.example.Reviews.Model.MyUser;
import com.example.Reviews.Model.MyUserDTO;
import com.example.Reviews.Repositories.MyUserRepository;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.Collections;
import java.util.List;

@Service
public class RegistrationService {

    @Autowired
    private MyUserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean registerNewUser(MyUserDTO userDTO, Model model) {

        if (!userRepository.findByUsername(userDTO.getUsername()).isEmpty()) {
            return false;
        }

        MyUser user = new MyUser();
        user.setUsername(userDTO.getUsername());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword())); // Szyfrowanie hasła
        user.setRoles(Collections.singleton("USER").toString()); // Domyślna rola użytkownika

        userRepository.save(user);
        return true;
    }
}
