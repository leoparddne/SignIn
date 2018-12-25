package com.signin.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Random;

/**
 * @author: time:12/25/2018
 * des:
 */
@Controller
@RequestMapping("/Teacher")
public class Teacher {
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String Login()
    {
        return "/Teacher/index";
    }
    @RequestMapping(value = "/Accounts",method = RequestMethod.GET)
    public String Accounts()
    {
        return "/Teacher/accounts";
    }
    @RequestMapping(value = "/Gen",method = RequestMethod.GET)
    public String Gen(Model model)
    {
        int code=(int)((Math.random()*9+1)*1000);
        model.addAttribute("code",code);
        return "/Teacher/Gen";
    }
}
