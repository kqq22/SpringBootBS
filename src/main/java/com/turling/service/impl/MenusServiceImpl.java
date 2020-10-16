package com.turling.service.impl;

import com.turling.dao.MenusMapper;
import com.turling.entity.Menus;
import com.turling.service.MenusService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class MenusServiceImpl implements MenusService {
    @Resource
    private MenusMapper menusMapper;

    public List<Menus> findAll(){
        List<Menus> list = menusMapper.findAll();
        for (Menus m:list){
            List<Menus> list1 = menusMapper.findById(m.getId());
            m.setChildren(list1);
            for (Menus m1:list1){
                m1.setChildren(menusMapper.findById(m1.getId()));
            }
        }
        return list;
    }
}
