package org.example.net;

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws Exception {
        // 创建ServerSocket对象，监听8888端口
        ServerSocket serverSocket = new ServerSocket(8888);

        while (true) {
            // 等待客户端连接
            Socket socket = serverSocket.accept();
            System.out.println("Client Connected");

            // 获取输入流，读取客户端发送的消息
            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String message = br.readLine();
            System.out.println("Client Message: " + message);

            // 获取输出流，向客户端发送消息
            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os);
            pw.write("Hello Client");
            pw.flush();

            // 关闭资源
            pw.close();
            os.close();
            br.close();
            is.close();
            socket.close();
        }
    }
}
