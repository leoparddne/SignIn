package com.signin.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: time:12/24/2018
 * des:
 */
@RequestMapping("/")
public class Home {
    public String index()
    {
        return "/index";
    }
}
