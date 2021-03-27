package com.couplesocial.dao;

import com.couplesocial.beans.CoupleMembers;
import com.couplesocial.beans.MemberName;
import com.couplesocial.beans.Users;
import com.couplesocial.common.dao.CommonDao;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import static com.couplesocial.common.constants.TableConstants.*;
import static com.couplesocial.common.constants.ColumnNameConstants.*;

@Service
public class UserDao extends CommonDao {

    //Fetch statements
    public Users fetchUserFromUIDnPwd(String uid, String pwd){
        Query query = new Query();
        query.addCriteria(Criteria.where(USERNAME).is(uid).andOperator(Criteria.where(PASSWORD).is(pwd)));
        return mongoTemplate.findOne(query, Users.class, CS_USERS);
    }

    public Users fetchUserFromUID(String uid){
        Query query = new Query();
        query.addCriteria(Criteria.where(USERNAME).is(uid));
        return mongoTemplate.findOne(query, Users.class, CS_USERS);
    }

    public MemberName fetchMemberNameFromId(String member_id){
        Query query = new Query();
        query.addCriteria(Criteria.where(_ID).is(new ObjectId(member_id)));
        return mongoTemplate.findOne(query, MemberName.class, CS_MEMBER_NAME);
    }

    public CoupleMembers fetchCoupleMembersNameFromId(String member_id){
        Query query = new Query();
        query.addCriteria(Criteria.where(MEMBER_ID).is(member_id));
        return mongoTemplate.findOne(query, CoupleMembers.class, CS_MEMBERS);
    }
    //Update statements
    public void updateProfileMemberId(String member_id, String proffilename){
        Query query = new Query();
        query.addCriteria(Criteria.where(MEMBER_ID).is(member_id));

        Update update = new Update();
        update.set(MEMBER_PROFILEPIC, proffilename);

        mongoTemplate.updateFirst(query, update, CoupleMembers.class, CS_MEMBERS);
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
