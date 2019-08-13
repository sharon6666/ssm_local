package com.proxy.rpc;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: ssm
 * @Package: com.proxy
 * @Description: note
 * @Author:
 * @CreateDate: 2019-7-22 13:29
 * @UpdateUser:
 * @UpdateDate: 2019-7-22 13:29
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
public class RpcExport {
    private static int port = 1234;
    /**
     * 暴露服务
     */
    public static void export(final Object service) throws Exception {

        System.out.println("Export service " + service.getClass().getName() + " on port " + port);
        // 创建socket，开始监听
        ServerSocket server = new ServerSocket(port);
        while (true) {
            final Socket socket = server.accept();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    ObjectInputStream input = null;
                    ObjectOutputStream output = null;
                    try {
                        // 从监听的socket中获得输入流
                        input = new ObjectInputStream(socket.getInputStream());
                        String methodName = input.readUTF();
                        Class<?>[] parameterTypes = (Class<?>[]) input.readObject();
                        Object[] arguments = (Object[]) input.readObject();
                        // 从监听的socket中获得输出流
                        output = new ObjectOutputStream(socket.getOutputStream());
                        Method method = service.getClass().getMethod(methodName, parameterTypes);
                        Object result = method.invoke(service, arguments);
                        output.writeObject(result);
                    } catch (Exception e) {
                    } finally {
                        try {
                            if (output != null) {
                                output.close();
                            }
                            if (input != null) {
                                input.close();
                            }
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
    }
}
