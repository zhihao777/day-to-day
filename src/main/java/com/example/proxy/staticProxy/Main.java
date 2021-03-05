package com.example.proxy.staticProxy;

/**
 * @ClassName main
 * @Description: TODO
 * @Author zhiHao
 * @Date 2021/3/5
 * @Version V1.0
 **/
public class Main {
    public static void main(String[] args) {
        SmsService smsService = new SmsServiceImpl();
        SmsProxy smsProxy = new SmsProxy(smsService);
        smsProxy.send("java");
    }
}
