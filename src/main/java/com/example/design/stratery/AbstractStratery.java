package com.example.design.stratery;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName AbstractStratery
 * @Description: TODO
 * @Author zhiHao
 * @Date 2021/2/8
 * @Version V1.0
 **/
public class AbstractStratery {
    private static String zhanmu = "zhanmu";
    private static String tiliang = "tiliang";
    private static String littlerose = "littlerose";

    static Map<String,IStratery> map = new HashMap<String,IStratery>();

    static {
        map.put(zhanmu,new AStratery());
        map.put(tiliang,new BStratery());
        map.put(littlerose,new BStratery());
    }

    static void  invoke(String name){
        if (name != null) {
            map.get(name).operator();
        }
    }
}
