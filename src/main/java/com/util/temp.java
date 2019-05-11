//package com.util;
//
//import com.alibaba.fastjson.JSONObject;
//import java.io.BufferedInputStream;
//import java.io.DataInputStream;
//import java.io.DataOutputStream;
//import java.io.IOException;
//import java.net.Socket;
//
//public class SocketToPython {
//    public static final String IP_ADDR="127.0.0.1";
//    public static final int PORT=8080;
//
//    public static JSONObject getLoginState(String username,String password) throws IOException {
//        JSONObject result=null;
//        while(true){
//            Socket socket=null;
//            try{
//                socket=new Socket(IP_ADDR,PORT);
//                JSONObject json=new JSONObject();
//                json.put("username",username);
//                json.put("password",password);
//                String jsonString=json.toString();
//                byte[] jsonByte=jsonString.getBytes();
//                DataOutputStream outputStream = null;
//                outputStream = new DataOutputStream(socket.getOutputStream());
//                outputStream.write(jsonByte);
//                outputStream.flush();
//                socket.shutdownOutput();
//                //读取服务器端数据
//                DataInputStream inputStream = null;
//                String strInputstream ="";
//                inputStream = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
//                strInputstream=inputStream.readUTF();
//                System.out.println("输入信息为："+strInputstream);
//                result = (JSONObject) JSONObject.parse(strInputstream);
//                // 如接收到 "OK" 则断开连接
//                if (result != null) {
//                    System.out.println("客户端将关闭连接");
//                    Thread.sleep(500);
//                    break;
//                }
//
//            } catch (Exception e) {
//                System.out.println("客户端异常:" + e.getMessage());
//                break;
//            } finally {
//                if (socket != null) {
//                    try {
//                        socket.close();
//                    } catch (IOException e) {
//                        socket = null;
//                        System.out.println("客户端 finally 异常:" + e.getMessage());
//                    }
//                }
//            }
//        }
//
//        return result;
//    }
//}
