package com.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.net.Socket;

public class SocketToPython1 {
    public static final String IP_ADDR="127.0.0.1";
    public static final int PORT=8080;
    public Object remoteCall(String jsonstr){
        Socket socket=null;

        try {
            socket=new Socket(IP_ADDR,PORT);
            OutputStream os=socket.getOutputStream();
            PrintStream out=new PrintStream(os);
            out.print(jsonstr);
            out.print("over");

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


}
