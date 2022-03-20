package org.wuuijkl.wrpc.example;

import org.wuuijkl.wrpc.client.RpcClient;

/**
 * @Author wade
 * @Date 2022/3/20 12:18
 * @Description
 */
public class Client {
    public static void main(String[] args) {
        RpcClient client = new RpcClient();
        CalcService service = client.getProxy(CalcService.class);
        int res1 = service.sum(1, 2);
        int res2 = service.sub(5, 3);

        System.out.println(res1);
        System.out.println(res2);
    }
}
