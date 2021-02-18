package com.myhome.beans;

import org.springframework.data.annotation.Id;

public class MemberName {
    public MemberName(String member_name_id, String member_fname, String member_mname, String member_lname) {
        this.member_name_id = member_name_id;
        this.member_fname = member_fname;
        this.member_mname = member_mname;
        this.member_lname = member_lname;
    }

    @Id String id;
    String member_name_id;
    String member_fname;
    String member_mname;
    String member_lname;

    public String getMember_name_id() {
        return member_name_id;
    }

    public void setMember_name_id(String member_name_id) {
        this.member_name_id = member_name_id;
    }

    public String getMember_fname() {
        return member_fname;
    }

    public void setMember_fname(String member_fname) {
        this.member_fname = member_fname;
    }

    public String getMember_mname() {
        return member_mname;
    }

    public void setMember_mname(String member_mname) {
        this.member_mname = member_mname;
    }

    public String getMember_lname() {
        return member_lname;
    }

    public void setMember_lname(String member_lname) {
        this.member_lname = member_lname;
    }
}
