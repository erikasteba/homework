package homework.app.controller;

import homework.app.entity.User;
import homework.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String username, @RequestParam String email,
                               @RequestParam String password, Model model) {
        User user = userService.registerNewUser(username, email, password);
        if (user != null) {
            return "redirect:/login"; // Redirect to login after successful registration
        } else {
            model.addAttribute("error", "Registration failed. Please try again.");
            return "register";
        }
    }
}
