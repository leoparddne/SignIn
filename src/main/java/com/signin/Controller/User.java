package com.signin.Controller;

import com.signin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping( "/Login")
//    @RequestMapping("/Login")
    public String Login(Model model)
    {
        model.addAttribute("title","sss");
        return  "hello";
    }
}
