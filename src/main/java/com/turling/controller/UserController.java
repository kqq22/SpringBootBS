package com.turling.controller;

import com.turling.entity.User;
import com.turling.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    //@PostMapping("/login")
    @GetMapping("/login")
    @ResponseBody
    public String toLogin(User user, HttpSession session ){
        User u = userService.login(user);
        if (u!=null){
            session.setAttribute("user",u);
            //return "redirect:/index";
            return "success";
        }else {
            //return "redirect:/";
            return "fail";
        }
    }
}
