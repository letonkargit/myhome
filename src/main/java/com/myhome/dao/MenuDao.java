package com.myhome.dao;

import com.myhome.beans.CommonMenu;
import com.myhome.common.dao.CommonDao;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import static com.myhome.common.constants.TableConstants.*;
import static com.myhome.common.constants.ColumnNameConstants.*;

@Service
public class MenuDao extends CommonDao {

    public List<CommonMenu> fetchCommonMenus(Integer parent_id){
        Query query = new Query();
        query.addCriteria(Criteria.where(PARENT_ID).is(parent_id));

        return mongoTemplate.find(query, CommonMenu.class, CS_COMMON_MENU);
    }
}
