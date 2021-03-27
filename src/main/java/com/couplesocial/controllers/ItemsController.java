package com.couplesocial.controllers;

import com.couplesocial.beans.Items;
import com.couplesocial.services.ItemsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ItemsController {
    Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    @Autowired ItemsService itemsService;

    @RequestMapping(value= {"/getitemsbytype"}, method={ RequestMethod.POST, RequestMethod.GET})
    public String getitemsbytype(HttpServletRequest request,
                           HttpServletResponse response, Model model){
        String itemtype = request.getParameter("query");
        logger.info("Getting items for item type {}",itemtype);
        String userid = request.getParameter("user");

        model.addAttribute("items", itemsService.fetchItemsByItemType(userid, itemtype));

        model.addAttribute("groupeditems", itemsService.groupItemsForEasyAccess(userid));

        return "menus/eatableitems";
    }

    @RequestMapping(value= {"/getitemsbyeattime"}, method={ RequestMethod.POST, RequestMethod.GET})
    public String getitemsbyeattime(HttpServletRequest request,
                                 HttpServletResponse response, Model model){
        String itemtype = request.getParameter("query");
        logger.info("Getting items for eat time {}",itemtype);
        String userid = request.getParameter("user");

        model.addAttribute("items", itemsService.fetchItemsByEatTime(userid, itemtype));

        model.addAttribute("groupeditems", itemsService.groupItemsForEasyAccess(userid));

        return "menus/eatableitems";
    }

    @RequestMapping(value= {"/getitemsbylocation"}, method={ RequestMethod.POST, RequestMethod.GET})
    public String getitemsbylocation(HttpServletRequest request,
                                    HttpServletResponse response, Model model){
        String itemtype = request.getParameter("query");
        logger.info("Getting items for location {}",itemtype);
        String userid = request.getParameter("user");

        model.addAttribute("items", itemsService.fetchItemsByLocation(userid, itemtype));

        model.addAttribute("groupeditems", itemsService.groupItemsForEasyAccess(userid));

        return "menus/eatableitems";
    }

    @RequestMapping(value= {"/getitemsbyeatop"}, method={ RequestMethod.POST, RequestMethod.GET})
    public String getitemsbyeatop(HttpServletRequest request,
                                    HttpServletResponse response, Model model){
        String itemtype = request.getParameter("query");
        logger.info("Getting items for open packed {}",itemtype);
        String userid = request.getParameter("user");

        model.addAttribute("items", itemsService.fetchItemsByOP(userid, itemtype));

        model.addAttribute("groupeditems", itemsService.groupItemsForEasyAccess(userid));

        return "menus/eatableitems";
    }

    @RequestMapping(path="/saveitem",method= RequestMethod.POST)
    public String saveItem(HttpServletRequest request,
                           HttpServletResponse response, Model model){
        boolean success = false;
        try {
            String userLoggedIn = request.getSession().getAttribute("user") != null ?
                    request.getSession().getAttribute("user").toString() : null;
            Items items = new Items(
                    userLoggedIn,
                    request.getParameter("item_type_hidden"),
                    request.getParameter("item_name_hidden"),
                    request.getParameter("item_desc_hidden"),
                    request.getParameter("item_eattime_hidden"),
                    request.getParameter("item_exp_hidden"),
                    request.getParameter("item_location_hidden"),
                    request.getParameter("item_opened_hidden")
            );

            itemsService.saveItem(items);

            success = true;

            model.addAttribute("items", itemsService.fetchAllItems(userLoggedIn));

            model.addAttribute("groupeditems", itemsService.groupItemsForEasyAccess(userLoggedIn));
        }catch (Exception e){
            e.printStackTrace();
        }

        model.addAttribute("success", success);

        return "menus/eatableitems";
    }
}
