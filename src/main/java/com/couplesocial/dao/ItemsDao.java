package com.couplesocial.dao;

import com.couplesocial.beans.Items;
import com.couplesocial.common.dao.CommonDao;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import static com.couplesocial.common.constants.TableConstants.*;
import static com.couplesocial.common.constants.ColumnNameConstants.*;

@Service
public class ItemsDao extends CommonDao {

    //Fetch queries
    public List<Items> fetchAllItems(String username){
        List<Items> itemsList = new ArrayList<>();
        Query query = new Query();
        query.addCriteria(Criteria.where(USERNAME).is(username));
        itemsList =  mongoTemplate.find(query, Items.class, CS_ITEMS);
        int id = 0;
        for(Items x : itemsList){
            x.setItem_id(id);
            id++;
        };
        return itemsList;
    }

    public List<String> fetchItemsByType(String username, String field){
        Query query = new Query();
        query.addCriteria(Criteria.where(USERNAME).is(username));
        return mongoTemplate.findDistinct(query, field, CS_ITEMS, Items.class, String.class);
    }

    public List<Items> fetchItemsByItemType(String username, String field, String value) {
        Query query = new Query();
        query.addCriteria(Criteria.where(USERNAME).is(username));
        query.addCriteria(Criteria.where(field).is(value));
        return mongoTemplate.find(query, Items.class, CS_ITEMS);
    }

    //Insert statements
    public void insertItem(Items items){
        mongoTemplate.insert(items, CS_ITEMS);
    }
}
