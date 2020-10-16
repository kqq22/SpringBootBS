package com.turling.controller;

import com.turling.entity.Menus;
import com.turling.service.MenusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MenusController {
    @Autowired
    private MenusService menusService;

    @RequestMapping("showMenus")
    @ResponseBody
    public List<Menus> showMenus(){
        return menusService.findAll();
    }
}
