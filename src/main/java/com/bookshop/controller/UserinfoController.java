package com.bookshop.controller;

import com.bookshop.beans.Book;
import com.bookshop.beans.Msg;
import com.bookshop.beans.Userinfo;
import com.bookshop.service.UserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
public class UserinfoController {
    @Autowired
    UserinfoService userinfoService;


    /*注册*/
    @RequestMapping(value = "/addUserinfo")
    public String addUserinfo(Userinfo userinfo){
        userinfoService.addUser(userinfo);
        return "login";
    }

    /*根据条件查询用户内容，用于登录*/
    @RequestMapping(value = "/getUserinfoById")
    @ResponseBody
    public Msg getUserinfoById(@RequestParam("userId")int userid,
                               @RequestParam("pwd")int pwd,
                               HttpServletRequest request){
        Userinfo userinfo=userinfoService.selectUser(userid);
        if(userinfo.getUserid()==userid&&userinfo.getPassword()==pwd){
            HttpSession session=request.getSession(true);
            session.setAttribute("user",userinfo);
        }
        return Msg.success().add("selectUser",userinfo);
    }

    /*根据条件查询用户内容，用于修改*/
    @RequestMapping(value = "/toPersonalInformationChange")
    public String toPersonalInformationChange(HttpServletRequest request){
        HttpSession session=request.getSession();
        Userinfo user=(Userinfo)session.getAttribute("user");
        Userinfo userinfo=userinfoService.selectUser(user.getUserid());
        request.setAttribute("userinfo",userinfo);
        return "personalInformationChange";
    }

    /*更新用户内容*/
    @RequestMapping(value = "/updateUserinfo")
    public String updateUserinfo(Userinfo userinfo,HttpServletRequest request){

        HttpSession session=request.getSession();
        Userinfo session_user=(Userinfo) session.getAttribute("user");
        userinfo.setUserid(session_user.getUserid());

        System.out.println(userinfo.getUserid()+userinfo.getUsername()+userinfo.getPassword()+userinfo.getLocation()+userinfo.getPhone());
        userinfoService.update(userinfo);

        Userinfo db_user=userinfoService.selectUser(session_user.getUserid());
        session.setAttribute("user",db_user);

        return "redirect:/toPersonalCenter";
    }


}
