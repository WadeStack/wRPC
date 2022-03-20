package org.wuuijkl.wrpc.example;

import org.wuuijkl.wrpc.server.RpcServer;

/**
 * @Author wade
 * @Date 2022/3/20 12:18
 * @Description
 */
public class Server {
    public static void main(String[] args) {
        RpcServer server = new RpcServer();
        server.register(CalcService.class, new CalcServiceImpl());
        server.start();
    }
}
