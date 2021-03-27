package com.couplesocial.beans.packaged;

import java.util.List;

public class ItemAvailableGroup {
    public ItemAvailableGroup(String itemgroupname, List<String> itemmenus, String groupactionname) {
        this.itemgroupname = itemgroupname;
        this.itemmenus = itemmenus;
        this.groupactionname = groupactionname;
    }

    String itemgroupname;
    List<String> itemmenus;
    String groupactionname;

    public String getItemgroupname() {
        return itemgroupname;
    }

    public void setItemgroupname(String itemgroupname) {
        this.itemgroupname = itemgroupname;
    }

    public List<String> getItemmenus() {
        return itemmenus;
    }

    public void setItemmenus(List<String> itemmenus) {
        this.itemmenus = itemmenus;
    }

    public String getGroupactionname() {
        return groupactionname;
    }

    public void setGroupactionname(String groupactionname) {
        this.groupactionname = groupactionname;
    }
}
