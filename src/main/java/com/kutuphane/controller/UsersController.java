package com.kutuphane.controller;

import com.kutuphane.model.Users;
import com.kutuphane.service.UsersService;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UsersController {

    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @RestController
    public class IndexController implements ErrorController {
        private static final String PATH = "/error";

        @RequestMapping(value = PATH)
        public String error() {
            return "Bu Değer Girilemez";
        }

        @Override
        public String getErrorPath() {
            return PATH;
        }
    }

    @GetMapping("/")
    public String getlogin(@ModelAttribute("users") Users users, Model model) {
        {
            return "index";
        }
    }

    @GetMapping("/saveuser")
    public String getUsers(@ModelAttribute("users") Users users, Model model) {
        model.addAttribute("users", users);
        return "user/create";
    }

    @PostMapping("/saveuser")
    public String saveUsers(Users users) {
        usersService.save(users);
        return "redirect:/";
    }

    @PostMapping("loginuser")
    public String loginUser(@ModelAttribute("users") Users users, Model model) {
        boolean isSuccess = usersService.login(users.getUsername(), users.getPassword());
        if (isSuccess) {
            return "redirect:/book";
        }
        model.addAttribute("isSuccess", isSuccess);
        return "index";
    }

}
