package todorov.nikolay.carservice.service;

import org.springframework.ui.Model;
import todorov.nikolay.carservice.model.UserDTO;

public interface AuthenticationService {
    String loginForm(Model model);

    String registerForm(Model model);

    String login(String username, String password, Model model);

    String register(UserDTO user, Model model);
}
