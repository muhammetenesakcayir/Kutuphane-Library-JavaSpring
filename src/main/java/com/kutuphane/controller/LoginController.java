package com.kutuphane.controller;

import com.kutuphane.model.Users;
import com.kutuphane.service.UserService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class LoginController {

   private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String getlogin() {
        {
            return "login/login";
        }
    }

    @GetMapping("/login")
    public String login(Principal principal) {
        if(principal != null){
            return "redirect:/book";
        }
        return "login/login";
    }

    @GetMapping("/signup")
    public String signup(Model model) {
        model.addAttribute("user",new Users());
        model.addAttribute("action","user");
        return "login/signup";
    }

    @GetMapping("/admin/signup")
    public String signupAdmin(Model model) {
        model.addAttribute("user",new Users());
        model.addAttribute("action","admin");
        return "login/signup";
    }

    @PostMapping("/signup")
    public String SignupUser(@ModelAttribute Users user) {
        userService.SignupUser(user);
        return "redirect:/";
    }

    @PostMapping("/admin/signup")
    public String SignupAdmin(@ModelAttribute Users user) {
        userService.SignupAdmin(user);
        return "redirect:/";
    }

    @ExceptionHandler({DataIntegrityViolationException.class})
    public String sameUsername(Exception e){
        return "redirect:/signup?error";
    }
}
