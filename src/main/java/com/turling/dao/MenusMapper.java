package com.turling.dao;

import com.turling.entity.Menus;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MenusMapper {
    /**
     * 查询所有一级菜单
     * @return
     */
    @Select("select * from menus where pid=0")
    public List<Menus> findAll();

    @Select("select * from menus where pid=#{id}")
    public List<Menus> findById(Integer id);
}
