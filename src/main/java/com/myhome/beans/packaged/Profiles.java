package com.myhome.beans.packaged;

public class Profiles {
    public Profiles(String fname, String mname, String lname, String member_nickname, String profilepic) {
        this.fname = fname;
        this.mname = mname;
        this.lname = lname;
        this.member_nickname = member_nickname;
        this.profilepic = profilepic;
    }

    String fname;
    String mname;
    String lname;
    String member_nickname;
    String profilepic;

    public String getProfilepic() {
        return profilepic;
    }

    public void setProfilepic(String profilepic) {
        this.profilepic = profilepic;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getMember_nickname() {
        return member_nickname;
    }

    public void setMember_nickname(String member_nickname) {
        this.member_nickname = member_nickname;
    }
}
