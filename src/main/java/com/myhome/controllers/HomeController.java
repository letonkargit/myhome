package com.myhome.controllers;

import com.myhome.beans.Items;
import com.myhome.dao.MenuDao;
import com.myhome.services.ItemsService;
import com.myhome.services.MenuService;
import com.myhome.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HomeController {
    @Autowired ItemsService itemsService;
    @Autowired UserService userService;
    @Autowired MenuService menuService;
    Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @RequestMapping(value= {"/home","/" }, method={ RequestMethod.POST, RequestMethod.GET})
    public String home(HttpServletRequest request,
                            HttpServletResponse response, Model model){
        String userLoggedIn = request.getSession().getAttribute("user") != null ?
                request.getSession().getAttribute("user").toString() : null;
        logger.info("user - {}",userLoggedIn);
        if(userService.isValidUser(userLoggedIn)){
            model.addAttribute("menus", menuService.fetchBaseMenus());
            return "userhome";
        } else {
            model.addAttribute("loginfirst","true");
            return "index";
        }
    }

    @RequestMapping(value= "/dashboard" , method={ RequestMethod.POST, RequestMethod.GET})
    public String dashoboard(HttpServletRequest request,
                       HttpServletResponse response, Model model){
        String userLoggedIn = request.getParameter("user");
        String memberuser = request.getParameter("memberuser") != null ? request.getParameter("memberuser") : "";
        request.getSession().setAttribute("user", userLoggedIn);
        request.getSession().setAttribute("memberuser", memberuser);
        logger.info("Load dashboard for {}",userLoggedIn);
        return "dashboard";
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
        }catch (Exception e){
            e.printStackTrace();
        }

        model.addAttribute("success", success);

        return "menus/eatableitems";
    }
}
