package com.myhome.beans;

import org.springframework.data.annotation.Id;

public class Users {
    public Users(String username, String password, String cs_member_1_id, String cs_member_2_id) {
        this.username = username;
        this.password = password;
        this.cs_member_1_id = cs_member_1_id;
        this.cs_member_2_id = cs_member_2_id;
    }

    @Id String id;
    String username;
    String password;
    String cs_member_1_id;
    String cs_member_2_id;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCs_member_1_id() {
        return cs_member_1_id;
    }

    public void setCs_member_1_id(String cs_member_1_id) {
        this.cs_member_1_id = cs_member_1_id;
    }

    public String getCs_member_2_id() {
        return cs_member_2_id;
    }

    public void setCs_member_2_id(String cs_member_2_id) {
        this.cs_member_2_id = cs_member_2_id;
    }
}