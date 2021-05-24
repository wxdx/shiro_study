package im.wxd.study_shiro.controller;

import im.wxd.study_shiro.domian.JsonData;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("video")
public class VideoController {

    @RequestMapping("/delete")
    public JsonData delete(){
        Map<String,Object> returnMap = new HashMap<>();

        returnMap.put("msg","删除成功");

        return JsonData.buildSuccess(returnMap);
    }
}
