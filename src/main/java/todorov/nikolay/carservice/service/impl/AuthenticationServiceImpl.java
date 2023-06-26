package todorov.nikolay.carservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import todorov.nikolay.carservice.model.User;
import todorov.nikolay.carservice.model.UserDTO;
import todorov.nikolay.carservice.model.UserNameDTO;
import todorov.nikolay.carservice.model.UserType;
import todorov.nikolay.carservice.repository.UserRepository;
import todorov.nikolay.carservice.service.AuthenticationService;

import java.util.Base64;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private static final String LOGIN_FORM_TEMPLATE = "login";
    private static final String REGISTER_FORM_TEMPLATE = "register";

    @Autowired
    UserRepository userRepository;

    @Override
    public String loginForm(Model model) {
        return LOGIN_FORM_TEMPLATE;
    }

    @Override
    public String registerForm(Model model) {
        return REGISTER_FORM_TEMPLATE;
    }

    @Override
    public String login(String username, String password, Model model) {
        String encodedPass = Base64.getEncoder().encodeToString(password.getBytes());
        User user = userRepository.getUserByCredentials(username, encodedPass);
        if (user == null) {
            return "redirect:/log";
        }

        return user.getType() == UserType.CLIENT ? "redirect:/client/" + user.getUserId() : "redirect:/employee/" + user.getUserId();
    }

    @Override
    public String register(UserDTO user, Model model) {
        String encodedPass = Base64.getEncoder().encodeToString(user.getPassword().getBytes());
        user.setPassword(encodedPass);
        UserNameDTO userNameDTO = new UserNameDTO(user.getName());
        if (user.getType() == UserType.EMPLOYEE) {
            userRepository.insertEmployee(userNameDTO);
        } else {
            userRepository.insertClient(userNameDTO);
        }

        user.setUserId(userNameDTO.getId());
        userRepository.insertUser(user);
        return LOGIN_FORM_TEMPLATE;
    }
}
