package ru.careportal.core.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.careportal.core.data.UserRepo;
import ru.careportal.core.dto.User;
import ru.careportal.core.security.RegistrationForm;

import java.util.Map;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
    private UserRepo userRepo;
    private PasswordEncoder passwordEncoder;

    public RegistrationController(
            UserRepo userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String registration(Model model) {
        model.addAttribute("PageTitle", "Registration Page");
        model.addAttribute("PageBody", "reg.jsp");
        return "baseTemplate";
    }

    @PostMapping
    public String processRegistration(RegistrationForm form, Model model) {

//        if (form == null) {
//            model.put("message", "User is exist");
//            return "/reg";
//        }
        User user = form.toUser(passwordEncoder);
        User userFromDB = userRepo.findByUsername(user.getUsername());
        if (userFromDB != null) {
            model.addAttribute("message", "User already exist");
            model.addAttribute("PageTitle", "Registration Page");
            model.addAttribute("PageBody", "reg.jsp");
            return "baseTemplate";
        }

        userRepo.save(form.toUser(passwordEncoder));
        return "redirect:/login";
    }
}