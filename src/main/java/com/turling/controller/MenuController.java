package com.turling.controller;

import com.turling.entity.Menu;
import com.turling.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MenuController {
    @Autowired
    private MenuService menuService;

    @RequestMapping("/findAll")
    @ResponseBody
    public List<Menu> findAll(){
        List<Menu> list = new ArrayList<>();
        Menu m = new Menu();
        m.setId(1);
        m.setName("系统设置");
        m.setPid(0);
        list.add(m);
        return list;
    }

    @RequestMapping("/showMenu")
    @ResponseBody
    public List<Menu> showMenu(){
        return menuService.findAll();
    }

    @RequestMapping("/getMenu")
    @ResponseBody
    public List<Menu> getMenu(){
        return menuService.findMenu();
    }
}
