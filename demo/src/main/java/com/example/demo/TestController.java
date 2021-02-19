package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TestController
 * @Description: TODO
 * @Author zhiHao
 * @Date 2020/3/24
 * @Version V1.0
 **/
@RestController
public class TestController {

    @GetMapping("/")
    public String hello(@RequestParam String parm){
        System.out.println(parm);
        String str = "hello world："+parm;
        return str;
    }

}
