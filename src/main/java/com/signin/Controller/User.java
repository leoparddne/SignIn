package com.signin.Controller;

import com.signin.UserType;
import com.signin.model.Data.UserInfo;
import com.signin.service.UserService;
import com.signin.service.impl.IUserService;
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
    private IUserService userService;

//    @GetMapping( "    /Login")
    @RequestMapping(value = "/Login",method = RequestMethod.POST)
    public String Login(@RequestParam(value = "username", required = true) String username,
                        @RequestParam(value = "password", required = true) String password,
                         HttpServletRequest request
//                        Model model)
    )
    {
        UserInfo user=new UserInfo();
        String result=userService.Login(username,password, user);
        HttpSession session = request.getSession();
        session.setAttribute("user",user.userID);
//        model.addAttribute("username",username+password);
//        model.addAttribute("password",f);
        return  "redirect:"+result;
    }
}
