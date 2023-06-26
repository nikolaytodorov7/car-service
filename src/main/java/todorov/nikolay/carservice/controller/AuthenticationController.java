package todorov.nikolay.carservice.controller;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import todorov.nikolay.carservice.model.UserDTO;

@RequestMapping
public interface AuthenticationController {
    @GetMapping("/log")
    String loginForm(Model model);

    @GetMapping("/reg")
    String registerForm(Model model);

    @GetMapping("/login")
    String login(@RequestParam String username, @RequestParam String password, Model model);

    @Transactional
    @PostMapping("/register")
    String register(@RequestBody UserDTO user, Model model);
}
