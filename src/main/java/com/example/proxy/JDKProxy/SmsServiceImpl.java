package com.example.proxy.JDKProxy;

/**
 * @ClassName SmsServiceImpl
 * @Description: TODO
 * @Author zhiHao
 * @Date 2021/3/5
 * @Version V1.0
 **/
public class SmsServiceImpl implements SmsService {
    @Override
    public String send(String message) {
        System.out.println("send message:" + message);
        return message;
    }
}
