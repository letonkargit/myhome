package com.myhome.services;

import com.myhome.beans.CoupleMembers;
import com.myhome.beans.MemberName;
import com.myhome.beans.Users;
import com.myhome.beans.packaged.Profiles;
import com.myhome.common.config.CommonConfig;
import com.myhome.dao.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserService {
    @Autowired UserDao userDao;
    @Autowired CommonConfig commonConfig;
    Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public boolean isValidUser(String userLoggedIn) {
        if(userLoggedIn != null && !userLoggedIn.isEmpty()) {
            return true;
        }
        return false;
    }

    public List<Profiles> fetchMembers(String userLoggedIn) {
        List<Profiles> profiles = new ArrayList<>();
        Users user = userDao.fetchUserFromUID(userLoggedIn);

        MemberName memberName1 = userDao.fetchMemberNameFromId(user.getCs_member_1_id());
        CoupleMembers coupleMembers1 = userDao.fetchCoupleMembersNameFromId(user.getCs_member_1_id());
        Profiles profiles1 = new Profiles(
                memberName1.getMember_fname(),
                memberName1.getMember_mname(),
                memberName1.getMember_lname(),
                coupleMembers1.getMember_nickname(),
                setImage(coupleMembers1.getMember_gender(), coupleMembers1.getMember_profilepic())
        );
        logger.info("Image path {}", setImage(coupleMembers1.getMember_gender(), coupleMembers1.getMember_profilepic()));
        profiles.add(profiles1);

        MemberName memberName2 = userDao.fetchMemberNameFromId(user.getCs_member_2_id());
        CoupleMembers coupleMembers2 = userDao.fetchCoupleMembersNameFromId(user.getCs_member_2_id());
        Profiles profiles2 = new Profiles(
                memberName2.getMember_fname(),
                memberName2.getMember_mname(),
                memberName2.getMember_lname(),
                coupleMembers2.getMember_nickname(),
                setImage(coupleMembers2.getMember_gender(), coupleMembers2.getMember_profilepic())
        );
        logger.info("Image path {}", setImage(coupleMembers2.getMember_gender(), coupleMembers2.getMember_profilepic()));
        profiles.add(profiles2);

        return profiles;
    }

    private String setImage(String member_gender, String profilepic) {
        if(profilepic != null) {
            return commonConfig.getImagesPath()+profilepic;
        } else {
            if (member_gender.equalsIgnoreCase("Male")) {
                return commonConfig.getImagesPath()+"male.png";
            } else if (member_gender.equalsIgnoreCase("Female")) {
                return commonConfig.getImagesPath()+"female.png";
            }
            return commonConfig.getImagesPath()+"noimage";
        }
    }

    public Users registerUser(HttpServletRequest request){
        logger.info("Registering member 1 :");
        //Member 1 name
        String member1_fn = request.getParameter("member1_fn");
        String member1_mn = request.getParameter("member1_mn");
        String member1_ln = request.getParameter("member1_ln");
        MemberName memberName1 = new MemberName(member1_fn, member1_mn, member1_ln);
        memberName1 = userDao.insertMemberName(memberName1);

        CoupleMembers coupleMembers1 = new CoupleMembers(memberName1.getId(),
                request.getParameter("member1_email"),
                request.getParameter("member1_phone"),
                request.getParameter("member1_dob_mm") + "/" + request.getParameter("member1_dob_dd") + "/" +request.getParameter("member1_dob_yyyy"),
                request.getParameter("member1_gender"),
                "no",
                request.getParameter("member1_betterhalf"),
                null);//Set profile pic string
        coupleMembers1 = userDao.insertCoupleMember(coupleMembers1);

        logger.info("Registering member 2 :");
        //Member 2 name
        String member2_fn = request.getParameter("member2_fn");
        String member2_mn = request.getParameter("member2_mn");
        String member2_ln = request.getParameter("member2_ln");
        MemberName memberName2 = new MemberName(member2_fn, member2_mn, member2_ln);
        memberName2 = userDao.insertMemberName(memberName2);

        CoupleMembers coupleMembers2 = new CoupleMembers(memberName2.getId(),
                request.getParameter("member2_email"),
                request.getParameter("member2_phone"),
                request.getParameter("member2_dob_mm") + "/" + request.getParameter("member2_dob_dd") + "/" +request.getParameter("member2_dob_yyyy"),
                request.getParameter("member2_gender"),
                "no",
                request.getParameter("member2_betterhalf"),
                null);//Set profile pic string
        coupleMembers2 = userDao.insertCoupleMember(coupleMembers2);

        logger.info("Attaching both members");
        Users users = new Users(request.getParameter("couple_uid"), request.getParameter("memebers_pwd"),
                memberName1.getId(), memberName2.getId());
        users = userDao.insertUser(users);
        return users;
    }

    public boolean authenticate(String userid, String password) {
        Users users = userDao.fetchUserFromUIDnPwd(userid, password);
        if(users != null){
            return true;
        }
        return false;
    }
}
