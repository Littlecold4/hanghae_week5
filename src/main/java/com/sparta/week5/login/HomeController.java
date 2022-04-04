package com.sparta.week5.login;


import com.sparta.week5.login.security.UserDetailsImpl;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        model.addAttribute("username", userDetails.getUsername());

        if (userDetails.getUser().getRole() == UserRoleEnum.USER) {
            model.addAttribute("admin_role", "손님");
            return "index";
        }else{
            return "ceo";
        }

    }
}