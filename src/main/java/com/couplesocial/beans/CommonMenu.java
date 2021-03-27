package com.couplesocial.beans;

import org.springframework.data.annotation.Id;

public class CommonMenu {
    public CommonMenu(String category, Integer parent_id, Integer menu_id, String menu_action, String menu_name, String menu_text) {
        this.category = category;
        this.parent_id = parent_id;
        this.menu_id = menu_id;
        this.menu_action = menu_action;
        this.menu_name = menu_name;
        this.menu_text = menu_text;
    }

    @Id String id;
    String category;
    Integer parent_id;
    Integer menu_id;
    String menu_action;
    String menu_name;
    String menu_text;

    public String getMenu_action() {
        return menu_action;
    }

    public void setMenu_action(String menu_action) {
        this.menu_action = menu_action;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getParent_id() {
        return parent_id;
    }

    public void setParent_id(Integer parent_id) {
        this.parent_id = parent_id;
    }

    public Integer getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(Integer menu_id) {
        this.menu_id = menu_id;
    }

    public String getMenu_name() {
        return menu_name;
    }

    public void setMenu_name(String menu_name) {
        this.menu_name = menu_name;
    }

    public String getMenu_text() {
        return menu_text;
    }

    public void setMenu_text(String menu_text) {
        this.menu_text = menu_text;
    }
}
