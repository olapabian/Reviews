
package com.example.Reviews.Controllers.HomeControllers;

import com.example.Reviews.Model.MyUserDTO;
import com.example.Reviews.Services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @GetMapping("/register")
    public String RegisterPage(Model model) {
        model.addAttribute("userDTO", new MyUserDTO());
            return "/HomePages/register";
    }

    @PostMapping("/zarejestruj")
    public String processRegistrationForm(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
        // Walidacja pól ręcznie
//        if (userDTO.getUsername() == null || userDTO.getUsername().isEmpty()) {
//            model.addAttribute("usernameError", "Nazwa użytkownika nie może być pusta");
//            return "register?failed";
//        }
//
//        if (userDTO.getPassword() == null || userDTO.getPassword().isEmpty()) {
//            model.addAttribute("passwordError", "Hasło nie może być puste");
//            return "register?failed";
//        }


//        if (!userDTO.getPassword().equals(userDTO.getConfirmPassword())) {
//            model.addAttribute("passwordMatchError", "Potwierdzenie hasła nie pasuje do hasła");
//            return "registrationForm";
//        }
        MyUserDTO myUserDTO = new MyUserDTO();
        myUserDTO.setPassword(password);
        myUserDTO.setUsername(username);
        // Wywołanie serwisu rejestracji
        registrationService.registerNewUser(myUserDTO);
        return "redirect:/login";
    }
}
