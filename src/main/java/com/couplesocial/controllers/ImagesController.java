package com.couplesocial.controllers;

import com.couplesocial.beans.CoupleMembers;
import com.couplesocial.beans.packaged.Profiles;
import com.couplesocial.common.config.CommonConfig;
import com.couplesocial.dao.MenuDao;
import com.couplesocial.dao.UserDao;
import com.couplesocial.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import static com.couplesocial.common.constants.CommonConstant.*;

@Controller
public class ImagesController {
    @Autowired CommonConfig commonConfig;
    @Autowired UserService userService;
    @Autowired UserDao userDao;
    Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @RequestMapping(value = "/image", method= {RequestMethod.POST, RequestMethod.GET})
    public void imageget(HttpServletRequest request,
                         HttpServletResponse response, Model model){
        String imagepath = request.getParameter("imagepath");

        try(
                FileInputStream fis = new FileInputStream(new File(imagepath));
                BufferedInputStream bis = new BufferedInputStream(fis);
        ) {

            response.setContentType(request.getServletContext().getMimeType(imagepath));
            OutputStream outputStream = response.getOutputStream();
            for (int data; (data = bis.read()) > -1;) {
                outputStream.write(data);
            }
            outputStream.flush();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/imageupload", method= {RequestMethod.POST, RequestMethod.GET})
    public String uploadImage(@RequestParam("profimage") MultipartFile multipartFile, HttpServletRequest request,
                            HttpServletResponse response, Model model){
        request.getParameterNames();
        String user = request.getParameter("user");
        String member_id = request.getParameter("member_id");
        String imagetype = request.getParameter("imagetype");

        try{
            logger.info("Uploading {} as {} for user {}",multipartFile.getOriginalFilename(), member_id, user);
            String extension = multipartFile.getOriginalFilename().contains(".") ?
                    multipartFile.getOriginalFilename().split("\\.")[multipartFile.getOriginalFilename().split("\\.").length-1] :
                    "";

            String image = "";
            if(imagetype.equals(IMAGE_PROFILEPIC)){
                image = commonConfig.getProfileImagesPath() + member_id + "." + extension;
            } else if(imagetype.equals(IMAGE_LOCATION)){
                image = commonConfig.getLocationImage() + member_id + "." + extension;
            }

            //Upload file
            Files.write(Paths.get(image),
                    multipartFile.getBytes());

            //Map member id
            //TODO : archive if already exists
            userDao.updateProfileMemberId(member_id, member_id+"."+extension);

            //Set profiles back
            List<Profiles> profiles = userService.fetchMembers(user);
            model.addAttribute("profiles", profiles);

        }catch (Exception e){
            e.printStackTrace();
        }

        return "profile";
    }
}
