package com.signin.Controller;

import com.signin.model.signin;
import com.signin.service.impl.ICodeService;
import com.signin.service.impl.ISignInService;
import com.signin.service.impl.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Random;

/**
 * @author: time:12/25/2018
 * des:
 */
@Controller
@RequestMapping("/Teacher")
public class Teacher {
    @Autowired
    private ICodeService codeService;
    @Autowired
    private ISignInService signInService;

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
    public String Gen(HttpSession session, Model model)
    {
        try
        {
            int  userid = (int)session.getAttribute("user");
            int code=(int)((Math.random()*9+1)*1000);
            if(codeService.SaveCode(userid,String.valueOf(code)))
            {
                model.addAttribute("code",code);
            }
            else
            {
                model.addAttribute("code","err:生成过程发生错误,请联系管理员!");
            }
        }
        catch (Exception e)
        {
            return "redirect:/";
        }
        return "/Teacher/Gen";
    }

    @RequestMapping(value = "/GetLatestData",method = RequestMethod.GET)
    public  String GetLatestData(@RequestParam(required = false) String code, Model model)
    {
        try
        {
            if(code==null)
            {
                return "/Teacher/GetLatestData";
            }
            if(code.trim()=="")
            {
                return "/Teacher/GetLatestData";
            }
            List<signin> data=signInService.GetLeastData(code);
            model.addAttribute("data",data);
            return "/Teacher/GetLatestData";
        }
        catch (Exception e)
        {
            return "redirect:/Teacher/index";
        }
    }
}
