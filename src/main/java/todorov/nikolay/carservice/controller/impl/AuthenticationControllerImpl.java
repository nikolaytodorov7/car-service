package todorov.nikolay.carservice.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import todorov.nikolay.carservice.controller.AuthenticationController;
import todorov.nikolay.carservice.model.UserDTO;
import todorov.nikolay.carservice.service.AuthenticationService;

@Controller
public class AuthenticationControllerImpl implements AuthenticationController {
    @Autowired
    AuthenticationService authenticationService;

    @Override
    public String loginForm(Model model) {
        return authenticationService.loginForm(model);
    }

    @Override
    public String registerForm(Model model) {
        return authenticationService.registerForm(model);
    }

    @Override
    public String login(String username, String password, Model model) {
        return authenticationService.login(username, password, model);
    }

    @Override
    public String register(UserDTO user, Model model) {
        return authenticationService.register(user, model);
    }
}
