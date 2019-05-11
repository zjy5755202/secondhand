package com.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class SocketToPython {
    public static final String IP_ADDR="127.0.0.1";
    public static final int PORT=8001;

    public static JSONObject getLoginState(String jsonstr){
        Socket socket=null;
        try {
            socket=new Socket(IP_ADDR,PORT);
            OutputStream os=socket.getOutputStream();
            PrintStream out=new PrintStream(os);
            out.print(jsonstr);
            System.out.print("SocketToPython"+jsonstr);
            //out.print("over");
            InputStream is=socket.getInputStream();
            BufferedReader br=new BufferedReader(new InputStreamReader(is,"utf-8"));
            String tmp=null;
            StringBuilder sb=new StringBuilder();

            while((tmp=br.readLine())!=null)
                sb.append(tmp).append('\n');
            JSONObject res=(JSONObject) JSON.parse(sb.toString());
            return res;
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {if(socket!=null) socket.close();} catch (IOException e) {}
        }
        return null;
    }



    public static JSONObject sendGet(String param) {
        String result = "";
        BufferedReader in = null;
        try {
            String url="http://localhost:8001/login";
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
//            for (String key : map.keySet()) {
//                System.out.println(key + "--->" + map.get(key));
//            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return (JSONObject) JSON.parse(result);
    }



}
