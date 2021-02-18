package com.myhome.beans;

import org.springframework.data.annotation.Id;

public class Items {
    public Items(String username, String item_type, String item_name, String item_desc, String item_eat_time, String item_exp_date, String item_location, String is_opened) {
        this.username = username;
        this.item_type = item_type;
        this.item_name = item_name;
        this.item_desc = item_desc;
        this.item_eat_time = item_eat_time;
        this.item_exp_date = item_exp_date;
        this.item_location = item_location;
        this.is_opened = is_opened;
    }

    @Id String id;
    String username;
    Integer item_id;
    String item_type;
    String item_name;
    String item_desc;
    String item_eat_time;
    String item_exp_date;
    String item_location;
    String is_opened;

    public Integer getItem_id() {
        return item_id;
    }

    public void setItem_id(Integer item_id) {
        this.item_id = item_id;
    }

    public String getItem_type() {
        return item_type;
    }

    public void setItem_type(String item_type) {
        this.item_type = item_type;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getItem_desc() {
        return item_desc;
    }

    public void setItem_desc(String item_desc) {
        this.item_desc = item_desc;
    }

    public String getItem_eat_time() {
        return item_eat_time;
    }

    public void setItem_eat_time(String item_eat_time) {
        this.item_eat_time = item_eat_time;
    }

    public String getItem_exp_date() {
        return item_exp_date;
    }

    public void setItem_exp_date(String item_exp_date) {
        this.item_exp_date = item_exp_date;
    }

    public String getItem_location() {
        return item_location;
    }

    public void setItem_location(String item_location) {
        this.item_location = item_location;
    }

    public String getIs_opened() {
        return is_opened;
    }

    public void setIs_opened(String is_opened) {
        this.is_opened = is_opened;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
