package demo.ssm.controller;

import demo.ssm.pojo.User;
import demo.ssm.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Objects;

@Controller
public class IndexController {

    @Autowired
    private IndexService indexService;

    //登录成功跳转到首页
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String getIndex(Integer userid, String userpassword, Model model){
        //验证用户账号密码
        User user = indexService.authenticateUser(userid, userpassword);
        model.addAttribute("user",user);
        if(user == null)
        {
            return "loginfail";
        }

        if(Objects.equals(user.getAdminflag(), "admin"))
        {
            return "index";
        }
        else if(Objects.equals(user.getAdminflag(), "teacher")){
            return "index_teacher";
        }
        else return "index_personal";
    }
}
