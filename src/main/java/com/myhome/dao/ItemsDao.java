package com.myhome.dao;

import com.myhome.beans.Items;
import com.myhome.common.dao.CommonDao;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import static com.myhome.common.constants.TableConstants.*;
import static com.myhome.common.constants.ColumnNameConstants.*;

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

    //Insert statements
    public void insertItem(Items items){
        mongoTemplate.insert(items, CS_ITEMS);
    }
}
