
package com.example.Reviews.Controllers.HomeControllers;

import com.example.Reviews.Model.MyUserDTO;
import com.example.Reviews.Repositories.MyUserRepository;
import com.example.Reviews.Services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;
    @Autowired
    private MyUserRepository userRepository;
    @GetMapping("/register")
    public String RegisterPage(Model model) {
        model.addAttribute("userDTO", new MyUserDTO());
            return "/HomePages/register";
    }

    @PostMapping("/zarejestruj")
    public String processRegistrationForm(@RequestParam("username") String username,
                                          @RequestParam("password") String password,
                                          Model model) {
        // Tworzymy nowy obiekt MyUserDTO
        MyUserDTO myUserDTO = new MyUserDTO();
        myUserDTO.setPassword(password);
        myUserDTO.setUsername(username);

        // Sprawdzamy poprawność danych
        if (username == null || username.isEmpty()) {
            model.addAttribute("usernameError", "Nazwa użytkownika nie może być pusta");
            return "HomePages/register";
        }

        if (password == null || password.isEmpty()) {
            model.addAttribute("passwordError", "Hasło nie może być puste");
            return "HomePages/register";
        }

        if(registrationService.registerNewUser(myUserDTO, model)) {
            return "redirect:/login";
        }
        else {
            model.addAttribute("errorMessage", "Użytkownik o podanej nazwie już istnieje");
            System.out.println("Gówno nie działa aaaa username");
            return "HomePages/register";
        }
    }

}
