package com.turling.service.impl;

import com.turling.dao.MenuMapper;
import com.turling.entity.Attributes;
import com.turling.entity.Menu;
import com.turling.service.MenuService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
@Service
public class MenuServiceImpl implements MenuService {
    @Resource
    private MenuMapper menuMapper;

    @Override
    public List<Menu> findAll() {
        List<Menu> list = menuMapper.findAll();
        for(Menu m:list){
            m.setChildren(menuMapper.findById(m.getId()));
        }
        return list;
    }

    @Override
    public List<Menu> findMenu() {
        return getParentNode(menuMapper.findAllMenu());
    }

    /**
     * 根据节点集合获得所有父节点为pid的节点，并且都设置了子节点
     * @param list 所有菜单集合
     * @return
     */
    private List<Menu> getParentNode(List<Menu> list){
        List<Menu> parentList = new ArrayList<>();
        for (Menu m:list){
            if (m.getPid()==0){
                //获取父节点下的子节点，根据父节点递归调用获取所有子节点
                m.setChildren(getChildrenNode(m.getId(),list));
                parentList.add(m);
            }
        }
        return parentList;
    }

    /**
     * 递归调用
     * @param pid 父节点
     * @param list 要循环的集合
     * @return
     */
    private List<Menu> getChildrenNode(int pid, List<Menu> list){
        List<Menu> findChildrenList = new ArrayList<Menu>();
        //循环传入的集合
        for (Menu m:list){
            if (m.getId()==0){//父节点
                continue;
            }
            if (m.getPid()==pid){
                //根据父id找到子节点，加入到子节点集合中
                Attributes attributes=new Attributes();
                attributes.setUrl(m.getUrl());
                attributes.setIcon(m.getIcon()); 
                m.setAttributes(attributes);
                findChildrenList.add(m);
                //设置子节点集合，递归调用
                m.setChildren(getChildrenNode(m.getId(),list));
            }
        }
        return findChildrenList;
    }
}
