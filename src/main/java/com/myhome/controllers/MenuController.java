package com.myhome.controllers;

import com.myhome.beans.Items;
import com.myhome.dao.MenuDao;
import com.myhome.services.ItemsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class MenuController {
    Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    @Autowired MenuDao menuDao;
    @Autowired ItemsService itemsService;

    @RequestMapping(value= {"/getmenus"}, method={ RequestMethod.POST, RequestMethod.GET})
    public String getmenus(HttpServletRequest request,
                       HttpServletResponse response, Model model){

        return "userhome";
    }

    @RequestMapping(value= {"/geteatableitems"}, method={ RequestMethod.POST, RequestMethod.GET})
    public String getEatables(HttpServletRequest request,
                           HttpServletResponse response, Model model){

        String userid = request.getParameter("user");
        List<Items> itemsList = itemsService.fetchAllItems(userid);
        itemsList.stream().forEach(x -> {
            logger.info("Item : {} ",x.getItem_desc());
        });
        model.addAttribute("items", itemsList);

        return "menus/eatableitems";
    }

    @RequestMapping(value= {"/getgroceryitems"}, method={ RequestMethod.POST, RequestMethod.GET})
    public String getGrocery(HttpServletRequest request,
                              HttpServletResponse response, Model model){

        return "menus/groceryitems";
    }

    @RequestMapping(value= {"/ourfoodplan"}, method={ RequestMethod.POST, RequestMethod.GET})
    public String getFoodplan(HttpServletRequest request,
                             HttpServletResponse response, Model model){

        return "menus/foodplan";
    }

    @RequestMapping(value= {"/kitchendecorideas"}, method={ RequestMethod.POST, RequestMethod.GET})
    public String getKitchendecor(HttpServletRequest request,
                             HttpServletResponse response, Model model){

        return "menus/kitchendecor";
    }
}
