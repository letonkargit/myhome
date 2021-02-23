package com.myhome.dao;

import com.myhome.beans.CoupleMembers;
import com.myhome.beans.Items;
import com.myhome.beans.MemberName;
import com.myhome.beans.Users;
import com.myhome.common.dao.CommonDao;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import static com.myhome.common.constants.TableConstants.*;
import static com.myhome.common.constants.ColumnNameConstants.*;

@Service
public class UserDao extends CommonDao {

    //Fetch statements
    public Users fetchUserFromUIDnPwd(String uid, String pwd){
        Query query = new Query();
        query.addCriteria(Criteria.where(USERNAME).is(uid).andOperator(Criteria.where(PASSWORD).is(pwd)));
        return mongoTemplate.findOne(query, Users.class, CS_USERS);
    }
    //Insert statements
    public MemberName insertMemberName(MemberName memberName){
        return mongoTemplate.insert(memberName, CS_MEMBER_NAME);
    }

    public CoupleMembers insertCoupleMember(CoupleMembers coupleMembers){
        return mongoTemplate.insert(coupleMembers, CS_MEMBERS);
    }

    public Users insertUser(Users users) {
        return mongoTemplate.insert(users, CS_USERS);
    }
}
