package com.jin.acc.controller;

import com.jin.acc.Utils.Ajaxs;
import com.jin.acc.Utils.CheckUtils;
import com.jin.acc.entity.User;
import com.jin.acc.service.UserService;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class UserController {

    @Autowired
    private UserService us;

    @RequestMapping("/regi")
    public String toRegiPage(){
        return "regi";
    }

    @RequestMapping("/add")
    public String toAddPage(){
        return "add";
    }

    @RequestMapping("/inregi")
    @ResponseBody
    public Ajaxs re(User regiUser,String password2, HttpSession session){
        System.out.println("inregi");
        Ajaxs a=new Ajaxs();
        String psw=regiUser.getPassword();
        String email=regiUser.getEmail();
        String phone=regiUser.getPhone();
        User checkuser=us.getUserByName(regiUser.getUsername());

        if(checkuser!=null){
            a.setCode("err");
            a.setMsg("该用户已存在，请修改用户名！");
            return a;
        }

        if(psw.equals(password2)==false){
            a.setCode("err");
            a.setMsg("两次输入的密码不同！");
            return a;
        }

        if(CheckUtils.checkPhone(phone)==false){
            a.setCode("err");
            a.setMsg("手机号格式错误，请输入正确的手机号");
            return a;
        }

        if(CheckUtils.checkEmail(email)==false){
            a.setCode("err");
            a.setMsg("邮箱格式错误，请输入正确的邮箱！");
            return a;
        }
        int uid=us.getmaxUserId()+1;
        regiUser.setId(uid);
        us.addUser(regiUser);

        a.setCode("pass");
        String id=""+uid;
        a.setMsg("id");
        return a;
    }



    @RequestMapping("/edit/{user_id}")
    public ModelAndView toEditPage(HttpSession session, @PathVariable("user_id") Integer user_id){
        User user=us.getUserById(user_id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("edit");
        modelAndView.addObject("user",user);
        return modelAndView;
    }

    @RequestMapping("/inedit/{user_id}")
    @ResponseBody
    public Ajaxs ed(User temp,HttpSession session,@PathVariable("user_id") Integer user_id){
        System.out.println("inregi");
        Ajaxs a=new Ajaxs();
        String profile=temp.getProfile();
        String email=temp.getEmail();
        String phone=temp.getPhone();


        if(CheckUtils.checkPhone(phone)==false){
            a.setCode("err");
            a.setMsg("手机号格式错误，请输入正确的手机号");
            return a;
        }

        if(CheckUtils.checkEmail(email)==false){
            a.setCode("err");
            a.setMsg("邮箱格式错误，请输入正确的邮箱！");
            return a;
        }
        User user=us.getUserById(user_id);
        user.sets(temp);
        us.modifyUserById(user);
        String id=""+user_id;
        a.setCode("pass");
        a.setMsg(id);
        return a;
    }

    @RequestMapping("/manager")
    public ModelAndView mana(HttpServletRequest req, HttpSession session){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("manager");

        return modelAndView;
    }

    @RequestMapping("/tabs")
    @ResponseBody
    public Map<String, Object>  tableData(String id,HttpSession session){
        List<User> ulist=us.getAllUser();
        int count=us.getUserCount();
        Map<String, Object> resultMap = new HashMap<>();
        User user=new User();
        List<User> userAll = us.getAllUser();

        if(id!=null&&id!=""){
            int uid=Integer.parseInt(id);
            user=us.getUserById(uid);
            List<User> uu=new ArrayList<>();
            uu.add(user);

            if(user==null){ resultMap.put("data", userAll);}
            else {resultMap.put("data", uu);count=1;}

        }
        else resultMap.put("data", userAll);

        resultMap.put("code", "0");
        resultMap.put("msg", "");
        resultMap.put("count", count);
        return resultMap;
    }


    @RequestMapping("/dele/{user_id}")
    public String  delete(HttpSession session,@PathVariable("user_id") Integer user_id){
        System.out.println("dele:"+user_id);
        //User user=us.getUserById(user_id);
        us.deleUserById(user_id);
        return "/manager";

    }

    @RequestMapping("/modi/{user_id}/{value}")
    public String  modifyProfile(HttpSession session,@PathVariable("user_id") Integer user_id
            ,@PathVariable("value") String value){
        System.out.println("modi:"+user_id);
        User user=us.getUserById(user_id);
        user.setProfile(value);
        us.modifyUserById(user);
        return "/manager";

    }

}
