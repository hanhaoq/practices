package org.example.net;

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws Exception {
        // 创建Socket对象，连接服务器
        Socket socket = new Socket("localhost", 8888);

        // 获取输出流，向服务器发送消息
        OutputStream os = socket.getOutputStream();
        PrintWriter pw = new PrintWriter(os);
        pw.write("Hello Server");
        pw.flush();

        // 获取输入流，读取服务器返回的消息
        InputStream is = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String message = br.readLine();
        System.out.println("Server Message: " + message);

        // 关闭资源
        pw.close();
        os.close();
        br.close();
        is.close();
        socket.close();
    }
}
