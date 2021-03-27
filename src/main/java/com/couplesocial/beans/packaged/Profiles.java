package com.couplesocial.beans.packaged;

public class Profiles {
    public Profiles(String member_id, String fname, String mname, String lname, String member_nickname, String profilepic, boolean imageUnavailable) {
        this.member_id = member_id;
        this.fname = fname;
        this.mname = mname;
        this.lname = lname;
        this.member_nickname = member_nickname;
        this.profilepic = profilepic;
        this.imageUnavailable = imageUnavailable;
    }

    String member_id;
    String fname;
    String mname;
    String lname;
    String member_nickname;
    String profilepic;
    boolean imageUnavailable;

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    public boolean isImageUnavailable() {
        return imageUnavailable;
    }

    public void setImageUnavailable(boolean imageUnavailable) {
        this.imageUnavailable = imageUnavailable;
    }

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
