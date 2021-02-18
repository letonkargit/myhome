package com.myhome.beans;

import org.springframework.data.annotation.Id;

public class CoupleMembers {
    public CoupleMembers(String member_id, String member_name_id, String member_email_id, String member_phone, String member_verified, String member_nickname) {
        this.member_id = member_id;
        this.member_name_id = member_name_id;
        this.member_email_id = member_email_id;
        this.member_phone = member_phone;
        this.member_verified = member_verified;
        this.member_nickname = member_nickname;
    }

    @Id String id;
    String member_id;
    String member_name_id;
    String member_email_id;
    String member_phone;
    String member_verified;
    String member_nickname;//Husband/Wife or partner1/partner2 or ../..

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    public String getMember_name_id() {
        return member_name_id;
    }

    public void setMember_name_id(String member_name_id) {
        this.member_name_id = member_name_id;
    }

    public String getMember_email_id() {
        return member_email_id;
    }

    public void setMember_email_id(String member_email_id) {
        this.member_email_id = member_email_id;
    }

    public String getMember_phone() {
        return member_phone;
    }

    public void setMember_phone(String member_phone) {
        this.member_phone = member_phone;
    }

    public String getMember_verified() {
        return member_verified;
    }

    public void setMember_verified(String member_verified) {
        this.member_verified = member_verified;
    }

    public String getMember_nickname() {
        return member_nickname;
    }

    public void setMember_nickname(String member_nickname) {
        this.member_nickname = member_nickname;
    }
}
