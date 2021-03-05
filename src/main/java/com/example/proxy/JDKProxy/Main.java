package com.example.proxy.JDKProxy;

import com.example.proxy.staticProxy.SmsProxy;
import com.example.proxy.staticProxy.SmsService;
import com.example.proxy.staticProxy.SmsServiceImpl;

/**
 * @ClassName main
 * @Description: TODO
 * @Author zhiHao
 * @Date 2021/3/5
 * @Version V1.0
 **/
public class Main {
    public static void main(String[] args) {
        SmsService smsService = (SmsService) JdkProxyFactory.getProxy(new SmsServiceImpl());
        smsService.send("java");
    }
}
