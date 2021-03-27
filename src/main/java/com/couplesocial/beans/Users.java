package com.couplesocial.beans;

import org.springframework.data.annotation.Id;

public class Users {
    public Users(String cs_username, String cs_password, String cs_member_1_id, String cs_member_2_id) {
        this.cs_username = cs_username;
        this.cs_password = cs_password;
        this.cs_member_1_id = cs_member_1_id;
        this.cs_member_2_id = cs_member_2_id;
    }

    @Id String id;
    String cs_username;
    String cs_password;
    String cs_member_1_id;
    String cs_member_2_id;

    public String getCs_username() {
        return cs_username;
    }

    public void setCs_username(String cs_username) {
        this.cs_username = cs_username;
    }

    public String getCs_password() {
        return cs_password;
    }

    public void setCs_password(String cs_password) {
        this.cs_password = cs_password;
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