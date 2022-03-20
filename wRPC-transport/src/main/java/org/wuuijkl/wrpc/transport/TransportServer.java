package org.wuuijkl.wrpc.transport;

/**
 * @Author wade
 * @Date 2022/3/19 22:08
 * @Description
 * @Step 1、启动&监听
 * 2、接受请求
 * 3、关闭监听
 */
public interface TransportServer {
    void init(int port, RequestHandler handler);

    void start();

    void stop();
}
