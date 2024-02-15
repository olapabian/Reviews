package com.example.Reviews.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MyUserDTO {

    private Long id;
    private String username;
    private String password;
    private String roles;

    public MyUserDTO(String testUser, String password) {
    }

//    private String confirmPassword;
//
//    // Metoda zwracająca potwierdzenie hasła
//    public String getConfirmPassword() {
//        return confirmPassword;
//    }
//
//    // Metoda ustawiająca potwierdzenie hasła
//    public void setConfirmPassword(String confirmPassword) {
//        this.confirmPassword = confirmPassword;
//    }
}
