package com.jin.acc.controller;

import com.jin.acc.Utils.Ajaxs;
import com.jin.acc.entity.User;
import com.jin.acc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class LoginConrtoller {
    @Autowired
    private UserService us;

    @RequestMapping("/login")
    public String toLoginPage(){
        return "login";
    }

    @RequestMapping("/inlogin")//ajax
    @ResponseBody
    public Ajaxs log(User user ,HttpSession session){
        //System.out.println("inlogin:"+user.getUsername()+",psw="+user.getUsername());
        String loginname=user.getUsername();
        String loginpsw=user.getPassword();
        Ajaxs a=new Ajaxs();//ajax信息

        boolean pass=us.verify(loginname,loginpsw);
        User thisuser=us.getUserByName(loginname);
        if(pass==false){//登录失败，提示

                if(thisuser==null){a.setCode("404");a.setMsg("该用户不存在！");}
                else{a.setCode("error");a.setMsg("用户名或密码错误！");}

            return a;
        }
        else  {//登录成功，进入个人信息页面
            session.setAttribute("user",thisuser);
            String uid=""+thisuser.getId();
            a.setCode("pass");
            a.setMsg(uid);
            return a;
        }
    }

    @RequestMapping("/logout")
    public String out(HttpSession session){
        System.out.println("-logout");
        session.invalidate();
        return "redirect:/login";
    }

    @RequestMapping("/intercept")
    public String warn(HttpSession session){
        return "intercept";
    }
}
