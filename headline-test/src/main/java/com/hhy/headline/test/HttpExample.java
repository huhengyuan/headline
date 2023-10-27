package com.hhy.headline.test;
import java.net.*;
import java.io.*;
/**
 * @Author hhy
 * @PackageName headline
 * @Package com.hhy.headline.test
 * @Date 2023/10/24 17:38
 * @return
 * @Version 1.0
 */
public class HttpExample {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://47.94.5.22:9752/api/Employee/getEmployee"); // 设置目标URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection(); // 打开连接

            connection.setRequestMethod("GET"); // 设置请求方法
            int responseCode = connection.getResponseCode(); // 获取响应码

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream())); // 获取输入流
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close(); // 关闭流

            System.out.println("Response Code: " + responseCode);
            System.out.println("Response Content: " + content.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
