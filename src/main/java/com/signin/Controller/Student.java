package com.signin.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author: time:12/25/2018
 * des:
 */
@Controller
@RequestMapping("/Student")
public class Student {
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String Login()
    {
        return "/Student/index";
    }
}
