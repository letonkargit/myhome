package com.myhome.services;

import com.myhome.beans.Items;
import com.myhome.dao.ItemsDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemsService {
    @Autowired ItemsDao itemsDao;
    Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public void saveItem(Items items) {
        logger.info("Inserting item - {}",items.toString());
        itemsDao.insertItem(items);
    }

    public List<Items>  fetchAllItems(String username) {
        return itemsDao.fetchAllItems(username);
    }
}
