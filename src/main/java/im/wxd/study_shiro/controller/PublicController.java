package im.wxd.study_shiro.controller;


import im.wxd.study_shiro.domian.JsonData;
import im.wxd.study_shiro.domian.UserQuery;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/pub")
public class PublicController {



    @RequestMapping("/need_login")
    public JsonData needLogin(){
        return JsonData.buildSuccess("温馨提示：当前操作需要登录账号","-2");
    }

    @RequestMapping("/not_permit")
    public JsonData notPermit(){
        return JsonData.buildSuccess("当前操作，此账号没有相关权限","-3");
    }

    @RequestMapping("/index")
    public JsonData index(){
        List<String> indexList = new ArrayList<>();
        indexList.add("测试数据1");
        indexList.add("测试数据2");
        indexList.add("测试数据3");
        indexList.add("测试数据4");
        indexList.add("测试数据5");
        return JsonData.buildSuccess(indexList);
    }

    @PostMapping(value = "/login")
    public JsonData login(@RequestBody UserQuery userQuery){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(userQuery.getName(),userQuery.getPwd());
        Map<String, Object> info = new HashMap<>();
        try {
            subject.login(usernamePasswordToken);
            info.put("sessionId", subject.getSession().getId());
            info.put("msg", "登陆成功");
            return JsonData.buildSuccess(info);
        } catch (Exception e){
            e.printStackTrace();
            return JsonData.buildError("账号密码错误");
        }
    }


}
