package im.wxd.study_shiro.controller;

import im.wxd.study_shiro.domian.JsonData;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("admin")
public class AdminController {

    @RequestMapping("/video/order")
    public JsonData findOrder(){
        Map<String,Object> returnMap = new HashMap<>();

        returnMap.put("msg","获取成功");

        return JsonData.buildSuccess(returnMap);
    }
}
