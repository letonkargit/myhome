package com.couplesocial.services;

import com.couplesocial.beans.packaged.BaseMenu;
import com.couplesocial.beans.packaged.Menus;
import com.couplesocial.dao.MenuDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class MenuService {
    @Autowired MenuDao menuDao;
    Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public List<BaseMenu> fetchBaseMenus() {
        Integer parent_id = 0;//0 is for base menu id
        logger.info("pulling menu id for parent id - {}", parent_id);

        List<BaseMenu> baseMenus = new ArrayList<>();
        Map<String, List<Menus>> menusMap = new HashMap<>();
        menuDao.fetchCommonMenus(parent_id).forEach(x -> {
            if(menusMap.get(x.getCategory()) != null){
                menusMap.get(x.getCategory()).add(new Menus(x.getMenu_id(), x.getMenu_name(), x.getMenu_text(),x.getMenu_action() ));
            } else {
                List<Menus> menus = new ArrayList<>();
                menus.add(new Menus(x.getMenu_id(), x.getMenu_name(), x.getMenu_text(),x.getMenu_action()));
                menusMap.put(x.getCategory(), menus);
            }
        });

        for(String category : menusMap.keySet()){
            logger.info("base category - {}",category);
            logger.info("menus under category - {}", menusMap.get(category));
            baseMenus.add(new BaseMenu(category, menusMap.get(category)));
        }

        return baseMenus;
    }
}
