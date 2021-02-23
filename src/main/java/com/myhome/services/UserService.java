package com.myhome.services;

import com.myhome.beans.CoupleMembers;
import com.myhome.beans.MemberName;
import com.myhome.beans.Users;
import com.myhome.dao.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class UserService {
    @Autowired UserDao userDao;
    Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public boolean isValidUser(String userLoggedIn) {
        if(userLoggedIn != null && !userLoggedIn.isEmpty()) {
            return true;
        }
        return false;
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
                request.getParameter("member1_betterhalf"));
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
                request.getParameter("member2_betterhalf"));
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
