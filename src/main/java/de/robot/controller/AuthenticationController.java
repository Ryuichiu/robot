package de.robot.controller;

import de.robot.model.User;
import de.robot.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/authentication")
public class AuthenticationController {

    private UserService userService;

    public AuthenticationController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/")
    public ModelAndView authenticationView() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        mav.addObject("User", new User());
        return mav;
    }

    @PostMapping("/registration")
    public ModelAndView createNewUser(@Valid User user) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("redirect:/authentication/");
        userService.registerNewUser(user);
        return mav;
    }

    @PostMapping("/logout")
    public ModelAndView logout() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("redirect:/authentication/");
        return mav;
    }
}
