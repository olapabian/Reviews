//package com.example.Reviews.Controllers.HomeControllers;
//
//import com.example.Reviews.Model.MyUserDTO;
//import com.example.Reviews.Services.RegistrationService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//@Controller
//public class RegistrationController {
//
//    @Autowired
//    private RegistrationService registrationService;
//
//    @GetMapping("/register")
//    public String showRegistrationForm(Model model) {
//        model.addAttribute("userDTO", new MyUserDTO());
//        return "registrationForm";
//    }
//
//    @PostMapping("/register")
//    public String processRegistrationForm(@ModelAttribute("userDTO") MyUserDTO userDTO, Model model) {
//        // Walidacja pól ręcznie
//        if (userDTO.getUsername() == null || userDTO.getUsername().isEmpty()) {
//            model.addAttribute("usernameError", "Nazwa użytkownika nie może być pusta");
//            return "registrationForm";
//        }
//
//        if (userDTO.getPassword() == null || userDTO.getPassword().isEmpty()) {
//            model.addAttribute("passwordError", "Hasło nie może być puste");
//            return "registrationForm";
//        }
//
////        if (!userDTO.getPassword().equals(userDTO.getConfirmPassword())) {
////            model.addAttribute("passwordMatchError", "Potwierdzenie hasła nie pasuje do hasła");
////            return "registrationForm";
////        }
//
//        // Wywołanie serwisu rejestracji
//        registrationService.registerNewUser(userDTO);
//        return "redirect:/login";
//    }
//}
