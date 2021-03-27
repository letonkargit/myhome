package com.couplesocial.services;

import com.couplesocial.beans.Items;
import com.couplesocial.beans.packaged.ItemAvailableGroup;
import com.couplesocial.dao.ItemsDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import static com.couplesocial.common.constants.ColumnNameConstants.*;

import java.util.ArrayList;
import java.util.List;

@Component
public class ItemsService {
    @Autowired ItemsDao itemsDao;
    Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public void saveItem(Items items) {
        logger.info("Inserting item - {}",items.toString());
        itemsDao.insertItem(items);
    }

    public List<Items> fetchAllItems(String username) {
        return itemsDao.fetchAllItems(username);
    }

    public List<Items> fetchItemsByItemType(String username, String itemtype) {
        return itemsDao.fetchItemsByItemType(username, ITEM_TYPE, itemtype);
    }

    public List<Items> fetchItemsByEatTime(String username, String eattime) {
        return itemsDao.fetchItemsByItemType(username, ITEM_EAT_TIME, eattime);
    }

    public List<Items> fetchItemsByLocation(String username, String location) {
        return itemsDao.fetchItemsByItemType(username, ITEM_LOCATION, location);
    }

    public List<Items> fetchItemsByOP(String username, String openedpacked) {
        return itemsDao.fetchItemsByItemType(username, ITEM_IS_OPENED, openedpacked);
    }

    public List<ItemAvailableGroup> groupItemsForEasyAccess(String userid) {
        List<ItemAvailableGroup> itemAvailableGroups = new ArrayList<>();

        //By type
        ItemAvailableGroup itemAvailableGroup = new ItemAvailableGroup(
                "By Type", itemsDao.fetchItemsByType(userid, ITEM_TYPE), "getitemsbytype"
        );
        itemAvailableGroups.add(itemAvailableGroup);

        //By Eat/Drink Time
        ItemAvailableGroup itemAvailableGroupEattime = new ItemAvailableGroup(
                "By Good time to eat", itemsDao.fetchItemsByType(userid, ITEM_EAT_TIME), "getitemsbyeattime"
        );
        itemAvailableGroups.add(itemAvailableGroupEattime);

        //By where have you kept
        ItemAvailableGroup itemAvailableGroupLocation = new ItemAvailableGroup(
                "By where have you kept", itemsDao.fetchItemsByType(userid, ITEM_LOCATION),"getitemsbylocation"
        );
        itemAvailableGroups.add(itemAvailableGroupLocation);

        //By opened/packed
        ItemAvailableGroup itemAvailableGroupOpened = new ItemAvailableGroup(
                "By Opened/Packed", itemsDao.fetchItemsByType(userid, ITEM_IS_OPENED), "getitemsbyeatop"
        );
        itemAvailableGroups.add(itemAvailableGroupOpened);

        return itemAvailableGroups;
    }
}
