package com.couplesocial.beans.packaged;

public class Menus {
    public Menus(Integer menu_id, String menu_name, String menu_text, String menu_action) {
        this.menu_id = menu_id;
        this.menu_name = menu_name;
        this.menu_text = menu_text;
        this.menu_action = menu_action;
    }

    Integer menu_id;
    String menu_name;
    String menu_text;
    String menu_action;

    public String getMenu_action() {
        return menu_action;
    }

    public void setMenu_action(String menu_action) {
        this.menu_action = menu_action;
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

    @Override
    public String toString() {
        return "Menus{" +
                "menu_id=" + menu_id +
                ", menu_name='" + menu_name + '\'' +
                ", menu_text='" + menu_text + '\'' +
                ", menu_action='" + menu_action + '\'' +
                '}';
    }
}
