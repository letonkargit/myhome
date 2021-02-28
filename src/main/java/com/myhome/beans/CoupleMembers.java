package com.myhome.beans;

import org.springframework.data.annotation.Id;

public class CoupleMembers {
    public CoupleMembers(String member_id, String member_email_id, String member_phone, String member_dob, String member_gender, String member_verified, String member_nickname, String member_profilepic) {
        this.member_id = member_id;
        this.member_email_id = member_email_id;
        this.member_phone = member_phone;
        this.member_dob = member_dob;
        this.member_gender = member_gender;
        this.member_verified = member_verified;
        this.member_nickname = member_nickname;
        this.member_profilepic = member_profilepic;
    }

    @Id String id;
    String member_id; //Mapped to id of MemberName
    String member_email_id;
    String member_phone;
    String member_dob;
    String member_gender;
    String member_verified;
    String member_nickname;//Husband/Wife or partner1/partner2 or ../..
    String member_profilepic;

    public String getMember_profilepic() {
        return member_profilepic;
    }

    public void setMember_profilepic(String member_profilepic) {
        this.member_profilepic = member_profilepic;
    }

    public String getMember_dob() {
        return member_dob;
    }

    public void setMember_dob(String member_dob) {
        this.member_dob = member_dob;
    }

    public String getMember_gender() {
        return member_gender;
    }

    public void setMember_gender(String member_gender) {
        this.member_gender = member_gender;
    }

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
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
