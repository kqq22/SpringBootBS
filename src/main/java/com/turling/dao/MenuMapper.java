package com.turling.dao;

import com.turling.entity.Menu;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MenuMapper {
    /**
     * 查询所有的一级菜单
     * @return
     */
    @Select("select * from menu where pid=0")
    public List<Menu> findAll();

    /**
     * 查询子菜单
     * @param id
     * @return
     */
    @Select("select * from menu where pid=#{id}")
    public List<Menu> findById(Integer id);

    /**
     * 查询所有菜单
     * @return
     */
    @Select("select * from menu")
    public List<Menu> findAllMenu();
}
