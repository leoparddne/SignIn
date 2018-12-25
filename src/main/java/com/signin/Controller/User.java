package com.signin.Controller;

import com.signin.UserType;
import com.signin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 *  time:12/23/2018
 * des:
 */
//@RestController
@Controller
@RequestMapping("/User")
public class User {
    @Autowired
    private UserService userService;

//    @GetMapping( "    /Login")
    @RequestMapping(value = "/Login",method = RequestMethod.POST)
    public String Login(@RequestParam(value = "username", required = true) String username,
                        @RequestParam(value = "password", required = true) String password,
                        Model model)
    {

        String f=userService.Login(username,password, UserType.Student);

        model.addAttribute("username",username+password);
        model.addAttribute("password",f);
        return  f;
    }
}
