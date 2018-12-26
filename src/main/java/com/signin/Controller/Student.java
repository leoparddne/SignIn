package com.signin.Controller;

import com.signin.service.impl.ICodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @author: time:12/25/2018
 * des:
 */
@Controller
@RequestMapping("/Student")
public class Student {
    @Autowired
    ICodeService codeService;
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String Login()
    {
        return "/Student/index";
    }

    @RequestMapping(value = "/Signin",method = RequestMethod.GET)
    public String Signin()
    {
        return "/Student/gen";
    }
    @     RequestMapping(value = "/Signining",method = RequestMethod.GET)
    public String Signining(@RequestParam(required = false) String code,
                            HttpSession session)
    {
        try {
            if(code.trim()=="")
            {
                return "/Student/gen";
            }
            else
            {
                int  userid = (int)session.getAttribute("user");
                if(codeService.SignIn(userid,code))
                {
                    return "redirect:/Student/success";
                }
                else
                {
                    return "redirect:/Student/gen?error";
                }
            }
        }
        catch (Exception e)
        {
            return "redirect:/";
        }
    }
    @RequestMapping(value = "/success",method = RequestMethod.GET)
    public String success()
    {
        return "/Student/success";
    }
}
