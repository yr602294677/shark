package com.yangrui.shark.search.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yangrui.shark.utils.PostUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value="/search")
public class SearchController {

  @Autowired
  private StringRedisTemplate stringRedisTemplate;
  @Autowired
  private RedisTemplate redisTemplate;

  @RequestMapping("/showEverything")
  public String showEverything(Model model){
    return "thymeleaf/search/everything";
  }

  @RequestMapping("/serarchEverything")
  public String serarchEverything(@RequestParam("para") String para, Model model){
    Map map=new HashMap();
    if("".equals(para)||""==para){
      map.put("查询结果","未输入查询内容，请输入关键词重新搜索！");
      model.addAttribute("map",map);
      return "thymeleaf/search/everything";
    }
    String url = "https://api.ownthink.com/kg/knowledge";
    String param = "entity="+para;
    String result;
    if(!"".equals(stringRedisTemplate.opsForValue().get(para))&&stringRedisTemplate.opsForValue().get(para)!=null){
        result =stringRedisTemplate.opsForValue().get(para);
      System.out.println("使用缓存，key为"+para);
    }else{
      result = PostUtils.dispachPackageDataByPostUrl(url,param);
      stringRedisTemplate.opsForValue().set(para, result,30, TimeUnit.SECONDS);
      System.out.println("新增缓存，key为"+para+"时效为30s");
    }
    JSONObject jsonObject = JSON.parseObject(result);
    JSONObject data = JSON.parseObject(jsonObject.getString("data"));
    if(data.size()==0){
     map.put("查询结果","未查询到内容，请更换关键词重新搜索！");
      model.addAttribute("map",map);
      return "thymeleaf/search/everything";
   }
    StringBuilder tempStr=new StringBuilder();
    String temp="";
    JSONArray array = data.getJSONArray("avp");
    for (int i = 0; i <array.size() ; i++) {
      String[] s = array.getObject(i, String[].class);
      if(!s[0].equals(temp)){
        tempStr.setLength(0);
        map.put(s[0],s[1]);
        temp=s[0];
        tempStr.append(s[1]).append(",");
      }else{
        tempStr.append(s[1]).append(",");
        map.put(s[0],tempStr.toString());
      }
    }
    model.addAttribute("map",map);
    return "thymeleaf/search/everything";
  }
}
