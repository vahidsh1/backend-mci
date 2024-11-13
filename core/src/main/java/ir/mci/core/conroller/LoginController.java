package ir.mci.core.conroller;

import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Controller
@RequestMapping("/")
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login"; // Assuming your login page is in the templates directory
    }

//    @PostMapping("/login")
//    public String loginPost(User request,
//                            BindingResult result,
//                            Model model) {
//
//        // Implement your authentication logic here
//        // ...
//
//        if (result.hasErrors()) {
//            return "login";
//        }
//
//        // Successful authentication
//        return "redirect:/home"; // Replace with your desired redirect URL
//    }
}