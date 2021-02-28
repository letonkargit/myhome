package com.myhome.controllers;

import com.myhome.beans.Users;
import com.myhome.beans.packaged.Profiles;
import com.myhome.services.ItemsService;
import com.myhome.services.UserService;
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
public class UserController {
    @Autowired ItemsService itemsService;
    @Autowired UserService userService;
    Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @RequestMapping(value = "/authuser", method= {RequestMethod.POST, RequestMethod.GET})
    public String authuser(HttpServletRequest request,
                       HttpServletResponse response, Model model){
        String userid = request.getParameter("uname");
        String password = request.getParameter("passwd");
        logger.info("user - {} and password {}", userid, password);

        if(userService.authenticate(userid, password)){
//            model.addAttribute("items", itemsService.fetchAllItems(userid));
            model.addAttribute("user",userid);
            request.getSession().setAttribute("user", userid);
            request.getSession().setAttribute("memberuser", "");
            return "dashboard";
        } else {
            model.addAttribute("invalidcred","true");
            return "index";
        }
    }

    @RequestMapping(value = "/signout", method= {RequestMethod.POST, RequestMethod.GET})
    public String signout(HttpServletRequest request,
                          HttpServletResponse response, Model model){
        request.getSession().invalidate();
        return "index";
    }

    @RequestMapping(value = "/setmember", method= {RequestMethod.POST, RequestMethod.GET})
    public String setmember(HttpServletRequest request,
                           HttpServletResponse response, Model model){
        String memberuser = request.getParameter("memberuser");
        logger.info("memberuser - {} ", memberuser);
        if(memberuser != null && !memberuser.isEmpty()){
            request.getSession().setAttribute("memberuser", memberuser);
        }
        return "dashboard";
    }

    @RequestMapping(value = "/showprofile", method= {RequestMethod.POST, RequestMethod.GET})
    public String showprofile(HttpServletRequest request,
                            HttpServletResponse response, Model model){
        String userLoggedIn = request.getParameter("user");

        List<Profiles> profiles = userService.fetchMembers(userLoggedIn);
        model.addAttribute("profiles", profiles);

        return "profile";
    }

    @RequestMapping(value = "/registeruser", method= {RequestMethod.POST, RequestMethod.GET})
    public String registeruser(HttpServletRequest request,
                            HttpServletResponse response, Model model){
        //Get params
        Users users = userService.registerUser(request);
        //Validate params and insert records
        //Finish registration
        //Set return fields and return
        request.getSession().setAttribute("user", users.getCs_username());
        request.getSession().setAttribute("memberuser", "");
        return "dashboard";
    }
}
