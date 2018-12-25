package com.signin.Controller;

import com.signin.UserType;
import com.signin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
                         HttpServletRequest request
//                        Model model)
    )
    {

        String result=userService.Login(username,password, UserType.Student);
        HttpSession session = request.getSession();
        session.setAttribute("user",username);
//        model.addAttribute("username",username+password);
//        model.addAttribute("password",f);
        return  "redirect:"+result;
    }
}
