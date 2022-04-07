package com.sparta.week5.login;


import com.sparta.week5.model.Restaurant;
import com.sparta.week5.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private final UserService userService;
    private final RestaurantRepository restaurantRepository;

    @Autowired
    public UserController(UserService userService,RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
        this.userService = userService;
    }


    // 회원 로그인 페이지
    @GetMapping("/user/login")
    public String login() {
        return "login";
    }

    // 회원 가입 페이지
    @GetMapping("/user/signup")
    public String signup() {
        return "signup";
    }

    @GetMapping("/{restaurantId}/menu")
    public String signup(@PathVariable Long restaurantId,
                         Model model) {
        Restaurant restaurant = restaurantRepository.findRestaurantById(restaurantId);
        model.addAttribute("restaurant",restaurant);
        return "menudetail";
    }


    @GetMapping("/restaurant/register/food/{restaurantId}")
    public String menu(Model model,@PathVariable Long restaurantId) {
        model.addAttribute("restaurantId",restaurantId);
        return "menu";
    }

    // 회원 가입 요청 처리
    @PostMapping("/user/signup")
    public String registerUser(SignupRequestDto requestDto) {
        userService.registerUser(requestDto);
        return "redirect:/user/login";
    }
}