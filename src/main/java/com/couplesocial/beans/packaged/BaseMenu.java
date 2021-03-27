package com.couplesocial.beans.packaged;

import java.util.List;

public class BaseMenu {
    public BaseMenu(String category, List<Menus> menus) {
        this.category = category;
        this.menus = menus;
    }

    String category;
    List<Menus> menus;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Menus> getMenus() {
        return menus;
    }

    public void setMenus(List<Menus> menus) {
        this.menus = menus;
    }
}
