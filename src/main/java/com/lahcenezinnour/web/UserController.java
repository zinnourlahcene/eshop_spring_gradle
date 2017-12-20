package com.lahcenezinnour.web;

import com.lahcenezinnour.domain.Users;
import com.lahcenezinnour.service.UserService;
import com.lahcenezinnour.util.Login;
import com.lahcenezinnour.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by lahcen on 4/4/17.
 */
@Controller
public class UserController {

    private final UserValidator userValidator;

    private final UserService userService;

    @Autowired
    public UserController(UserValidator userValidator, UserService userService) {
        this.userValidator = userValidator;
        this.userService = userService;
    }

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String index(Model model) {
        System.out.println("+++++++++++++++ index +++++++++++");
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginGET(Model model) {
        System.out.println("+++++++++++++++ login get+++++++++++");
        model.addAttribute("addUserLogin", new Users());
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginPOST(@ModelAttribute("addUserLogin") Users user, Model model) {
        Login login = userService.login(user.getUserEmail(), user.getUserPassword());
        System.out.println("+++++++++++++++ login post+++++++++++" + login.getLogin() + "++++ msg = "+  login.getMessage());
        if (login.getLogin()) {
            return "redirect:index";
        } else {
            model.addAttribute("Login", login);
            return "login";
        }
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signupGET(Model model) {
        System.out.println("+++++++++++++++ signup get +++++++++++");
        model.addAttribute("signup", new Users());
        return "signup";

    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signupPOST(@ModelAttribute("signup") Users user, BindingResult bindingResult) {
        System.out.println("+++++++++++++++ signup post +++++++++++"+bindingResult.getAllErrors());
        userValidator.validate(user, bindingResult);
        if(bindingResult.hasErrors())
            return "signup";
        userService.save(user);
        return "redirect:login";
    }

    @RequestMapping(value = "/xxx", method = RequestMethod.GET)
    public String xxxGET(Model model) {
        System.out.println("+++++++++++++++ xxx get +++++++++++");
        model.addAttribute("command", new Users());
        return "xxx";

    }
}
