package com.dpf.service;


import com.dpf.bean.Menu;
import com.dpf.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author 江南一点雨
 * @Site www.javaboy.org 2019-08-11 17:26
 */
@Service
public class MenuService {
    @Autowired
    MenuMapper menuMapper;
    public List<Menu> getAllMenus() {
        return menuMapper.getAllMenus();
    }
}
