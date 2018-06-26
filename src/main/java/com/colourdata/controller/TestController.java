package com.colourdata.controller;

import com.alibaba.fastjson.JSONObject;
import com.colourdata.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class TestController {
    @Autowired
    private TestService testService;

    private static Logger logger = LoggerFactory.getLogger(TestController.class);

    @RequestMapping("/test.do")
    @ResponseBody
    public String test(){
        List<Map> list = testService.test01();
        logger.debug("test begin..");
        return JSONObject.toJSONString(list);
    }

    @RequestMapping("/test01.do")
    @ResponseBody
    public String test01(){
        return "123";
    }
}
