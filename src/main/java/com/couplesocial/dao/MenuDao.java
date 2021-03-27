package com.couplesocial.dao;

import com.couplesocial.beans.CommonMenu;
import com.couplesocial.common.dao.CommonDao;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import static com.couplesocial.common.constants.TableConstants.*;
import static com.couplesocial.common.constants.ColumnNameConstants.*;
import static com.couplesocial.common.constants.ColumnValueConstant.*;

@Service
public class MenuDao extends CommonDao {

    public List<CommonMenu> fetchCommonMenus(Integer parent_id){
        Query query = new Query();
        query.addCriteria(Criteria.where(PARENT_ID).is(parent_id));
        query.addCriteria(Criteria.where(CS_COMMON_MENU_STATUS).is(CS_COMMON_MENU_ENABLED));

        return mongoTemplate.find(query, CommonMenu.class, CS_COMMON_MENU);
    }
}
