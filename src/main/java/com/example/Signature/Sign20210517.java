package com.example.Signature;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.io.BufferedReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.io.InputStreamReader;
import java.io.IOException;

public class Sign20210517 {
    private final static Charset UTF8 = StandardCharsets.UTF_8;
    /*private final static String SECRET_ID = "83f34e69dfd9432fbbd5fe4adf909e97";
    private final static String SECRET_KEY = "54d3dbfbb5fa4261b826ba1243446f74";*/
    //本地
    private final static String SECRET_ID = "85061081a3334c4faa8341204bb23cbe";
    private final static String SECRET_KEY = "53413593add14778860ff32173fd4289";
    //本地jigou
/*    private final static String SECRET_ID = "83f34e69dfd9432fbbd5fe4adf909e97";
    private final static String SECRET_KEY = "54d3dbfbb5fa4261b826ba1243446f74";*/

    //测试环境
/*    private final static String SECRET_ID = "f4057677b953486586871771c0cdf87c";
    private final static String SECRET_KEY = "290aa821a8e14fd38a69278184588e9c";*/



    public static byte[] hmac256(byte[] key, String msg) throws Exception {
        Mac mac = Mac.getInstance("HmacSHA256");
        SecretKeySpec secretKeySpec = new SecretKeySpec(key, mac.getAlgorithm());
        mac.init(secretKeySpec);
        return mac.doFinal(msg.getBytes(UTF8));
    }

    public static String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！" + e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    public static void main(String[] args) throws Exception {

        //String url = "http://localhost:18088/api/v1/tasks/69";
        String url = "http://localhost:18088/api/v1/tasks";

        //String url = "http://119.3.167.154:18091/api/v1/tasks";
        //String url = "http://119.3.167.154:18091/api/v1/tasks/11571";
        String jsonBody = "&basicTaskId=61&datasetId=6&taskName=复制api任务780";
        //String jsonBody = "&basicTaskId=61&datasetId=6&taskName=复制api任务781";
        //String jsonBody = "&basicTaskId=11569&datasetId=20191380&taskName=api接口";

        Long timestamp = System.currentTimeMillis();
        //Long timestamp = 1621245086186L;
        //System.out.println("timestamp = " + timestamp);

        String strToSign = url + "?" + "SecretId=" + SECRET_ID + "&Timestamp=" + timestamp + jsonBody;
        //String strToSign = url + "?" + "SecretId=" + SECRET_ID + "&Timestamp=" + timestamp;
        System.out.println(strToSign);

        // ************* 计算签名 *************
        //String signature = DatatypeConverter.printHexBinary(hmac256(SECRET_KEY.getBytes(UTF8), strToSign)).toLowerCase();
        String signature = HmacSha256(strToSign, SECRET_KEY);
        System.out.println(signature);
        // signature = "2f51f17d969884b8a111a94a39e87a85eb608ca0056c57077346ca8fc4109e00";


        // 请求路径
        String param = "SecretId=" + SECRET_ID + "&Signature=" + signature + "&Timestamp=" + timestamp;
        String reqUrl = url + "?" + param;
        System.out.println("请求路径：" + reqUrl);
        System.out.println(reqUrl);
//        String reqBackStr = sendPost(reqUrl, "");
//        System.out.println(reqBackStr);

    }

    public static String HmacSha256(String strToSign, String secretKey) throws Exception {
        Mac hmacSha256 = Mac.getInstance("HmacSHA256");
        SecretKeySpec secretKeyInit = new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8), "HmacSHA256");
        hmacSha256.init(secretKeyInit);
        byte[] array = hmacSha256.doFinal(strToSign.getBytes(StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder();
        for (byte item : array) {
            sb.append(Integer.toHexString((item & 0xFF) | 0x100).substring(1, 3));
        }
        return sb.toString().toLowerCase();
    }
}