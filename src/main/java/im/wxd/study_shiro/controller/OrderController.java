package im.wxd.study_shiro.controller;

import im.wxd.study_shiro.domian.JsonData;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("authc")
public class OrderController {

    @RequestMapping("/video/play_record")
    public JsonData findMyBuyRecord(){
        Map<String,Object> returnMap = new HashMap<>();

        returnMap.put("msg","获取成功");

        return JsonData.buildSuccess(returnMap);
    }
}
